/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportesa.entidades;

/**
 *
 * @author Lucas
 */
public class Reserva {
    private Pasajero pasajero;
    private Viaje viaje;
    private String fechaReserva;
    private EstadoReserva estadoReserva;

    public Reserva(Pasajero pasajero, Viaje viaje, String fechaReserva, EstadoReserva estadoReserva) {
        this.pasajero = pasajero;
        this.viaje = viaje;
        this.fechaReserva = fechaReserva;
        this.estadoReserva = estadoReserva;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(EstadoReserva estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" + "pasajero=" + pasajero + ", viaje=" + viaje + ", fechaReserva=" + fechaReserva + ", estadoReserva=" + estadoReserva + '}';
    }
    
    
    
}
