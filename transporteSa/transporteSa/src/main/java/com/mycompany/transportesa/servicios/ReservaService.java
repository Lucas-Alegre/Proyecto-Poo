/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportesa.servicios;

import com.mycompany.transportesa.entidades.EstadoReserva;
import com.mycompany.transportesa.entidades.Pasajero;
import com.mycompany.transportesa.entidades.Reserva;
import com.mycompany.transportesa.entidades.Viaje;
import com.mycompany.transportesa.excepciones.ExcesoDePasajerosException;
import java.time.LocalDate;

/**
 *
 * @author Lucas
 */
public class ReservaService {
    private ViajeService viajeService;

    public ReservaService(ViajeService viajeService) {
        this.viajeService = viajeService;
    }

    public void realizarReserva(Pasajero pasajero, Viaje viaje) {
        try {
            // Paso 1: Validar y agregar al viaje
            viajeService.validarYAgregarPasajero(viaje, pasajero);

            // Paso 2: Crear reserva
            String fechaReserva = LocalDate.now().toString(); // o la que quieras
            Reserva reserva = new Reserva(pasajero, viaje, fechaReserva, EstadoReserva.CONFIRMADA);

            // Paso 3: Asociar la reserva al pasajero
            pasajero.setReserva(reserva);

            System.out.println("Reserva creada con éxito.");

        } catch (ExcesoDePasajerosException e) {
            System.out.println("No se pudo crear la reserva: " + e.getMessage());
        }
    }
}
