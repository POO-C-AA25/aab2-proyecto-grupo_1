/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author User
 */
public class Parada {
    private String id;
    private String nombre;
    private Ruta ruta;

    public Parada(String id, String nombre, Ruta ruta) {
        this.id = id;
        this.nombre = nombre;
        this.ruta = ruta;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Ruta getRuta() {
        return ruta;
    }
}
