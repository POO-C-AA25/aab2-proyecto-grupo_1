/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author User
 */
import java.util.List;

public class Ruta {
    private String id;
    private String origen;
    private String destino;
    private List<Parada> paradas;
    private List<Bus> buses;
    private List<Horario> horarios;
    private List<Chofer> choferes;

    public Ruta(String id, String origen, String destino) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
    }

    public void agregarParada(Parada parada) {
        paradas.add(parada);
    }

    public void agregarBus(Bus bus) {
        buses.add(bus);
    }

    public void agregarHorario(Horario horario) {
        horarios.add(horario);
    }

    public void agregarChofer(Chofer chofer) {
        choferes.add(chofer);
    }

    // Getters y Setters
    public String getId() {
        return id;
    }
    
    public List<Chofer> getChoferes() {
        return choferes;
    }

    public String getOrigen() {
        return origen;
    }
    public List<Horario> getHorarios() {
        return horarios;
    }

    public String getDestino() {
        return destino;
    }
    public List<Bus> getBuses(){
        return buses;
    }
            

    public List<Parada> getParadas() {
        return paradas;
    }
}