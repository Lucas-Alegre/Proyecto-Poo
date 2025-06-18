/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportesa.servicios;

import com.mycompany.transportesa.entidades.Vehiculo;
import com.mycompany.transportesa.excepciones.VehiculoYaRegistradoExcepcion;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class VehiculoService {

    private ArrayList<Vehiculo> vehiculoList;

    public VehiculoService() {
        vehiculoList = new ArrayList<>();
    }

    // registrar vehiculo
    public void registrarVehiculo(Vehiculo vehiculo) throws VehiculoYaRegistradoExcepcion {
        for (Vehiculo v : vehiculoList) {
            if (v.getPatente().equals(vehiculo.getPatente())) { //equals ignore case
                throw new VehiculoYaRegistradoExcepcion("Ya existe un vehículo con la patente: " + vehiculo.getPatente());
            }
        }
        vehiculoList.add(vehiculo);
        System.out.println("el vehiculo se registro con exitoso");
    }

    //mostrar vehiculo
    public void mostrarVehiculos() {
        System.out.println("Lista de vehículos:");
        for (Vehiculo v : vehiculoList) {
            System.out.println(v);
        }
    }
}
