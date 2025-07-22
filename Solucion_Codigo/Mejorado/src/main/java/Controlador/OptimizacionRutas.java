package Controlador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OptimizacionRutas {
    private static final double UMBRAL_FAVORABLE = 60.0;
    private Connection conexion;
    private Random random;

    public OptimizacionRutas(Connection conexion) {
        this.conexion = conexion;
        this.random = new Random();
    }

    public AnalisisLinea analizarLinea(Linea linea, int totalViajes, int viajesConPasajeros) {
        double porcentajeOcupacion = calcularPorcentajeOcupacion(totalViajes, viajesConPasajeros);
        boolean esFavorable = porcentajeOcupacion >= UMBRAL_FAVORABLE;
        List<String> recomendaciones = generarRecomendaciones(porcentajeOcupacion);

        return new AnalisisLinea(linea, porcentajeOcupacion, esFavorable, recomendaciones);
    }

    public List<AnalisisLinea> analizarTodasLasLineas() {
        List<AnalisisLinea> analisisLineas = new ArrayList<>();
        String sql = "SELECT id_linea, nombre, paradas FROM lineas ORDER BY id_linea";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Linea linea = new Linea(rs.getString("id_linea"), rs.getString("nombre"));
                linea.setParadas(rs.getString("paradas"));
                double porcentajeOcupacion = Math.random() * 100;
                boolean esFavorable = porcentajeOcupacion >= UMBRAL_FAVORABLE;
                List<String> recomendaciones = generarRecomendaciones(porcentajeOcupacion);

                analisisLineas.add(new AnalisisLinea(linea, porcentajeOcupacion, esFavorable, recomendaciones));
            }
        } catch (SQLException e) {
            System.err.println("Error al analizar líneas: " + e.getMessage());
        }

        return analisisLineas;
    }

    private double calcularPorcentajeOcupacion(int totalViajes, int viajesConPasajeros) {
        if (totalViajes == 0)
            return 0.0;
        return (viajesConPasajeros * 100.0) / totalViajes;
    }

    private List<String> generarRecomendaciones(double porcentaje) {
        List<String> recomendaciones = new ArrayList<>();

        if (porcentaje < 30) {
            recomendaciones.add("Eliminar línea por baja demanda");
            recomendaciones.add("Evaluar fusión con otras líneas");
        } else if (porcentaje < UMBRAL_FAVORABLE) {
            recomendaciones.add("Ajustar horarios para mayor demanda");
            recomendaciones.add("Agregar paradas estratégicas");
            recomendaciones.add("Reducir frecuencia de viajes");
        } else {
            recomendaciones.add("Línea con buen desempeño");
            if (porcentaje > 85) {
                recomendaciones.add("Considerar aumentar frecuencia");
                recomendaciones.add("Evaluar buses de mayor capacidad");
            }
        }

        return recomendaciones;
    }

    public static class AnalisisLinea {
        public final Linea linea;
        public final double porcentajeOcupacion;
        public final boolean esFavorable;
        public final List<String> recomendaciones;

        public AnalisisLinea(Linea linea, double porcentaje, boolean favorable, List<String> recomendaciones) {
            this.linea = linea;
            this.porcentajeOcupacion = porcentaje;
            this.esFavorable = favorable;
            this.recomendaciones = recomendaciones;
        }

        @Override
        public String toString() {
            return String.format("AnalisisLinea{linea=%s, ocupacion=%.2f%%, favorable=%s}",
                    linea.getIdLinea(), porcentajeOcupacion, esFavorable);
        }
    }
}