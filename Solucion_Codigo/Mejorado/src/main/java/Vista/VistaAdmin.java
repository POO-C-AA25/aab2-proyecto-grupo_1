package Vista;

import java.util.Scanner;
import Controlador.ModificacionRutas;
import Controlador.OptimizacionRutas;
import Controlador.OptimizacionRutas.AnalisisLinea;
import java.sql.Connection;
import java.util.List;

public class VistaAdmin {
    private Scanner scanner;
    private ModificacionRutas modificador;
    private OptimizacionRutas optimizador;

    public VistaAdmin(Scanner scanner, Connection conexion) {
        this.scanner = scanner;
        this.modificador = new ModificacionRutas(conexion);
        this.optimizador = new OptimizacionRutas(conexion);
    }

    public void mostrarMenuAdmin() {
        int opcion;
        do {
            System.out.println("\n=== ADMINISTRACION DEL SISTEMA ===");
            System.out.println("1. Crear nueva linea");
            System.out.println("2. Eliminar línea");
            System.out.println("3. Designar chofer a bus");
            System.out.println("4. Optimización de rutas");
            System.out.println("5. Volver al menú principal");
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
                    mostrarOptimizacionRutas();
                    break;
                case 5:
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

    private void mostrarOptimizacionRutas() {
        System.out.println("\n=== OPTIMIZACIÓN DE RUTAS ===");
        System.out.print("Ingrese el porcentaje mínimo de ocupación (0-100): ");

        try {
            double porcentajeMinimo = scanner.nextDouble();
            scanner.nextLine();

            if (porcentajeMinimo < 0 || porcentajeMinimo > 100) {
                System.out.println("El porcentaje debe estar entre 0 y 100");
                return;
            }

            List<AnalisisLinea> analisisLineas = optimizador.analizarTodasLasLineas();
            boolean hayResultados = false;

            System.out.println("\n=== LÍNEAS QUE SUPERAN EL " + porcentajeMinimo + "% DE OCUPACIÓN ===");

            for (AnalisisLinea analisis : analisisLineas) {
                if (analisis.porcentajeOcupacion >= porcentajeMinimo) {
                    hayResultados = true;
                    System.out.printf("Línea: %s - %s\n",
                            analisis.linea.getIdLinea(),
                            analisis.linea.getNombre());
                    System.out.printf("Porcentaje de ocupación: %.2f%%\n", analisis.porcentajeOcupacion);
                    System.out.printf("Estado: %s\n", analisis.esFavorable ? "FAVORABLE" : "REQUIERE ATENCIÓN");
                    System.out.println("Recomendaciones:");
                    for (String recomendacion : analisis.recomendaciones) {
                        System.out.println("  - " + recomendacion);
                    }
                    System.out.println("----------------------------------------");
                }
            }

            if (!hayResultados) {
                System.out.println("No se encontraron líneas que superen el " + porcentajeMinimo + "% de ocupación.");
            }

        } catch (Exception e) {
            System.out.println("Error: Ingrese un número válido");
            scanner.nextLine();
        }
    }
}