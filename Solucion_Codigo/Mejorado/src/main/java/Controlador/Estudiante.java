package Controlador;

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
