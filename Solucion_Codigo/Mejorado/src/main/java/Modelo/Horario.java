/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author User
 */
public class Horario {
    private String dia;
    private String horaInicio;
    private String horaFin;
    private Ruta ruta;
    private Bus bus;
    private Chofer chofer;

    public Horario(String dia, String horaInicio, String horaFin, Ruta ruta, Bus bus, Chofer chofer) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.ruta = ruta;
        this.bus = bus;
        this.chofer = chofer;
    }

    // Getters y Setters
    public String getDia() {
        return dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public Bus getBus() {
        return bus;
    }

    public Chofer getChofer() {
        return chofer;
    }
}
