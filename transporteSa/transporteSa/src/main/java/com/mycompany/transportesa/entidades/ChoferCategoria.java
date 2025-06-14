/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportesa.entidades;

/**
 *
 * @author Lucas
 */
public class ChoferCategoria {

    private Categoria categoria;
    private String fechaDeVencimiento;

    public ChoferCategoria(Categoria categoria, String fechaDeVencimiento) {
        this.categoria = categoria;
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    public void setFechaDeVencimiento(String fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    @Override
    public String toString() {
        return "ChoferCategoria{" + "categoria=" + categoria + ", fechaDeVencimiento=" + fechaDeVencimiento + '}';
    }
    
}
