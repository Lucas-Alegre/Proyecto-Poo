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
public class Viaje {

    private String fecha;
    private String horario;
    private double precioPorPasajero;
    private double distanciaEnKilometro;
    private double costoPorKilometro;
    private EstadoDeViajeEnum estadoDeViaje;
    private Ciudad ciudadOrigen;
    private Ciudad ciudadDestino;
    private Vehiculo vehiculo;
    private Chofer chofer;
    private List<Pasajero> pasajeros;

    public Viaje(String fecha, String horario, double precioPorPasajero, double distanciaEnKilometro,
            double costoPorKilometro, EstadoDeViajeEnum estadoDeViaje, Ciudad ciudadOrigen,
            Ciudad ciudadDestino, Vehiculo vehiculo, Chofer chofer) {
        this.fecha = fecha;
        this.horario = horario;
        this.precioPorPasajero = precioPorPasajero;
        this.distanciaEnKilometro = distanciaEnKilometro;
        this.costoPorKilometro = costoPorKilometro;
        this.estadoDeViaje = estadoDeViaje;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.vehiculo = vehiculo;
        this.chofer = chofer;
        this.pasajeros = new ArrayList<>();
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getPrecioPorPasajero() {
        return precioPorPasajero;
    }

    public void setPrecioPorPasajero(double precioPorPasajero) {
        this.precioPorPasajero = precioPorPasajero;
    }

    public double getDistanciaEnKilometro() {
        return distanciaEnKilometro;
    }

    public void setDistanciaEnKilometro(double distanciaEnKilometro) {
        this.distanciaEnKilometro = distanciaEnKilometro;
    }

    public double getCostoPorKilometro() {
        return costoPorKilometro;
    }

    public void setCostoPorKilometro(double costoPorKilometro) {
        this.costoPorKilometro = costoPorKilometro;
    }

    public EstadoDeViajeEnum getEstadoDeViaje() {
        return estadoDeViaje;
    }

    public void setEstadoDeViaje(EstadoDeViajeEnum estadoDeViaje) {
        this.estadoDeViaje = estadoDeViaje;
    }

    public Ciudad getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(Ciudad ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public Ciudad getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(Ciudad ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Chofer getChofer() {
        return chofer;
    }

    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }

    public List<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(List<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
    }

    public void agregarPasajeros(Pasajero nuevoPasajero) {
        pasajeros.add(nuevoPasajero);
    }
    /** 
     Aqui iria logica de eliminar, ordenar pasajeros etc.
     */

    public double calcularGanancias() {
        return (pasajeros.size() * precioPorPasajero) - (distanciaEnKilometro * costoPorKilometro);
    }
}
