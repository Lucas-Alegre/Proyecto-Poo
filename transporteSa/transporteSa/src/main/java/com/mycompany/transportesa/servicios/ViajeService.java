/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportesa.servicios;
import com.mycompany.transportesa.entidades.*;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class ViajeService {
    
    ArrayList<Viaje> listaViajes;

    //Crear validaciones, "No se debe poder agregar mas personas al viaje si el cupo de personas por vehiculo esta lleno"
    public ViajeService() {
        listaViajes = new ArrayList<>();
    }

    public void agregarViaje(Viaje viaje) {
        listaViajes.add(viaje);
    }

    public void eliminarViaje(Viaje viaje) {
        listaViajes.remove(viaje);
    }

    public void mostrarViaje(Viaje viaje) {
        System.out.println(viaje);
    }

    public void mostrarViajesDetallados() {
        for (Viaje viaje : listaViajes) {
            System.out.println(viaje);
        }
    }

    public void viajesPorVehiculo(Vehiculo vehiculo) {
        ArrayList<Viaje> lista = new ArrayList<>();
        for (int i = 0; i < listaViajes.size(); i++) {
            if (listaViajes.get(i).getVehiculo() instanceof Colectivo) {
                Colectivo colectivo = (Colectivo) listaViajes.get(i).getVehiculo();
                if (colectivo.equals(vehiculo)) {
                    lista.add(listaViajes.get(i));
                }
            }
        }
        for (Viaje viaje : lista) {
            System.out.println(viaje);
            System.out.println("\n");
        }
    }

    public void cantidadViajesChofer() {
    }

    public boolean validarChoferDisponible(Viaje viaje, Chofer chofer) {
        //Hacer logica
        return true;
    }

    public boolean validarVehiculosDisponible(Viaje viaje, Vehiculo vehiculo) {
        //Hacer logica
        return true;
    }

    public void finalizarViaje(Empresa empresa, Viaje viaje) {
        double ganancia = viaje.calcularGanancias();
        viaje.setEstadoDeViaje(EstadoDeViajeEnum.FINALIZADO);
        empresa.sumarGanancias(ganancia);
    }
    
}
