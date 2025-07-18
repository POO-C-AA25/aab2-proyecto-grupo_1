/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.*;
import java.util.ArrayList;
import java.util.List;

public class OptimizacionRutas {
    private static final double UMBRAL_FAVORABLE = 60.0;
    
    public AnalisisRuta analizarRuta(Ruta ruta, int totalViajes, int viajesConPasajeros) {
        double porcentajeOcupacion = calcularPorcentajeOcupacion(totalViajes, viajesConPasajeros);
        boolean esFavorable = porcentajeOcupacion >= UMBRAL_FAVORABLE;
        List<String> recomendaciones = generarRecomendaciones(porcentajeOcupacion);
        
        return new AnalisisRuta(ruta, porcentajeOcupacion, esFavorable, recomendaciones);
    }

    private double calcularPorcentajeOcupacion(int totalViajes, int viajesConPasajeros) {
        return (viajesConPasajeros * 100.0) / totalViajes;
    }

    private List<String> generarRecomendaciones(double porcentaje) {
        List<String> recomendaciones = new ArrayList<>();
        
        if (porcentaje < 30) {
            recomendaciones.add("Eliminar ruta por baja demanda");
        } else if (porcentaje < UMBRAL_FAVORABLE) {
            recomendaciones.add("Ajustar horarios");
            recomendaciones.add("Agregar paradas estratégicas");
            recomendaciones.add("Reducir frecuencia de viajes");
        }
        
        return recomendaciones;
    }

    public class AnalisisRuta {
        public final Ruta ruta;
        public final double porcentajeOcupacion;
        public final boolean esFavorable;
        public final List<String> recomendaciones;

        public AnalisisRuta(Ruta ruta, double porcentaje, boolean favorable, List<String> recomendaciones) {
            this.ruta = ruta;
            this.porcentajeOcupacion = porcentaje;
            this.esFavorable = favorable;
            this.recomendaciones = recomendaciones;
        }
    }
}
