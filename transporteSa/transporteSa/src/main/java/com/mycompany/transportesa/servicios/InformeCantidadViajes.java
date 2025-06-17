/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportesa.servicios;

import com.mycompany.transportesa.entidades.Chofer;
import com.mycompany.transportesa.entidades.Colectivo;
import com.mycompany.transportesa.entidades.Viaje;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author
 */
public class InformeCantidadViajes {

// pto 6 y validar si el chofer no aparece dos veces por ejemplo
    public HashMap<Chofer, Integer> cantidadViajesChofer(ArrayList<Chofer> choferLista) {

        HashMap<Chofer, Integer> choferesMap = new HashMap<>();
        ArrayList<Long> dniProcesado = new ArrayList<>();

        for (Chofer chofer : choferLista) {
            if (!dniProcesado.contains(chofer.getDni())) {
                int cantidad = 0;
                for (Viaje viaje : chofer.getViajeLista()) {

                    if (viaje.getVehiculo() instanceof Colectivo) {
                        if (viaje.getVehiculo() instanceof Colectivo && viaje.getChofer().getDni() == chofer.getDni()) {
                            cantidad++;
                        }
                    }
                }
                choferesMap.put(chofer, cantidad);
                dniProcesado.add(chofer.getDni());
            }
        }
        return choferesMap;
    }

    public void mostrarInformeCantidadViajes(HashMap<Chofer, Integer> informe) {
        for (Chofer chofer : informe.keySet()) {
            int cantidad = informe.get(chofer);
            System.out.println("Chofer " + chofer.getNombre() + " " + chofer.getApellido() + " realizó " + cantidad + " viaje(s) en colectivo.");
        }
    }

}
