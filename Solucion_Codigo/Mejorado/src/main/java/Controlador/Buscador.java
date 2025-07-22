package Controlador;

import Modelo.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Buscador {

    public List<String> buscarLineasPorParada(String nombreParada) {
        List<String> lineas = new ArrayList<>();

        String sql = "SELECT id_linea, nombre FROM lineas WHERE LOWER(REPLACE(REPLACE(REPLACE(REPLACE(paradas, 'á', 'a'), 'é', 'e'), 'í', 'i'), 'ó', 'o')) "
                +
                "LIKE LOWER(CONCAT('%', REPLACE(REPLACE(REPLACE(REPLACE(?, 'á', 'a'), 'é', 'e'), 'í', 'i'), 'ó', 'o'), '%'))";

        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombreParada);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                lineas.add(String.format("%s - %s",
                        rs.getString("id_linea"),
                        rs.getString("nombre")));
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar lineas por parada: " + e.getMessage());
        }
        return lineas;
    }

    public List<String> buscarHorariosPorLinea(String idLinea) {
        List<String> horarios = new ArrayList<>();
        String sql = "SELECT hora FROM horarios WHERE lineas LIKE ? ORDER BY hora";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + idLinea + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                horarios.add(rs.getString("hora"));
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar horarios por linea: " + e.getMessage());
        }
        return horarios;
    }

    public List<String> buscarTodasLasLineas() {
        List<String> lineas = new ArrayList<>();
        String sql = "SELECT id_linea, nombre, paradas FROM lineas ORDER BY id_linea";

        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lineas.add(String.format("ID: %s, Nombre: %s, Paradas: %s",
                        rs.getString("id_linea"),
                        rs.getString("nombre"),
                        rs.getString("paradas")));
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar todas las lineas: " + e.getMessage());
        }
        return lineas;
    }
    
    public List<Linea> obtenerTodasLasLineasComoObjetos() {
        List<Linea> lineas = new ArrayList<>();
        String sql = "SELECT id_linea, nombre, paradas FROM lineas ORDER BY id_linea";

        try (Connection conn = Conexion.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Linea linea = new Linea(rs.getString("id_linea"), rs.getString("nombre"));
                linea.setParadas(rs.getString("paradas"));
                lineas.add(linea);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener líneas como objetos: " + e.getMessage());
        }
        return lineas;
    }
}