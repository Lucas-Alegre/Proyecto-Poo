/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportesa.entidades;

import java.util.List;

/**
 *
 * @author Lucas
 */
public class Chofer extends Persona {

    private String nroLicencia;
    private List<ChoferCategoria> categorias;

    public Chofer(long dni, String nombre, String apellido, String nroLicencia,
            List<ChoferCategoria> categorias) {
        super(dni, nombre, apellido);
        this.nroLicencia = nroLicencia;
        this.categorias = categorias;
    }

    public String getNroLicencia() {
        return this.nroLicencia;
    }

    public void setNroLicencia(String nuevoNroLicencia) {
        this.nroLicencia = nuevoNroLicencia;
    }

    public List<ChoferCategoria> getCategorias() {
        return this.categorias;
    }

    public void setCategorias(List<ChoferCategoria> categorias) {
        this.categorias = categorias;
    }

    public void agregarCategoria(ChoferCategoria categoria){
        categorias.add(categoria);
    }
 

    @Override
    public String toString() {
        return "Chofer con " + super.toString() + " Numero de Licencia: " + getNroLicencia() + " y Categorias: " + getCategorias();
    }

}
