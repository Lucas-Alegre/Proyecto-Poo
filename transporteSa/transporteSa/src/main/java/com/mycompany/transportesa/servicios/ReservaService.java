/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportesa.servicios;

import com.mycompany.transportesa.entidades.*;
import com.mycompany.transportesa.exceptiones.CapacidadExcedidaException;

/**
 *
 * @author Lucas
 */
public class ReservaService {

    public boolean validarCapacidadDisponible(Viaje viaje) {
        return viaje.getPasajeros().size() < viaje.getVehiculo().getCapacidad();
    }

    public void registrarReserva(Viaje viaje, Pasajero pasajero) throws CapacidadExcedidaException {
        if (validarCapacidadDisponible(viaje)) {
            viaje.agregarPasajeros(pasajero);
        } else {
            throw new CapacidadExcedidaException("No hay capacidad disponible en este viaje");
        }
    }
}
