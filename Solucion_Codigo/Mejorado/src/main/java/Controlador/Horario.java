package Controlador;

public class Horario {

    private String dia;
    private String horaInicio;
    private String horaFin;
    private Linea linea;
    private Bus bus;
    private Chofer chofer;

    public Horario(String dia, String horaInicio, String horaFin, Linea linea, Bus bus, Chofer chofer) { // Cambiado a
                                                                                                         // Linea
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.linea = linea;
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

    public Linea getLinea() {
        return linea;
    }

    public Bus getBus() {
        return bus;
    }

    public Chofer getChofer() {
        return chofer;
    }
}
