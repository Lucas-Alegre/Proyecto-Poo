/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportesa.servicios;
import com.mycompany.transportesa.entidades.*;

/**
 *
 * @author Lucas
 */
public class ViajeService {
    
    public boolean validarChoferDisponible(Viaje viaje, Chofer chofer){
    //Hacer logica
    return true;
    }
    
    public boolean validarVehiculosDisponible(Viaje viaje, Vehiculo vehiculo){
    //Hacer logica
    return true;
    }
    
    public void finalizarViaje(Empresa empresa, Viaje viaje){
        double ganancia= viaje.calcularGanancias();
        viaje.setEstadoDeViaje(EstadoDeViaje.FINALIZADO);
        empresa.sumarGanancias(ganancia);
    }
    
}
