package Vista;

import java.util.Scanner;

public class VistaPrincipal {
    private Scanner scanner;
    private VistaBusqueda vistaBusqueda;
    private VistaRutas vistaRutas;
    private VistaAdmin vistaAdmin;
    private VistaInformes vistaInformes;

    public VistaPrincipal() {
        this.scanner = new Scanner(System.in);
        this.vistaBusqueda = new VistaBusqueda(scanner);
        this.vistaRutas = new VistaRutas(scanner);
        this.vistaAdmin = new VistaAdmin(scanner);
        this.vistaInformes = new VistaInformes(scanner);
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("\n=== SISTEMA DE TRANSPORTE ===");
            System.out.println("1. Buscar rutas y horarios");
            System.out.println("2. Gestión de rutas");
            System.out.println("3. Administración del sistema");
            System.out.println("4. Reportes e informes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    vistaBusqueda.mostrarMenuBusqueda();
                    break;
                case 2:
                    vistaRutas.mostrarMenuRutas();
                    break;
                case 3:
                    vistaAdmin.mostrarMenuAdmin();
                    break;
                case 4:
                    vistaInformes.mostrarMenuInformes();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}
