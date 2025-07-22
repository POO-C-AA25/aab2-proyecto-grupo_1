package Controlador;

import java.sql.*;

public class ModificacionRutas {
    private Connection conexion;

    public ModificacionRutas(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean crearLinea(String idLinea, String nombre, String paradas) {
        String sql = "INSERT INTO lineas (id_linea, nombre, paradas) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, idLinea);
            pstmt.setString(2, nombre);
            pstmt.setString(3, paradas);
            int affectedRows = pstmt.executeUpdate();
            conexion.commit();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Error al crear linea: " + e.getMessage());
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                System.err.println("Error al revertir: " + ex.getMessage());
            }
            return false;
        }
    }

    public boolean eliminarLinea(String idLinea) {
        String sql = "DELETE FROM lineas WHERE id_linea = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, idLinea);
            int affectedRows = pstmt.executeUpdate();
            conexion.commit();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar línea: " + e.getMessage());
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                System.err.println("Error al revertir: " + ex.getMessage());
            }
            return false;
        }
    }

    public boolean agregarParadas(String idLinea, String nuevasParadas) {
        String sql = "UPDATE lineas SET paradas = CONCAT(paradas, ';', ?) WHERE id_linea = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, nuevasParadas);
            pstmt.setString(2, idLinea);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Error al agregar paradas: " + e.getMessage());
            return false;
        }
    }

    public boolean ajustarHorarios(String idLinea, String nuevosHorarios) {
        String sql = "UPDATE lineas SET horarios = CONCAT(COALESCE(horarios, ''), ';', ?) WHERE id_linea = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, nuevosHorarios);
            pstmt.setString(2, idLinea);
            int affectedRows = pstmt.executeUpdate();
            conexion.commit();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Error al ajustar horarios: " + e.getMessage());
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                System.err.println("Error al revertir: " + ex.getMessage());
            }
            return false;
        }
    }

    public boolean asignarChoferABus(String idBus, String idChofer) {
        String sql = "UPDATE buses SET id_chofer = ? WHERE id_bus = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, idChofer);
            pstmt.setString(2, idBus);
            int affectedRows = pstmt.executeUpdate();
            conexion.commit();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Error al asignar chofer al bus: " + e.getMessage());
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                System.err.println("Error al revertir: " + ex.getMessage());
            }
            return false;
        }
    }

}