/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportesa.entidades;

import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class Colectivo extends Vehiculo {

    private boolean pisoDobre;

    public Colectivo(String patente, int capacidad, int anioFabricacion, double kilometraje, ArrayList<Viaje> viajeLista,boolean pisoDoble) {
        super(patente, capacidad, anioFabricacion, kilometraje, viajeLista);
        this.pisoDobre = pisoDoble;
    }

    public boolean getPisoDoble() {
        return this.pisoDobre;
    }

    public void setPisoDoble(boolean nuevoEstadoDePiso) {
        this.pisoDobre = nuevoEstadoDePiso;
    }

    @Override
    public String toString() {
        return "Colectivo{" + super.toString() + "pisoDobre=" + pisoDobre + '}';
    }
    
}
