package Controlador;

import java.util.ArrayList;
import java.util.List;

public class OptimizacionRutas {
    private static final double UMBRAL_FAVORABLE = 60.0;
    
    public AnalisisLinea analizarLinea(Linea linea, int totalViajes, int viajesConPasajeros) {
        double porcentajeOcupacion = calcularPorcentajeOcupacion(totalViajes, viajesConPasajeros);
        boolean esFavorable = porcentajeOcupacion >= UMBRAL_FAVORABLE;
        List<String> recomendaciones = generarRecomendaciones(porcentajeOcupacion);
        
        return new AnalisisLinea(linea, porcentajeOcupacion, esFavorable, recomendaciones);
    }

    private double calcularPorcentajeOcupacion(int totalViajes, int viajesConPasajeros) {
        if (totalViajes == 0) return 0.0; 
        return (viajesConPasajeros * 100.0) / totalViajes;
    }

    private List<String> generarRecomendaciones(double porcentaje) {
        List<String> recomendaciones = new ArrayList<>();
        
        if (porcentaje < 30) {
            recomendaciones.add("Eliminar linea por baja demanda");
        } else if (porcentaje < UMBRAL_FAVORABLE) {
            recomendaciones.add("Ajustar horarios");
            recomendaciones.add("Agregar paradas estrategicas");
            recomendaciones.add("Reducir frecuencia de viajes");
        } else {
            recomendaciones.add("Linea con buen desempeño."); 
        }
        
        return recomendaciones;
    }

    public class AnalisisLinea {
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
    }
}
