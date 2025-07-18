/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.*;
import java.util.List;

public class ModificacionRutas {
    public void eliminarRuta(Ruta ruta, List<Ruta> sistemaRutas) {
        sistemaRutas.remove(ruta);
        // Desasociar de buses y choferes
        for (Bus bus : ruta.getBuses()) {
            bus.getRutas().remove(ruta);
        }
        for (Chofer chofer : ruta.getChoferes()) {
            chofer.getHorariosDesignados().removeIf(h -> h.getRuta().equals(ruta));
        }
    }

    public void agregarParadas(Ruta ruta, List<Parada> nuevasParadas) {
        ruta.getParadas().addAll(nuevasParadas);
    }

    public void ajustarHorarios(Ruta ruta, Horario nuevoHorario) {
        ruta.getHorarios().add(nuevoHorario);
    }

    public void asignarRutaABus(Ruta ruta, Bus bus, Chofer chofer, Horario horario) {
        bus.getRutas().add(ruta);
        bus.setChofer(chofer);
        chofer.agregarHorarioDesignado(horario);
        ruta.getBuses().add(bus);
        ruta.getChoferes().add(chofer);
        ruta.getHorarios().add(horario);
    }
}