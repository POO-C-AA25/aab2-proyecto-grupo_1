package Vista;

import Controlador.Buscador;
import Controlador.ModificacionRutas;
import Controlador.OptimizacionRutas;
import Controlador.OptimizacionRutas.AnalisisLinea;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class VistaRutas {
    private Scanner scanner;
    private ModificacionRutas modificador;
    private Buscador buscador;
    private OptimizacionRutas optimizador;

    public VistaRutas(Scanner scanner, Connection conexion) {
        this.scanner = scanner;
        this.modificador = new ModificacionRutas(conexion);
        this.buscador = new Buscador();
        this.optimizador = new OptimizacionRutas(conexion);
    }

    public void mostrarMenuRutas() {
        System.out.println("\n=== GESTION DE LÍNEAS ===");
        System.out.println("1. Ver todas las líneas");
        System.out.println("2. Optimizar líneas");
        System.out.println("3. Modificar línea");
        System.out.println("4. Volver al menu principal");
        System.out.print("Seleccione una opcion: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion) {
            case 1:
                mostrarTodasLasLineas();
                break;
            case 2:
                optimizarLineas();
                break;
            case 3:
                modificarLinea();
                break;
            case 4:
                return;
            default:
                System.out.println("Opcion no valida");
        }
    }

    private void mostrarTodasLasLineas() {
        System.out.println("\n=== LISTADO DE LÍNEAS ===");
        List<String> lineas = buscador.buscarTodasLasLineas();
        if (lineas.isEmpty()) {
            System.out.println("No se encontraron líneas.");
        } else {
            lineas.forEach(System.out::println);
        }
    }

    private void optimizarLineas() {
        System.out.println("\n=== OPTIMIZACIÓN DE LÍNEAS ===");
        System.out.println("Analizando rendimiento de todas las líneas...\n");
        List<AnalisisLinea> analisisLineas = optimizador.analizarTodasLasLineas();
        if (analisisLineas.isEmpty()) {
            System.out.println("No se encontraron líneas para analizar.");
            return;
        }
        System.out.println("=== RESULTADOS DEL ANÁLISIS ===");
        int lineasFavorables = 0;
        int lineasProblematicas = 0;
        for (AnalisisLinea analisis : analisisLineas) {
            System.out.printf("Línea: %s - %s\n",
                    analisis.linea.getIdLinea(),
                    analisis.linea.getNombre());
            System.out.printf("Ocupación: %.1f%% ", analisis.porcentajeOcupacion);
            if (analisis.esFavorable) {
                System.out.println("(✓ Óptima)");
                lineasFavorables++;
            } else {
                System.out.println("(⚠ Requiere ajustes)");
                lineasProblematicas++;
            }
            System.out.println("Recomendaciones:");
            for (String recomendacion : analisis.recomendaciones) {
                System.out.println("  • " + recomendacion);
            }
            System.out.println("----------------------------------------");
        }
        System.out.println("\n=== RESUMEN DEL ANÁLISIS ===");
        System.out.printf("Total de líneas analizadas: %d\n", analisisLineas.size());
        System.out.printf("Líneas con rendimiento óptimo: %d\n", lineasFavorables);
        System.out.printf("Líneas que requieren ajustes: %d\n", lineasProblematicas);
        System.out.printf("Porcentaje de eficiencia global: %.1f%%\n",
                (lineasFavorables * 100.0) / analisisLineas.size());
    }

    private void modificarLinea() {
        System.out.println("\n=== MODIFICAR LINEA ===");
        System.out.print("Ingrese ID de linea a modificar: ");
        String idLinea = scanner.nextLine();
        System.out.println("Opciones para la linea " + idLinea + ":");
        System.out.println("1. Agregar paradas");
        System.out.println("2. Ajustar horarios");
        System.out.print("Seleccione una opcion: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        boolean exito = false;
        switch (opcion) {
            case 1:
                System.out.print("Ingrese nuevas paradas (separadas por punto y coma): ");
                String nuevasParadas = scanner.nextLine();
                exito = modificador.agregarParadas(idLinea, nuevasParadas);
                break;
            case 2:
                System.out.print("Ingrese nuevos horarios (separados por coma): ");
                String nuevosHorarios = scanner.nextLine();
                exito = modificador.ajustarHorarios(idLinea, nuevosHorarios);
                break;
            default:
                System.out.println("Opcion no valida.");
                return;
        }
        if (exito) {
            System.out.println("Modificacion realizada con exito para la linea " + idLinea);
        } else {
            System.out.println("Error al realizar la modificacion para la linea " + idLinea + ". Verifique el ID.");
        }
    }
}