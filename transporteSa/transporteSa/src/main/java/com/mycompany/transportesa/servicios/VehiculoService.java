/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportesa.servicios;

import com.mycompany.transportesa.entidades.Vehiculo;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public class VehiculoService {
     private ArrayList<Vehiculo> vehiculoList;
    
    public VehiculoService(){
        vehiculoList =   new ArrayList<>();      
    }
   
    // registrar vehiculo
    public boolean registrarVehiculo(Vehiculo vehiculo) {
        for (Vehiculo v : vehiculoList) {
            if (v.getPatente().equals(vehiculo.getPatente())) { //equals ignore case
                System.out.println("Patente de vehiculo existente");
                return false;
            }
        }
        vehiculoList.add(vehiculo);
        System.out.println("el vehiculo: " + vehiculo + " "+ " ha sido registrado con exitoso.");
        return true;
    }

     //mostrar vehiculo
    public void mostrarVehiculos() {
        System.out.println("Lista de vehículos:");
        for (Vehiculo v : vehiculoList) {
            System.out.println(v);
        }
    }
}
