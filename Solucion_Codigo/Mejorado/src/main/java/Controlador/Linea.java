package Controlador;

import java.util.Arrays;

public class Linea {
    private String idLinea; 
    private String nombre;  
    private String[] paradas;
    private String[] horarios;

 
    public Linea(String idLinea, String nombre) {
        this.idLinea = idLinea;
        this.nombre = nombre;
        this.paradas = new String[]{}; 
        this.horarios = new String[]{}; 
    }

    public String getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(String idLinea) {
        this.idLinea = idLinea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String[] getParadas() {
        return paradas;
    }

    public void setParadas(String[] paradas) {
        this.paradas = paradas;
    }

    public void setParadas(String paradasStr) {
        this.paradas = paradasStr.split(";");
    }

    public String[] getHorarios() {
        return horarios;
    }

    public void setHorarios(String[] horarios) {
        this.horarios = horarios;
    }

    public void setHorarios(String horariosStr) {
        this.horarios = horariosStr.split(";");
    }

    @Override
    public String toString() {
        return "Linea " + idLinea + ": " + nombre +
               "\nParadas: " + Arrays.toString(paradas) +
               "\nHorarios: " + Arrays.toString(horarios);
    }
}
