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
import com.mycompany.transportesa.excepciones.VehiculoNoDisponibleExcepcion;
import com.mycompany.transportesa.excepciones.ChoferNoDispinibleExcepcion;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class AsociacionVehiculoChoferService {
//3. Asociar un vehículo y un chofer a cada viaje.

    //primero tenemos que buscar un chofer disponible, recorremos si uno al menos esta disponible, sino? lanzamos excepcion
    public Chofer buscarChoferDisponible(ArrayList<Chofer> choferes, String fecha) throws ChoferNoDispinibleExcepcion {
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
        throw new ChoferNoDispinibleExcepcion("No hay chofer disponible en la fecha " + fecha);
    }

    public Vehiculo buscarVehiculoDisponible(ArrayList<Vehiculo> vehiculos, String fecha, ArrayList<Viaje> viajes) throws VehiculoNoDisponibleExcepcion {
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
        throw new VehiculoNoDisponibleExcepcion("No hay vehículo disponible en la fecha " + fecha);
    }

    public Viaje crearViaje(String fecha, String horaSalida, String horaLlegada,
            double precioPorPasajero, double distanciaKm, double costoKm,
            Ciudad origen, Ciudad destino,
            ArrayList<Chofer> choferes, ArrayList<Vehiculo> vehiculos, ArrayList<Viaje> viajesExistentes) throws ChoferNoDispinibleExcepcion, VehiculoNoDisponibleExcepcion {
        // vemos si el vehiculo y chofer es null, lanzamos excepciones, los metodos estan arriba para que quede mas limpio
        Chofer choferDisponible = buscarChoferDisponible(choferes, fecha);
        Vehiculo vehiculoDisponible = buscarVehiculoDisponible(vehiculos, fecha, viajesExistentes);

        Viaje nuevoViaje = new Viaje(fecha, horaSalida, horaLlegada, precioPorPasajero, distanciaKm, costoKm,
                EstadoDeViajeEnum.PENDIENTE, origen, destino, vehiculoDisponible, choferDisponible,
                null, new ArrayList<>());

        choferDisponible.getViajeLista().add(nuevoViaje); // Agregamos el viaje al chofer

        return nuevoViaje;
    }
}
