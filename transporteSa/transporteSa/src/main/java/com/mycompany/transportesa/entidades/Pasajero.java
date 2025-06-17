/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportesa.entidades;

/**
 *
 * @author Lucas
 */
public class Pasajero extends Persona{
    private String email;
    private String numeroCelular;
    private Reserva reserva;
    
    public Pasajero(long dni, String nombre, String apellido, String email, String numeroCelular, Reserva reserva){
        super(dni, nombre, apellido);
        this.email= email;
        this.numeroCelular = numeroCelular;
        this.reserva=reserva;
    }
    
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String nuevoEmail){
        this.email = nuevoEmail;
    }
    public String getNumeroCelular(){
        return this.numeroCelular;
    }
    public void setNumeroCelular(String nuevoNumeroCelular){
        this.numeroCelular= nuevoNumeroCelular;
    }
    public Reserva getReserva() {
        return reserva;
    }
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public String toString() {
        return "Pasajero{"  + super.toString() + "email=" + email + ", numeroCelular=" + numeroCelular + ", reserva=" + reserva + '}';
    }

}
