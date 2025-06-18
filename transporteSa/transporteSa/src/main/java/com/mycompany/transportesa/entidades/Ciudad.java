/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportesa.entidades;

import java.util.ArrayList;

/**
 *
 * @author
 */
public class Ciudad {

    private String nombre;
    private ProvinciaEnum provincia;
    private ArrayList<Viaje> OrigenLista; //Hace falta, creo que no tendria sentido?
    private ArrayList<Viaje> DestinoLista;//?? - Para que lo necesitariamos?

    public Ciudad(String nombre, ProvinciaEnum provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.OrigenLista = new ArrayList<>();
        this.DestinoLista = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ProvinciaEnum getProvincia() {
        return provincia;
    }

    public void setProvincia(ProvinciaEnum provincia) {
        this.provincia = provincia;
    }

    public ArrayList<Viaje> getOrigenLista() {
        return OrigenLista;
    }

    public void setOrigenLista(ArrayList<Viaje> OrigenLista) {
        this.OrigenLista = OrigenLista;
    }

    public ArrayList<Viaje> getDestinoLista() {
        return DestinoLista;
    }

    public void setDestinoLista(ArrayList<Viaje> DestinoLista) {
        this.DestinoLista = DestinoLista;
    }

    @Override
    public String toString() {
        return "Ciudad{" + "nombre=" + nombre + ", provincia=" + provincia + '}'; //+ ", OrigenLista=" + OrigenLista + ", DestinoLista=" + DestinoLista + '}';
    }
}
