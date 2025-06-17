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
public class Minibus extends Vehiculo {

    private boolean tieneBodega;
    private boolean aireAcondicionado;

    public Minibus(String patente, int capacidad, int anioFabricacion, double kilometraje, ArrayList<Viaje> viajeLista, boolean tieneBodega, boolean aireAcondicionado) {
        super(patente, capacidad, anioFabricacion, kilometraje, viajeLista);
        this.tieneBodega = tieneBodega;
        this.aireAcondicionado = aireAcondicionado;
    }

    public boolean getTieneBodega() {
        return this.tieneBodega;
    }

    public void setTieneBodega(boolean nuevoEstadoDeBodega) {
        this.tieneBodega = nuevoEstadoDeBodega;
    }

    public boolean getAireAconcicionado() {
        return this.aireAcondicionado;
    }

    public void setAireAcondicionado(boolean nuevoEstadoAireAcondicionado) {
        this.aireAcondicionado = nuevoEstadoAireAcondicionado;
    }

    @Override
    public String toString() {
        return "Minibus con " + super.toString() + ", Tiene Bodega? = " + getTieneBodega() + ", Tiene aire acondicionado? = " + getAireAconcicionado();
    }
}
