/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportesa.excepciones;

/**
 *
 * @author Usuario
 */

public class ChoferOcupadoExcepcion extends Exception {
    public ChoferOcupadoExcepcion(String mensaje) {
        super("ERROR: No se puede asignar el viaje. " + mensaje);
    }
}

