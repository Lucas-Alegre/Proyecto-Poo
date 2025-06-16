/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportesa.entidades;

/**
 *
 * @author Lucas
 */
public abstract class Vehiculo {

    private String patente;
    private int capacidad;
    private int anioFabricacion;
    private double kilometraje;

    public Vehiculo(String patente, int capacidad, int anioFabricacion, double kilometraje) {
        this.patente = patente;
        this.capacidad = capacidad;
        this.anioFabricacion = anioFabricacion;
        this.kilometraje=kilometraje;
    }

    public String getPatente() {
        return this.patente;
    }

    public void setPatente(String nuevaPatente) {
        this.patente = nuevaPatente;
    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public void setCapacidad(int nuevaCapacidad) {
        this.capacidad = nuevaCapacidad;
    }

    public int getAnioFabricacion() {
        return this.anioFabricacion;
    }

    public void setFabricacion(int nuevoAnioFabricacion) {
        this.anioFabricacion = nuevoAnioFabricacion;
    }
    public double getKilometraje(){
        return this.kilometraje;
    }
    public void setKilometraje(double nuevoKilometraje){
        this.kilometraje=nuevoKilometraje;}

    @Override
    public String toString() {
        return "Patente: " + getPatente() + ", Capacidad: " + getCapacidad() + ", Anio de Fabricación: " + getAnioFabricacion()+ ", Kilometraje: "+getKilometraje();
    }
}
