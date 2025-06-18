/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportesa.servicios;

import com.mycompany.transportesa.entidades.Chofer;
import com.mycompany.transportesa.excepciones.ChoferYaRegistradoException;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class ChoferService {

    private ArrayList<Chofer> choferList;

    public ChoferService() {
        choferList = new ArrayList<>();
    }

    // registrar chofer
    public void registrarChofer(Chofer chofer) throws ChoferYaRegistradoException {
        for (Chofer c : choferList) {
            if (c.getDni() == chofer.getDni()) {
                System.out.println("este chofer ha sido registrado previamente");
            }
        }
        choferList.add(chofer);
        System.out.println("el chofer se registro con exitoso");
    }

  //Devuelve Lista Choferes.
     public ArrayList<Chofer> listaChoferes() {
         ArrayList<Chofer> lista= new ArrayList<>();
        System.out.println("Lista de choferes:");
        for (Chofer c : choferList) {
            lista.add(c);
        }
        return lista;
    }
     
    //mostrar chofer
    public void mostrarChoferes() {
        System.out.println("Lista de choferes:");
        for (Chofer c : choferList) {
            System.out.println(c);
        }
    }
    
  
}
