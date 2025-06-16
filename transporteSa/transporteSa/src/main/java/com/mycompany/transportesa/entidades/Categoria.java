/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportesa.entidades;

import java.util.ArrayList;

/**
 *
 * @author Lucas
 */


public class Categoria {
    private CategoriaEnum categoria;
    ArrayList<ChoferCategoria> choferCategoriaList;
    public Categoria(CategoriaEnum categoria,  ArrayList<ChoferCategoria> choferCategoriaList){
        this.choferCategoriaList= choferCategoriaList;
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
        return "Categoria{" + "categoria=" + categoria + ", choferCategoriaList=" + choferCategoriaList + '}';
    }
    //pruebo cambio desde netbeans
    //segunda prieba
}
