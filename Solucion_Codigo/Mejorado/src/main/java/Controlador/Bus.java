package Controlador;
import java.util.ArrayList;
import java.util.List;

public class Bus {
    private String id;
    private String placa;
    private int capacidad; 
    private Chofer chofer;
    private List<Horario> horarios;
    private List<Linea> lineas; 

    public Bus(String id, String placa, int capacidad) { 
        this.id = id;
        this.placa = placa;
        this.capacidad = capacidad;
        this.horarios = new ArrayList<>(); 
        this.lineas = new ArrayList<>(); 
    }

    public void asignarChofer(Chofer chofer) {
        this.chofer = chofer;
    }

    public void designarLinea(Linea linea, Horario horario) {
        this.lineas.add(linea);
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

    public int getCapacidad() { 
        return capacidad;
    }

    public void setCapacidad(int capacidad) { 
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

    public List<Linea> getLineas() { 
        return lineas;
    }

    public void setLineas(List<Linea> lineas) {
        this.lineas = lineas;
    }

    public void agregarHorario(Horario horario) {
        this.horarios.add(horario);
    }

    public void eliminarHorario(Horario horario) {
        this.horarios.remove(horario);
    }

    public void agregarLinea(Linea linea) { 
        this.lineas.add(linea);
    }

    public void eliminarLinea(Linea linea) { 
        this.lineas.remove(linea);
    }

    public boolean tieneLinea(Linea linea) { 
        return this.lineas.contains(linea);
    }

    public boolean tieneHorario(Horario horario) {
        return this.horarios.contains(horario);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id='" + id + '\'' +
                ", placa='" + placa + '\'' +
                ", capacidad=" + capacidad + 
                ", chofer=" + (chofer != null ? chofer.getNombre() : "N/A") + 
                '}';
    }
}
