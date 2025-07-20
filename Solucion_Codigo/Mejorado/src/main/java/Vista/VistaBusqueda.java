package Vista;

import Controlador.Buscador;
import java.util.List;
import java.util.Scanner;

public class VistaBusqueda {
    private Scanner scanner;
    private Buscador buscador;

    public VistaBusqueda(Scanner scanner) {
        this.scanner = scanner;
        this.buscador = new Buscador();
    }

    public void mostrarMenuBusqueda() {
        int opcion;
        do {
            System.out.println("\n=== BUSCAR RUTAS ===");
            System.out.println("1. Buscar por parada");
            System.out.println("2. Buscar horarios de linea");
            System.out.println("3. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcion) {
                case 1:
                    buscarPorParada();
                    break;
                case 2:
                    buscarHorariosLinea();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (true);
    }
    
    private void buscarPorParada() {
        System.out.print("\nIngrese nombre de parada: ");
        String parada = scanner.nextLine();
        
        List<String> lineas = buscador.buscarLineasPorParada(parada);
        if (lineas.isEmpty()) {
            System.out.println("\nNo se encontraron lineas para la parada: " + parada);
            System.out.println("Sugerencia: Verifique el nombre de la parada e intente nuevamente");
        } else {
            System.out.println("\nLineas que pasan por '" + parada + "':");
            lineas.forEach(System.out::println);
        }
    }
    
    private void buscarHorariosLinea() {
        System.out.print("\nIngrese ID de linea (ej: Linea 01): ");
        String linea = scanner.nextLine();
        
        List<String> horarios = buscador.buscarHorariosPorLinea(linea);
        if (horarios.isEmpty()) {
            System.out.println("\nNo se encontraron horarios para la linea: " + linea);
            System.out.println("Sugerencia: Verifique el ID de la linea e intente nuevamente");
        } else {
            System.out.println("\nHorarios para linea '" + linea + "':");
            horarios.forEach(System.out::println);
        }
    }
}