/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportesa.servicios;

import com.mycompany.transportesa.entidades.Chofer;
import com.mycompany.transportesa.entidades.Ciudad;
import com.mycompany.transportesa.entidades.EstadoDeViajeEnum;
import com.mycompany.transportesa.entidades.Vehiculo;
import com.mycompany.transportesa.entidades.Viaje;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class PlanificadorDeViajes {
//3. Asociar un vehículo y un chofer a cada viaje.

    public Chofer buscarChoferDisponible(ArrayList<Chofer> choferes, String fecha) {
        for (Chofer chofer : choferes) {
            boolean ocupado = false;
            for (Viaje viaje : chofer.getViajeLista()) {
                if (viaje.getFecha().equals(fecha)) {
                    ocupado = true;
                    break;
                }
            }
            if (!ocupado) {
                return chofer;
            }
        }
        return null;
    }

    public Vehiculo buscarVehiculoDisponible(ArrayList<Vehiculo> vehiculos, String fecha, ArrayList<Viaje> viajes) {
        for (Vehiculo vehiculo : vehiculos) {
            boolean ocupado = false;
            for (Viaje viaje : viajes) {
                if (viaje.getFecha().equals(fecha) && viaje.getVehiculo().equals(vehiculo)) {
                    ocupado = true;
                    break;
                }
            }
            if (!ocupado) {
                return vehiculo;
            }
        }
        return null;
    }

    public Viaje crearViaje(String fecha, String horaSalida, String horaLlegada,
            double precioPorPasajero, double distanciaKm, double costoKm,
            Ciudad origen, Ciudad destino,
            ArrayList<Chofer> choferes, ArrayList<Vehiculo> vehiculos, ArrayList<Viaje> viajesExistentes) {

        Chofer choferDisponible = buscarChoferDisponible(choferes, fecha);
        Vehiculo vehiculoDisponible = buscarVehiculoDisponible(vehiculos, fecha, viajesExistentes);

        if (choferDisponible == null) {
            System.out.println("No hay chofer disponible en la fecha " + fecha);
            return null;
        }
        if (vehiculoDisponible == null) {
            System.out.println("No vehículo disponible en la fecha " + fecha);
            return null;
        }

        Viaje nuevoViaje = new Viaje(fecha, horaSalida, horaLlegada, precioPorPasajero, distanciaKm, costoKm,
                EstadoDeViajeEnum.PENDIENTE, origen, destino, vehiculoDisponible, choferDisponible,
                null, new ArrayList<>());

        // Agregamos el viaje al chofer
        choferDisponible.getViajeLista().add(nuevoViaje);

        return nuevoViaje;
    }
}
