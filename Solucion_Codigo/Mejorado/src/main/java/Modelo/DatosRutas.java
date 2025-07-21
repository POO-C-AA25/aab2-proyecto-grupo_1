package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class DatosRutas {
    public void cargarDatosCompletos() {
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            conn.setAutoCommit(false);

            limpiarTablas(conn);

            cargarLineas(conn);
            cargarHorarios(conn);
            cargarChoferes(conn);
            cargarBuses(conn);

            conn.commit();
            System.out.println("Carga de datos completada exitosamente!");
        } catch (SQLException | IOException e) {
            System.err.println("Error al cargar datos: " + e.getMessage());
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                    System.err.println("Transacción revertida.");
                } catch (SQLException ex) {
                    System.err.println("Error al revertir transacción: " + ex.getMessage());
                }
            }
        } finally {
            Conexion.closeConnection(conn);
        }
    }

    private void limpiarTablas(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {

            stmt.execute("SET FOREIGN_KEY_CHECKS = 0");

            stmt.execute("TRUNCATE TABLE buses");
            stmt.execute("TRUNCATE TABLE choferes");
            stmt.execute("TRUNCATE TABLE horarios");
            stmt.execute("TRUNCATE TABLE lineas");

            stmt.execute("SET FOREIGN_KEY_CHECKS = 1");
        }
    }

    private void cargarLineas(Connection conn) throws SQLException, IOException {

        String filePath = "C:\\Users\\User\\Desktop\\Estructuras de datos\\Mejorado\\src\\main\\java\\Recursos\\Lineasbu.csv";

        String sql = "INSERT IGNORE INTO lineas (id_linea, nombre, paradas) VALUES (?, ?, ?)";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                if (datos.length >= 3) {
                    pstmt.setString(1, datos[0].trim());
                    pstmt.setString(2, datos[1].trim());

                    StringBuilder paradas = new StringBuilder();
                    for (int i = 2; i < datos.length; i++) {
                        if (i > 2)
                            paradas.append(";");
                        paradas.append(datos[i].trim());
                    }

                    pstmt.setString(3, paradas.toString());
                    pstmt.executeUpdate();
                }
            }
        }
    }

    private void cargarHorarios(Connection conn) throws SQLException, IOException {
        String filePath = "C:\\Users\\User\\Desktop\\Estructuras de datos\\Mejorado\\src\\main\\java\\Recursos\\Horarios.csv";
        String sql = "INSERT IGNORE INTO horarios (hora, lineas) VALUES (?, ?)";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                if (datos.length >= 2) {
                    pstmt.setString(1, datos[0].trim());

                    StringBuilder lineas = new StringBuilder();
                    for (int i = 1; i < datos.length; i++) {
                        if (i > 1)
                            lineas.append(";");
                        lineas.append(datos[i].trim());
                    }

                    pstmt.setString(2, lineas.toString());
                    pstmt.executeUpdate();
                }
            }
        }
    }

    private void cargarChoferes(Connection conn) throws SQLException, IOException {
        String filePath = "C:\\Users\\User\\Desktop\\Estructuras de datos\\Mejorado\\src\\main\\java\\Recursos\\Choferes.csv";

        String sql = "INSERT IGNORE INTO choferes (id_chofer, nombre, licencia) VALUES (?, ?, ?)";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();

            String line;
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                while ((line = br.readLine()) != null) {
                    String[] datos = line.split(";");
                    if (datos.length >= 3) {
                        pstmt.setString(1, datos[0].trim());
                        pstmt.setString(2, datos[1].trim());
                        pstmt.setString(3, datos[2].trim());
                        pstmt.executeUpdate();
                    }
                }
            }
        }
    }

    private void cargarBuses(Connection conn) throws SQLException, IOException {
        String filePath = "C:\\Users\\User\\Desktop\\Estructuras de datos\\Mejorado\\src\\main\\java\\Recursos\\Bus.csv";

        String sql = "INSERT IGNORE INTO buses (id_bus, placa, capacidad, estado, id_chofer) VALUES (?, ?, ?, ?, ?)";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();

            String line;
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                while ((line = br.readLine()) != null) {
                    String[] datos = line.split(";");
                    if (datos.length >= 5) {
                        pstmt.setString(1, datos[0].trim());
                        pstmt.setString(2, datos[1].trim());
                        pstmt.setInt(3, Integer.parseInt(datos[2].trim()));
                        pstmt.setString(4, datos[3].trim());
                        pstmt.setString(5, datos[4].trim().isEmpty() ? null : datos[4].trim());
                        pstmt.executeUpdate();
                    }
                }
            }
        }
    }
}
