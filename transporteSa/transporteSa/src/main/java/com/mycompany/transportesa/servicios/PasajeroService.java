/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportesa.servicios;

import com.mycompany.transportesa.entidades.Pasajero;
import com.mycompany.transportesa.entidades.Viaje;
import com.mycompany.transportesa.excepciones.ExcesoDePasajerosException;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class PasajeroService {

    private ArrayList<Pasajero> listaPasajeros;
    private ViajeService viajeService;

    public PasajeroService(ViajeService viajeService) {
        this.listaPasajeros = new ArrayList<>();
        this.viajeService = viajeService;
    }

    public void registrarPasajeros(Pasajero pasajero) {
        listaPasajeros.add(pasajero);
    }

    public Pasajero encontrarPasajeroPorDni(Long dni) {
        for (Pasajero p : listaPasajeros) {
            if (p.getDni() == (dni)) {
                return p;
            }
        }
        return null;
    }

    public void registrarUnPasajeroAlViaje(Long dniPasajero, Viaje viaje) {
        Pasajero pasajeroEncontrado = encontrarPasajeroPorDni(dniPasajero);
        if (pasajeroEncontrado == null) {
            System.out.println("Pasajero no encontrado");
            return;
        }
        try {
            viajeService.validarYAgregarPasajero(viaje, pasajeroEncontrado);
            System.out.println("Psajero agregado al viaje correctamente");

        } catch (ExcesoDePasajerosException e) {
            System.out.println("No se puede agregar al viaje" + e.getMessage());
        }

    }
}
