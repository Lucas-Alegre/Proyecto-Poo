package com.mycompany.transportesa;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.mycompany.transportesa.entidades.*;
import com.mycompany.transportesa.excepciones.ChoferOcupadoExcepcion;
import com.mycompany.transportesa.excepciones.CiudadesIgualesExcepcion;
import com.mycompany.transportesa.excepciones.VehiculoYaRegistradoExcepcion;
import com.mycompany.transportesa.excepciones.ChoferYaRegistradoExcepcion;

import com.mycompany.transportesa.servicios.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author
 */
public class TransporteSa {

    public static void main(String[] args) {
        // Crear servicios
        ChoferService choferService = new ChoferService();
        VehiculoService vehiculoService = new VehiculoService();
        ViajeService viajeService = new ViajeService();
        InformeCantidadViajesService informe = new InformeCantidadViajesService();

        // 1. Crear choferes
        Chofer chofer1 = new Chofer(12345678, "Carlos", "Pérez", "ABC123", new ArrayList<>(), new ArrayList<>());
        Chofer chofer2 = new Chofer(87654321, "María", "Gómez", "XYZ789", new ArrayList<>(), new ArrayList<>());
        try {
            choferService.registrarChofer(chofer1);
            choferService.registrarChofer(chofer2);
        } catch (ChoferYaRegistradoExcepcion e) {
            System.out.println("Error al registrar chofer: " + e.getMessage());
        }
        try {
            Colectivo colectivo1 = new Colectivo("AAA111", 45, 2018, 150000.5, new ArrayList<>(), true);
            Colectivo colectivo2 = new Colectivo("BBB222", 30, 2020, 90000, new ArrayList<>(), false);

            vehiculoService.registrarVehiculo(colectivo1);
            vehiculoService.registrarVehiculo(colectivo2);

            Ciudad ciudad1 = new Ciudad("Concordia", ProvinciaEnum.ENTRE_RIOS);
            Ciudad ciudad2 = new Ciudad("Paraná", ProvinciaEnum.ENTRE_RIOS);

            viajeService.planificarViaje(
                    "20-06-2025", "08:00", "11:00",
                    1500, 300, 8000.0,
                    ciudad1, ciudad2,
                    colectivo1, chofer1
            );

            viajeService.planificarViaje(
                    "21-06-2025", "15:00", "18:00",
                    1300, 250.0, 7000,
                    ciudad2, ciudad1,
                    colectivo2, chofer2
            );

            System.out.println("----------------------------------------------------------------------");
            System.out.println("        Informe de viajes a realizar de un colectivo determinado");
            System.out.println("----------------------------------------------------------------------");
            viajeService.mostrarViajesPorColectivoDetallado(colectivo1);

        } catch (VehiculoYaRegistradoExcepcion e) {
            System.out.println("Error al registrar vehículo: " + e.getMessage());
        } catch (ChoferOcupadoExcepcion e) {
            System.out.println("Error al planificar viaje: " + e.getMessage());
        } catch (CiudadesIgualesExcepcion e) {
            System.out.println("Error al registrar cuidad origen y destino iguales: " + e.getMessage());
        }

        // 4. Mostrar viajes programados con información detallada
        System.out.println("----------------------------------------------------------------------");
        System.out.println("              Viajes programados con información detallada");
        System.out.println("----------------------------------------------------------------------");
        viajeService.mostrarViajesProgramadosDetallados();

        // 6. Informe de cantidad de viajes por chofer
        System.out.println("----------------------------------------------------------------------");
        System.out.println("        Informe de viajes a realizar de un colectivo determinado");
        System.out.println("----------------------------------------------------------------------");
        HashMap<Chofer, Integer> cantidad = informe.cantidadViajesChofer(choferService.listaChoferes());
        //DA ERROR VER 
        //informe.mostrarCantidadDeViajesPorChofer(choferService.cantidadViajesChofer(cantidad));

    }
}
