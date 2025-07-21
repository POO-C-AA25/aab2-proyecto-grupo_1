package Vista;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class VistaPrincipal {
    private Scanner scanner;
    private VistaBusqueda vistaBusqueda;
    private VistaRutas vistaRutas;
    private VistaAdmin vistaAdmin;
    private Connection conexion;

    public VistaPrincipal(Connection conexion) {
        this.conexion = conexion;
        this.scanner = new Scanner(System.in);
        this.vistaBusqueda= new VistaBusqueda(scanner);
        this.vistaRutas = new VistaRutas(scanner, conexion); 
        this.vistaAdmin = new VistaAdmin(scanner, conexion);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== SISTEMA DE TRANSPORTE ===");
            System.out.println("1. Buscar lineas y horarios"); 
            System.out.println("2. Gestion de lineas"); 
            System.out.println("3. Administracion del sistema");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); 

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
                    cerrarConexion();
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
            }
        } while (true);
    }

    private void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexion: " + e.getMessage());
        }
    }

    public Connection getConexion() {
        return conexion;
    }
}
