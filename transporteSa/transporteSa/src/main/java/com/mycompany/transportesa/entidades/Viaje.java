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
    private String horarioSalida;
    private String horarioLlegada;
    private double precioPorPasajero;
    private double distanciaEnKilometro;
    private double costoPorKilometro;
    private EstadoDeViajeEnum estadoDeViaje;
    private Ciudad ciudadOrigen;
    private Ciudad ciudadDestino;
    private Vehiculo vehiculo;
    private Chofer chofer;
    private Reserva reserva;
    private ArrayList<Pasajero> pasajeroLista;

    public Viaje(String fecha, String horarioSalida, String horarioLlegada, double precioPorPasajero, double distanciaEnKilometro, double costoPorKilometro, EstadoDeViajeEnum estadoDeViaje, Ciudad ciudadOrigen, Ciudad ciudadDestino, Vehiculo vehiculo, Chofer chofer, Reserva reserva, ArrayList<Pasajero> pasajeroLista) {
        this.fecha = fecha;
        this.horarioSalida = horarioSalida;
        this.horarioLlegada = horarioLlegada;
        this.precioPorPasajero = precioPorPasajero;
        this.distanciaEnKilometro = distanciaEnKilometro;
        this.costoPorKilometro = costoPorKilometro;
        this.estadoDeViaje = estadoDeViaje;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.vehiculo = vehiculo;
        this.chofer = chofer;
        this.reserva = reserva;
        this.pasajeroLista = pasajeroLista;
    }

    public Viaje(String fecha, String horarioSalida, String horarioLlegada, double precioPorPasajero, double distanciaEnKilometro, double costoPorKilometro, EstadoDeViajeEnum estadoDeViaje, Ciudad ciudadOrigen, Ciudad ciudadDestino){
        this.fecha = fecha;
        this.horarioSalida = horarioSalida;
        this.horarioLlegada = horarioLlegada;
        this.precioPorPasajero = precioPorPasajero;
        this.distanciaEnKilometro = distanciaEnKilometro;
        this.costoPorKilometro = costoPorKilometro;
        this.estadoDeViaje = estadoDeViaje;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
    }
    
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHorarioSalida() {
        return horarioSalida;
    }

    public void setHorarioSalida(String horarioSalida) {
        this.horarioSalida = horarioSalida;
    }

    public String getHorarioLlegada() {
        return horarioLlegada;
    }

    public void setHorarioLlegada(String horarioLlegada) {
        this.horarioLlegada = horarioLlegada;
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

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public ArrayList<Pasajero> getPasajeroLista() {
        return pasajeroLista;
    }

    public void setPasajeroLista(ArrayList<Pasajero> pasajeroLista) {
        this.pasajeroLista = pasajeroLista;
    }

    public void agregarPasajero(Pasajero pasajero) {
        pasajeroLista.add(pasajero);
    }

    @Override
    public String toString() {
        return "Viaje{" + "fecha=" + fecha + ", horarioSalida=" + horarioSalida + ", horarioLlegada=" + horarioLlegada + ", precioPorPasajero=" + precioPorPasajero + ", distanciaEnKilometro=" + distanciaEnKilometro + ", costoPorKilometro=" + costoPorKilometro + ", estadoDeViaje=" + estadoDeViaje + ", ciudadOrigen=" + ciudadOrigen + ", ciudadDestino=" + ciudadDestino + ", vehiculo=" + vehiculo + ", chofer=" + chofer + ", reserva=" + reserva + ", pasajeroLista=" + pasajeroLista + '}';
    }

}
