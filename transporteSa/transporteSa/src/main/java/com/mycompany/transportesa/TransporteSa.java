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
import com.mycompany.transportesa.excepciones.ExcesoDePasajerosException;
import com.mycompany.transportesa.excepciones.VehiculoNoDisponibleExcepcion;

import com.mycompany.transportesa.servicios.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 **
 * @author
 */
public class TransporteSa {

    public static void main(String[] args) throws ExcesoDePasajerosException, CiudadesIgualesExcepcion, ChoferOcupadoExcepcion, VehiculoNoDisponibleExcepcion {

        Scanner scanner = new Scanner(System.in);
        // Crear servicios

        ChoferService choferService = new ChoferService();
        VehiculoService vehiculoService = new VehiculoService();
        ViajeService viajeService = new ViajeService();
        InformeCantidadViajesService informe = new InformeCantidadViajesService();
        PasajeroService pasajeroService = new PasajeroService(viajeService);
        ReservaService reservaService = new ReservaService(viajeService);

        //Creacion de Pasajeros
        //Se agregan pasajeros
        Pasajero pasajero1 = new Pasajero(427363535, "Lucas", "Alegre", "lucas@gmail.cim", "050937434");
        Pasajero pasajero2 = new Pasajero(411665745, "Ricardo", "Arjona", "riocardeli@gmail.cim", "3454634");
        //Registro de pasajeros, sin viajes ni nada asignado.
        pasajeroService.registrarPasajeros(pasajero1);
        pasajeroService.registrarPasajeros(pasajero2);

        // Crear choferes
        Chofer chofer1 = new Chofer(12345678, "Carlos", "Pérez", "ABC123", new ArrayList<>(), new ArrayList<>());
        Chofer chofer2 = new Chofer(87654321, "María", "Gómez", "XYZ789", new ArrayList<>(), new ArrayList<>());
        Chofer chofer3 = new Chofer(11111111, "Luis", "Martínez", "LIC001", new ArrayList<>(), new ArrayList<>());
        Chofer chofer4 = new Chofer(22222222, "Ana", "López", "LIC002", new ArrayList<>(), new ArrayList<>());
        Chofer chofer5 = new Chofer(33333333, "Diego", "Ruiz", "LIC003", new ArrayList<>(), new ArrayList<>());
        Chofer chofer6 = new Chofer(44444444, "Laura", "Fernández", "LIC004", new ArrayList<>(), new ArrayList<>());
        Chofer chofer7 = new Chofer(55555555, "Jorge", "Sánchez", "LIC005", new ArrayList<>(), new ArrayList<>());
        Chofer chofer8 = new Chofer(66666666, "Sofía", "Ramírez", "LIC006", new ArrayList<>(), new ArrayList<>());
        Chofer chofer9 = new Chofer(77777777, "Tomás", "García", "LIC007", new ArrayList<>(), new ArrayList<>());
        Chofer chofer10 = new Chofer(88888888, "Lucía", "Morales", "LIC008", new ArrayList<>(), new ArrayList<>());

        /**
         * try { choferService.registrarChofer(chofer1);
         * choferService.registrarChofer(chofer2);
         * choferService.registrarChofer(chofer3);
         * choferService.registrarChofer(chofer4);
         * choferService.registrarChofer(chofer5);
         * choferService.registrarChofer(chofer6);
         * choferService.registrarChofer(chofer7);
         * choferService.registrarChofer(chofer8);
         * choferService.registrarChofer(chofer9);
         * choferService.registrarChofer(chofer10); } catch
         * (ChoferYaRegistradoExcepcion e) { System.out.println("Error al
         * registrar chofer: " + e.getMessage()); }*
         */
        // Crear colectivos
        Colectivo col1 = new Colectivo("AAA111", 50, 2020, 150000, new ArrayList<>(), true);
        Colectivo col2 = new Colectivo("BBB222", 45, 2019, 140000, new ArrayList<>(), false);
        Colectivo col3 = new Colectivo("CCC333", 60, 2021, 160000, new ArrayList<>(), true);
        Colectivo col4 = new Colectivo("DDD444", 55, 2022, 170000, new ArrayList<>(), false);
        Colectivo col5 = new Colectivo("EEE555", 40, 2018, 130000, new ArrayList<>(), true);

        // Crear minibuses
        Minibus minibus1 = new Minibus("AAA111", 50, 2020, 150000, new ArrayList<>(), true, true); // si anda mal rompe acàs no sigue abajo y va al swirch
        Minibus minibus2 = new Minibus("BBB222", 45, 2019, 140000, new ArrayList<>(), false, true);
        Minibus minibus3 = new Minibus("CCC333", 60, 2021, 160000, new ArrayList<>(), true, false);
        Minibus minibus4 = new Minibus("DDD444", 55, 2022, 170000, new ArrayList<>(), false, false);
        Minibus minibus5 = new Minibus("EEE555", 40, 2018, 130000, new ArrayList<>(), true, true);

        try {
            vehiculoService.registrarVehiculo(col1);
            vehiculoService.registrarVehiculo(col2);
            vehiculoService.registrarVehiculo(col3);
            vehiculoService.registrarVehiculo(col4);
            vehiculoService.registrarVehiculo(col5);

            vehiculoService.registrarVehiculo(minibus1);
            vehiculoService.registrarVehiculo(minibus2);
            vehiculoService.registrarVehiculo(minibus3);
            vehiculoService.registrarVehiculo(minibus4);
            vehiculoService.registrarVehiculo(minibus5);
        } catch (VehiculoYaRegistradoExcepcion e) {
            System.out.println("Error al registrar vehículo: " + e.getMessage());
        }

        // Crear ciudades (una por provincia)
        Ciudad ciudad1 = new Ciudad("La Plata", ProvinciaEnum.BUENOS_AIRES);
        Ciudad ciudad2 = new Ciudad("Resistencia", ProvinciaEnum.CHACO);
        Ciudad ciudad3 = new Ciudad("Córdoba", ProvinciaEnum.CORDOBA);
        Ciudad ciudad4 = new Ciudad("Rawson", ProvinciaEnum.CHUBUT);
        Ciudad ciudad5 = new Ciudad("Mendoza", ProvinciaEnum.MENDOZA);
        Ciudad ciudad6 = new Ciudad("Posadas", ProvinciaEnum.MISIONES);
        Ciudad ciudad7 = new Ciudad("Salta", ProvinciaEnum.SALTA);
        Ciudad ciudad8 = new Ciudad("Ushuaia", ProvinciaEnum.TIERRA_DEL_FUEGO);
        Ciudad ciudad9 = new Ciudad("Santa Rosa", ProvinciaEnum.LA_PAMPA);
        Ciudad ciudad10 = new Ciudad("Paraná", ProvinciaEnum.ENTRE_RIOS);

        System.out.println("-------------------------------------------------------------------");
        System.out.println("------------------BIENVENIDO A TRANSPORTE S.A--------------------");
        System.out.println("-------------------------------MENU------------------------------");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("                 " + "1. Cargar choferes ");
        System.out.println("                 " + "2. Cargar vehiculos ");
        System.out.println("                 " + "3. Planificar viaje");
        System.out.println("                 " + "4. Mostrar viajes programados detalladamente");
        System.out.println("                 " + "5. Mostrar viajes por colectivo");
        System.out.println("                 " + "6. Informe de cantidad de viajes por chofer");
        System.out.println("                 " + "Ingrese opcion: ");
        System.out.println("-------------------------------------------------------------------");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        switch (opcion) {
            case 1:
                System.out.println("Registrar chofer precargado");
                try {
                    choferService.registrarChofer(chofer1);
                    choferService.registrarChofer(chofer2);
                    System.out.println("Choferes cargados correctamente.");
                } catch (ChoferYaRegistradoExcepcion e) {
                    System.out.println("Error al registrar chofer: " + e.getMessage());
                }
                break;

            case 2:
                System.out.println("Cargar vehículo por consola.");
                // cargarVehiculoPorConsola(vehiculoService);
                break;

            case 3:
                System.out.println("Planificar viaje...");
                // planificarViajeConsola(viajeService, choferService, vehiculoService);
                break;

            case 4:
                System.out.println("Mostrar viajes programados detalladamente...");
                // 4. Mostrar viajes programados con información detallada
                System.out.println("----------------------------------------------------------------------");
                System.out.println("              Viajes programados con información detallada");
                System.out.println("----------------------------------------------------------------------");
                viajeService.mostrarViajesProgramadosDetallados();
                break;

            case 5:
                System.out.println("Mostrar viajes por colectivo...");
                // mostrarViajesPorColectivo(viajeService);
                break;

            case 6:
                System.out.println("Informe de cantidad de viajes por chofer...");
                // 6. Informe de cantidad de viajes por chofer
                System.out.println("----------------------------------------------------------------------");
                System.out.println("        Informe de viajes a realizar de un colectivo determinado");
                System.out.println("----------------------------------------------------------------------");

                HashMap<Chofer, Integer> cantidad = informe.cantidadViajesChofer(choferService.listaChoferes());
                informe.mostrarInformeCantidadViajes(cantidad);
                break;

            default:
                System.out.println("Opción no válida.");
        }

        scanner.close();

        

            Viaje ViajeSinChoferNiVehiculoAsignado = viajeService.crearUnViaje("18-06-2025", "21:00", "22:00",1500, 300, 8000.0,ciudad1, ciudad2);

            System.out.println("EL VIAJE CREADOR SIN CHOFER NI VEHICULO ES: " + ViajeSinChoferNiVehiculoAsignado);
            viajeService.asignarChoferAUnViaje(ViajeSinChoferNiVehiculoAsignado, chofer2);
            viajeService.asignarVehiculoAUnViaje(col1, ViajeSinChoferNiVehiculoAsignado);
            //Ver donde nos rompe, tips => Revisar en donde se llama al getLista de vehiculos, porque ahi rompe si es null

            //Crear una reserva para un pasajero en un viaje si es posible.
            //Si se pretende realizar una reserva, y no tenemos un vehiculo non puede comparar
            //Para saber si puede agregar un pasajero a ese viaje.
            //1- El cupo lo debe llevar el viaje y no los vehiculos. o 2- No se puede crear una reserva hasta que se agregue un vehiculo al viaje 
            reservaService.realizarReserva(pasajero1, ViajeSinChoferNiVehiculoAsignado);//Salio_ok
            reservaService.realizarReserva(pasajero2, ViajeSinChoferNiVehiculoAsignado);

            // Este fallará si es menos de 8 horas después 
            /*viajeService.planificarViaje(
                        "21-06-2025", "10:00", "12:00",
                        1300, 250.0, 7000,
                        ciudad2, ciudad1,
                        colectivo2, chofer1
            );*/
 /*viajeService.planificarViaje(
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
            );*/
            //TEST DE PRUEBA DE IMPLEMENTACION DE QUE NO SUPERPONGAN VIAJES A UN MISMO CHOFER Y UN CHOFER DEBA DESCANSAR AL MENOS 8 HORAS
            System.out.println("----------------------------------------------------------------------");
            System.out.println("        Informe de viajes a realizar de un colectivo determinado");
            System.out.println("----------------------------------------------------------------------");
            viajeService.mostrarViajesPorColectivoDetallado(col1);

        
    }
}
