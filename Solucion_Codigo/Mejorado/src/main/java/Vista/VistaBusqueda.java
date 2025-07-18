package Vista;

import java.util.Scanner;

public class VistaBusqueda {
    private Scanner scanner;

    public VistaBusqueda(Scanner scanner) {
        this.scanner = scanner;
    }

    public void mostrarMenuBusqueda() {
        System.out.println("\n=== BUSCAR RUTAS ===");
        System.out.print("Ingrese nombre de parada: ");
        String parada = scanner.nextLine();
        
        System.out.print("Ingrese hora de viaje (HH:MM): ");
        String hora = scanner.nextLine();
        
        // Estos valores normalmente se pasarían al controlador
        System.out.println("\nBuscando rutas en la parada '" + parada + "' a las " + hora);
        System.out.println("(Esta funcionalidad se conectaría con el ControladorBuscador)");
        
        // Simulación de resultados
        System.out.println("\nResultados encontrados:");
        System.out.println("1. Ruta 12 - Centro Universitario - Salida: 07:30");
        System.out.println("2. Ruta 5 - Terminal Norte - Salida: 07:45");
    }
}