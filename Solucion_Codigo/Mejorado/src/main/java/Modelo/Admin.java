/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

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

    public Ruta crearRuta(String id, String origen, String destino) {
        System.out.println("Creando nueva ruta " + id);
        return new Ruta(id, origen, destino);
    }

    public void eliminarRuta(Ruta ruta) {
        System.out.println("Eliminando ruta " + ruta.getId());
    }

    public void designarRutaABus(Ruta ruta, Bus bus, Chofer chofer) {
        System.out.println("Designando ruta " + ruta.getId() + " al bus " + bus.getId() + " con chofer " + chofer.getNombre());
        bus.setChofer(chofer);
        bus.agregarRuta(ruta);
    }

    // Getters y Setters adicionales
    public String getArea() {
        return area;
    }
}
