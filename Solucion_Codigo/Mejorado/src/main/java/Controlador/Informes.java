package Controlador;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Informes {
    public String generarInformeLineas(List<Linea> lineas, List<OptimizacionRutas.AnalisisLinea> analisis) {
        StringBuilder informe = new StringBuilder();
        
        informe.append("=== LINEAS MAS CONCURRIDAS ===\n");
        analisis.stream()
            .sorted(Comparator.comparingDouble(a -> -a.porcentajeOcupacion))
            .limit(3)
            .forEach(a -> informe.append(String.format(
                "Linea %s: %.2f%% ocupacin\n", 
                a.linea.getIdLinea(), a.porcentajeOcupacion))); 
        
        informe.append("\n=== LINEAS MENOS CONCURRIDAS ===\n");
        analisis.stream()
            .sorted(Comparator.comparingDouble(a -> a.porcentajeOcupacion))
            .limit(3)
            .forEach(a -> informe.append(String.format(
                "Línea %s: %.2f%% ocupacion\n", 
                a.linea.getIdLinea(), a.porcentajeOcupacion))); 
        
        double promedio = analisis.stream()
            .mapToDouble(a -> a.porcentajeOcupacion)
            .average()
            .orElse(0);
        
        long lineasFavorables = analisis.stream() 
            .filter(a -> a.esFavorable)
            .count();
        
        informe.append("\n=== RESUMEN ESTADISTICO ===\n")
              .append(String.format("Total lineas: %d\n", lineas.size())) 
              .append(String.format("Ocupacion promedio: %.2f%%\n", promedio))
              .append(String.format("Lineas con buen desempeño: %d\n", lineasFavorables)) 
              .append(String.format("Lneas que requieren ajustes: %d", 
                     lineas.size() - lineasFavorables));
        
        return informe.toString();
    }
}
