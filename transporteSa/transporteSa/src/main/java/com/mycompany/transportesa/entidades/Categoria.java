/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportesa.entidades;

/**
 *
 * @author Lucas
 */
public class Categoria {
    private CategoriaEnum categoria;
    public Categoria(CategoriaEnum categoria){
        this.categoria=categoria;
    }
    public CategoriaEnum getCategoria(){
        return this.categoria;
    }
    public void setCategoria(CategoriaEnum nuevaCategoria){
        this.categoria = nuevaCategoria;
    }

    @Override
    public String toString() {
        return "Categoria{" + "categoria=" + categoria + '}';
    }
    //pruebo cambio desde netbeans
    //segunda prieba
    
}
