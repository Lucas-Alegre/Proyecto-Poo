/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportesa.entidades;

/**
 *
 * @author Lucas
 */
public abstract class Persona {
    private long dni;
    private String nombre;
    private String apellido;
    
    public Persona(long dni, String nombre, String apellido){
    this.dni = dni;
    this.nombre= nombre;
    this.apellido= apellido;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public String getApellido(){
        return this.apellido;
    }
    public long getDni(){
        return this.dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Persona{" + "dni=" + this.getDni() + ", nombre=" + this.getNombre() + ", apellido=" + this.getApellido() + '}';
    }
}
