package Vista;

import java.util.Scanner;

public class VistaInformes {
    private Scanner scanner;

    public VistaInformes(Scanner scanner) {
        this.scanner = scanner;
    }

    public void mostrarMenuInformes() {
        System.out.println("\n=== REPORTES E INFORMES ===");
        System.out.println("1. Rutas más concurridas");
        System.out.println("2. Rutas menos concurridas");
        System.out.println("3. Informe completo");
        System.out.print("Seleccione una opción: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcion) {
            case 1:
                mostrarRutasConcurridas();
                break;
            case 2:
                mostrarRutasMenosConcurridas();
                break;
            case 3:
                generarInformeCompleto();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    private void mostrarRutasConcurridas() {
        System.out.println("\n=== RUTAS MÁS CONCURRIDAS ===");
        System.out.println("1. Ruta 12 - 85% de ocupación promedio");
        System.out.println("2. Ruta 8 - 78% de ocupación promedio");
    }

    private void mostrarRutasMenosConcurridas() {
        System.out.println("\n=== RUTAS MENOS CONCURRIDAS ===");
        System.out.println("1. Ruta 5 - 45% de ocupación promedio");
        System.out.println("2. Ruta 3 - 52% de ocupación promedio");
    }

    private void generarInformeCompleto() {
        System.out.println("\n=== INFORME COMPLETO ===");
        System.out.println("Total rutas: 15");
        System.out.println("Ocupación promedio: 68%");
        System.out.println("Rutas óptimas: 10");
        System.out.println("Rutas que requieren ajustes: 5");
    }
}