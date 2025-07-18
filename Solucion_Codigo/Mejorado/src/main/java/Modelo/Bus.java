package Modelo;
import java.util.List;

public class Bus {
    private String id;
    private String placa;
    private String capacidad;
    private Chofer chofer;
    private List<Horario> horarios;
    private List<Ruta> rutas;

    public Bus(String id, String placa, String capacidad) {
        this.id = id;
        this.placa = placa;
        this.capacidad = capacidad;
    }

    // Métodos existentes más...
    public void asignarChofer(Chofer chofer) {
        this.chofer = chofer;
    }

    public void designarRuta(Ruta ruta, Horario horario) {
        this.rutas.add(ruta);
        this.horarios.add(horario);
        if (chofer != null) {
            chofer.agregarHorarioDesignado(horario);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public Chofer getChofer() {
        return chofer;
    }

    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public List<Ruta> getRutas() {
        return rutas;
    }

    public void setRutas(List<Ruta> rutas) {
        this.rutas = rutas;
    }

    public void agregarHorario(Horario horario) {
        this.horarios.add(horario);
    }

    public void eliminarHorario(Horario horario) {
        this.horarios.remove(horario);
    }

    public void agregarRuta(Ruta ruta) {
        this.rutas.add(ruta);
    }

    public void eliminarRuta(Ruta ruta) {
        this.rutas.remove(ruta);
    }

    public boolean tieneRuta(Ruta ruta) {
        return this.rutas.contains(ruta);
    }

    public boolean tieneHorario(Horario horario) {
        return this.horarios.contains(horario);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id='" + id + '\'' +
                ", placa='" + placa + '\'' +
                ", capacidad='" + capacidad + '\'' +
                ", chofer=" + chofer +
                '}';
    }
}
