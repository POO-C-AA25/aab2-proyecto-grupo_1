/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Modelo.*;
import java.util.List;

public class Buscador {
    private List<Ruta> rutasDisponibles;
    private List<Horario> horariosDisponibles;

    public Buscador(List<Ruta> rutas, List<Horario> horarios) {
        this.rutasDisponibles = rutas;
        this.horariosDisponibles = horarios;
    }

    public Ruta buscarRutaPorParada(String nombreParada) {
        for (Ruta ruta : rutasDisponibles) {
            for (Parada parada : ruta.getParadas()) {
                if (parada.getNombre().equalsIgnoreCase(nombreParada)) {
                    return ruta;
                }
            }
        }
        return null;
    }

    public Horario buscarHorario(String horaInicio, Ruta ruta) {
        for (Horario horario : horariosDisponibles) {
            if (horario.getHoraInicio().equals(horaInicio) && 
                horario.getRuta().equals(ruta)) {
                return horario;
            }
        }
        return null;
    }

    public List<Bus> obtenerBusesDisponibles(Horario horario) {
        // Lógica para filtrar buses disponibles según horario
        return horario.getRuta().getBuses().stream()
            .filter(bus -> bus.getHorarios().contains(horario))
            .toList();
    }
}
