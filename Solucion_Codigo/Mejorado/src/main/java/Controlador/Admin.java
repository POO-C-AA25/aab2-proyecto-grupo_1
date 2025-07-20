package Controlador;

/**
 *
 * @author User
 */
class Admin extends Persona {
    private String area;

    public Admin(String nombre, String cedula, String area) {
        super(nombre, cedula);
        this.area = area;
    }

    @Override
    public void usarBus(Bus bus) {
        System.out.println("Admin " + nombre + " usando el bus " + bus.getId());
    }

    public void accederSistema() {
        System.out.println("Admin " + nombre + " accediendo al sistema");
    }

    public Linea crearLinea(String id, String nombre) { 
        System.out.println("Simulando creación de línea " + id);
        return new Linea(id, nombre); 
    }

    public void eliminarLinea(Linea linea) { 
        System.out.println("Simulando eliminación de línea " + linea.getIdLinea());
    }

    public void designarLineaABus(Linea linea, Bus bus, Chofer chofer) { 
        System.out.println("Simulando designación de línea " + linea.getIdLinea() + " al bus " + bus.getId() + " con chofer " + chofer.getNombre());
        bus.setChofer(chofer);
        bus.agregarLinea(linea); 
    }

    public String getArea() {
        return area;
    }
}
