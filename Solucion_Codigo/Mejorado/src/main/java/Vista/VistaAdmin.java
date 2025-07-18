package Vista;

import java.util.Scanner;

public class VistaAdmin {
    private Scanner scanner;

    public VistaAdmin(Scanner scanner) {
        this.scanner = scanner;
    }

    public void mostrarMenuAdmin() {
        System.out.println("\n=== ADMINISTRACIÓN DEL SISTEMA ===");
        System.out.println("1. Crear nueva ruta");
        System.out.println("2. Eliminar ruta");
        System.out.println("3. Designar choferes");
        System.out.print("Seleccione una opción: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcion) {
            case 1:
                crearRuta();
                break;
            case 2:
                eliminarRuta();
                break;
            case 3:
                designarChofer();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    private void crearRuta() {
        System.out.println("\n=== CREAR NUEVA RUTA ===");
        System.out.print("ID de la ruta: ");
        String id = scanner.nextLine();
        
        System.out.print("Origen: ");
        String origen = scanner.nextLine();
        
        System.out.print("Destino: ");
        String destino = scanner.nextLine();
        
        System.out.println("Ruta " + id + " creada exitosamente!");
    }

    private void eliminarRuta() {
        System.out.println("\n=== ELIMINAR RUTA ===");
        System.out.print("ID de la ruta a eliminar: ");
        String id = scanner.nextLine();
        
        System.out.println("Ruta " + id + " eliminada exitosamente!");
    }

    private void designarChofer() {
        System.out.println("\n=== DESIGNAR CHOFER ===");
        System.out.print("Nombre del chofer: ");
        String chofer = scanner.nextLine();
        
        System.out.print("ID de la ruta: ");
        String ruta = scanner.nextLine();
        
        System.out.println("Chofer " + chofer + " asignado a la ruta " + ruta);
    }
}