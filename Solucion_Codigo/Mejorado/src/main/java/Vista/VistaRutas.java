package Vista;

import java.util.Scanner;

public class VistaRutas {
    private Scanner scanner;

    public VistaRutas(Scanner scanner) {
        this.scanner = scanner;
    }

    public void mostrarMenuRutas() {
        System.out.println("\n=== GESTIÓN DE RUTAS ===");
        System.out.println("1. Ver todas las rutas");
        System.out.println("2. Optimizar rutas");
        System.out.println("3. Modificar ruta");
        System.out.print("Seleccione una opción: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        switch (opcion) {
            case 1:
                mostrarTodasLasRutas();
                break;
            case 2:
                optimizarRutas();
                break;
            case 3:
                modificarRuta();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    private void mostrarTodasLasRutas() {
        System.out.println("\n=== LISTADO DE RUTAS ===");
        // Simulación de datos
        System.out.println("Ruta 12: Centro Universitario - Terminal Norte");
        System.out.println("Ruta 5: Terminal Sur - Parque Industrial");
    }

    private void optimizarRutas() {
        System.out.println("\n=== OPTIMIZACIÓN DE RUTAS ===");
        System.out.println("Analizando rendimiento de rutas...");
        // Simulación de análisis
        System.out.println("Ruta 12: 78% de ocupación (Óptima)");
        System.out.println("Ruta 5: 45% de ocupación (Requiere ajustes)");
    }

    private void modificarRuta() {
        System.out.println("\n=== MODIFICAR RUTA ===");
        System.out.print("Ingrese ID de ruta a modificar: ");
        String idRuta = scanner.nextLine();
        
        System.out.println("Opciones para la ruta " + idRuta + ":");
        System.out.println("1. Agregar paradas");
        System.out.println("2. Ajustar horarios");
        System.out.println("3. Asignar nuevo bus");
        
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Modificación realizada con éxito");
    }
}