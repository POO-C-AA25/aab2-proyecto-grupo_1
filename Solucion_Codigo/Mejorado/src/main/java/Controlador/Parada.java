package Controlador;

/**
 *
 * @author User
 */
public class Parada {
    private String id;
    private String nombre;
    private Linea linea; 

    public Parada(String id, String nombre, Linea linea) { 
        this.id = id;
        this.nombre = nombre;
        this.linea = linea;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Linea getLinea() {
        return linea;
    }
}
