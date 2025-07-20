/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author User
 */
public class Estudiante extends Persona {
    public Estudiante(String nombre, String cedula) {
        super(nombre, cedula);
    }

    @Override
    public void usarBus(Bus bus) {
        System.out.println("Estudiante " + nombre + " usando el bus " + bus.getId());
    }

    public void buscarLinea(Linea linea) {
        System.out.println("Estudiante " + nombre + " buscando ruta " + linea.getIdLinea());
    }

    public void buscarHorario(Horario horario) {
        System.out.println("Estudiante " + nombre + " buscando horario " + horario);
    }
}
