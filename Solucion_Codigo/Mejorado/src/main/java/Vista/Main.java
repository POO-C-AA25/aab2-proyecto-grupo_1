package Vista;
import Modelo.Conexion;
import Modelo.DatosRutas;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();

            System.out.println("Iniciando carga de datos.");
            DatosRutas datos = new DatosRutas();
            datos.cargarDatosCompletos(); 

            VistaPrincipal vista = new VistaPrincipal(conexion);
            vista.mostrarMenu();
            
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error en la aplicacn: " + e.getMessage());
            e.printStackTrace();
        } finally {
            Conexion.closeConnection(conexion);
        }
    }
}