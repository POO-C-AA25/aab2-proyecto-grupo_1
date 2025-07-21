package Vista;

import java.util.Scanner;
import Controlador.ModificacionRutas;
import java.sql.Connection;

public class VistaAdmin {
    private Scanner scanner;
    private ModificacionRutas modificador;

    public VistaAdmin(Scanner scanner, Connection conexion) {
        this.scanner = scanner;
        this.modificador = new ModificacionRutas(conexion);
    }

    public void mostrarMenuAdmin() {
        int opcion;
        do {
            System.out.println("\n=== ADMINISTRACION DEL SISTEMA ===");
            System.out.println("1. Crear nueva linea");
            System.out.println("2. Eliminar línea");
            System.out.println("3. Designar chofer a bus");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearLinea();
                    break;
                case 2:
                    eliminarLinea();
                    break;
                case 3:
                    designarChoferABus();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (true);
    }

    private void crearLinea() {
        System.out.println("\n=== CREAR NUEVA LINEA ===");
        System.out.print("ID de la linea (ej: Linea 01): ");
        String id = scanner.nextLine();

        System.out.print("Nombre de la linea (ej: Terminal): ");
        String nombre = scanner.nextLine();

        System.out.print("Paradas (separadas por punto y coma, ej: ParadaA;ParadaB): ");
        String paradas = scanner.nextLine();

        if (modificador.crearLinea(id, nombre, paradas)) {
            System.out.println("Linea " + id + " creada exitosamente!");
        } else {
            System.out.println("Error al crear la linea " + id);
        }
    }

    private void eliminarLinea() {
        System.out.println("\n=== ELIMINAR LNEA ===");
        System.out.print("ID de la linea a eliminar: ");
        String id = scanner.nextLine();

        if (modificador.eliminarLinea(id)) {
            System.out.println("Línea " + id + " eliminada exitosamente!");
        } else {
            System.out.println("Error al eliminar la lnea " + id + ". Asegurese de que exista ");
        }
    }

    private void designarChoferABus() {
        System.out.println("\n=== DESIGNAR CHOFER A BUS ===");
        System.out.print("ID del chofer: ");
        String idChofer = scanner.nextLine();

        System.out.print("ID del bus: ");
        String idBus = scanner.nextLine();

        if (modificador.asignarChoferABus(idBus, idChofer)) {
            System.out.println("Chofer " + idChofer + " asignado al bus " + idBus + " exitosamente!");
        } else {
            System.out.println("Error al asignar chofer al bus.");
        }
    }
}
