/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportesa.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class Empresa {

    private String nombre;
    private double ganancias;
    private List<Chofer> choferes;
    private List<Viaje> viajes;
    private List<Vehiculo> vehiculos;
    private List<Reserva> reservas;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.ganancias = 0.0;
        this.choferes = new ArrayList<>();
        this.viajes = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getGanancias() {
        return ganancias;
    }

    public void setGanancias(double ganancias) {
        this.ganancias = ganancias;
    }

    public List<Chofer> getChoferes() {
        return choferes;
    }

    public void setChoferes(List<Chofer> choferes) {
        this.choferes = choferes;
    }

    public List<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(List<Viaje> viajes) {
        this.viajes = viajes;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    
    
    public void agregarChofer(Chofer chofer) {
        choferes.add(chofer);
    }
    public void agregarViaje(Viaje viaje){
        viajes.add(viaje);
    }
    public void agregarVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }
    public void agregarReserva(Reserva reserva){
        reservas.add(reserva);
    }
    public void sumarGanancias(double monto){
        this.ganancias +=monto;
    }

    @Override
    public String toString() {
        return "Empresa{" + "nombre=" + nombre + ", ganancias=" + ganancias + ", choferes=" + choferes + ", viajes=" + viajes + ", vehiculos=" + vehiculos + ", reservas=" + reservas + '}';
    }
    
    
    
}
