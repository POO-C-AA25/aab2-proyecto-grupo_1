/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Informes {
    public String generarInformeRutas(List<Ruta> rutas, List<OptimizacionRutas.AnalisisRuta> analisis) {
        StringBuilder informe = new StringBuilder();
        
        // Rutas más concurridas
        informe.append("=== RUTAS MÁS CONCURRIDAS ===\n");
        analisis.stream()
            .sorted(Comparator.comparingDouble(a -> -a.porcentajeOcupacion))
            .limit(3)
            .forEach(a -> informe.append(String.format(
                "Ruta %s: %.2f%% ocupación\n", 
                a.ruta.getId(), a.porcentajeOcupacion)));
        
        // Rutas menos concurridas
        informe.append("\n=== RUTAS MENOS CONCURRIDAS ===\n");
        analisis.stream()
            .sorted(Comparator.comparingDouble(a -> a.porcentajeOcupacion))
            .limit(3)
            .forEach(a -> informe.append(String.format(
                "Ruta %s: %.2f%% ocupación\n", 
                a.ruta.getId(), a.porcentajeOcupacion)));
        
        // Resumen estadístico
        double promedio = analisis.stream()
            .mapToDouble(a -> a.porcentajeOcupacion)
            .average()
            .orElse(0);
        
        long rutasFavorables = analisis.stream()
            .filter(a -> a.esFavorable)
            .count();
        
        informe.append("\n=== RESUMEN ESTADÍSTICO ===\n")
              .append(String.format("Total rutas: %d\n", rutas.size()))
              .append(String.format("Ocupación promedio: %.2f%%\n", promedio))
              .append(String.format("Rutas con buen desempeño: %d\n", rutasFavorables))
              .append(String.format("Rutas que requieren ajustes: %d", 
                     rutas.size() - rutasFavorables));
        
        return informe.toString();
    }
}
