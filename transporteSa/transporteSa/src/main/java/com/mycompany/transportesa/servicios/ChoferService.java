/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportesa.servicios;

import com.mycompany.transportesa.entidades.Chofer;
import com.mycompany.transportesa.excepciones.ChoferYaRegistradoExcepcion;
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

    //Registrar chofer
    public void registrarChofer(Chofer chofer) throws ChoferYaRegistradoExcepcion {
        for (Chofer c : choferList) {
            if (c.getDni() == chofer.getDni()) {
                throw new ChoferYaRegistradoExcepcion("Este chofer con Dni=" + chofer.getDni() + " ya ha sido registrado previamente");
            }
        }
        choferList.add(chofer);
        System.out.println("El chofer se ha registro con exitoso");
    }

    //Devuelve la Lista de Choferes.
    public ArrayList<Chofer> listaChoferes() {
        return choferList;
    }

    //Impirmir una lista de choferes
    public void mostrarChoferes() {
        System.out.println("Lista de choferes:");
        for (Chofer c : choferList) {
            System.out.println(c);
        }
    }

}
