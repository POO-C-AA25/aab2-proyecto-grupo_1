package Controlador;

import java.util.ArrayList; // Importar ArrayList
import java.util.List;

public class Chofer extends Persona{
    private String licencia;
    private List<Horario> horariosDesignados;

    public Chofer(String nombre, String cedula, String licencia) {
        super(nombre, cedula);
        this.licencia = licencia;
        this.horariosDesignados = new ArrayList<>(); // Inicializar lista
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

    public String getLicencia() {
        return licencia;
    }
}
