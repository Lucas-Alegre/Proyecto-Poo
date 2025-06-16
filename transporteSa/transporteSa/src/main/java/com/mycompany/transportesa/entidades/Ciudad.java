/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportesa.entidades;

/**
 *
 * @author Lucas
 */
public class Ciudad {

    private String nombre;
    private ProvinciaEnum provincia;

    public Ciudad(String nombre, ProvinciaEnum provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }

    public String getNombre() {
        return this.nombre;
    }

    public ProvinciaEnum getProvincia() {
        return this.provincia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProvincia(ProvinciaEnum provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Ciudad: " + getNombre() + ", en provincia de : " + getProvincia();
    }
}
