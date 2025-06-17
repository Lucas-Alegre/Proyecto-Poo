/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportesa.entidades;

/**
 *
 * @author 
 */
public class ChoferCategoria {
    
    private String fechaDeVencimiento;
    private Chofer chofer;
    private Categoria categoria;

    public ChoferCategoria(String fechaDeVencimiento, Chofer chofer, Categoria categoria) {
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.chofer = chofer;
        this.categoria = categoria;
    }
    
     public String getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }
    public void setFechaDeVencimiento(String fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }
    public Chofer getChofer() {
        return chofer;
    }
        public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "ChoferCategoria{" + "fechaDeVencimiento=" + fechaDeVencimiento + ", chofer=" + chofer + ", categoria=" + categoria + '}';
    }

}
