/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.List;

/**
 *
 * @author User
 */
public class Chofer extends Persona{
    private String licencia;
    private List<Horario> horariosDesignados;

    public Chofer(String nombre, String cedula, String licencia) {
        super(nombre, cedula);
        this.licencia = licencia;
    }

    @Override
    public void usarBus(Bus bus) {
        System.out.println("Chofer " + nombre + " usando el bus " + bus.getId());
    }

    public void manejarBus(Bus bus) {
        System.out.println("Chofer " + nombre + " manejando el bus " + bus.getId());
    }

    public void agregarHorarioDesignado(Horario horario) {
        horariosDesignados.add(horario);
    }

    public List<Horario> getHorariosDesignados() {
        return horariosDesignados;
    }

    // Getters y Setters adicionales
    public String getLicencia() {
        return licencia;
    }
}
