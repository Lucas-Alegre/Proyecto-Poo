/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.transportesa;

import com.mycompany.transportesa.entidades.Chofer;
import com.mycompany.transportesa.entidades.Ciudad;
import com.mycompany.transportesa.entidades.Colectivo;
import com.mycompany.transportesa.entidades.Minibus;
import com.mycompany.transportesa.entidades.ProvinciaEnum;
import com.mycompany.transportesa.entidades.Viaje;
import com.mycompany.transportesa.servicios.ChoferService;
import com.mycompany.transportesa.servicios.InformeCantidadViajes;
import com.mycompany.transportesa.servicios.ReservaService;
import com.mycompany.transportesa.servicios.VehiculoService;
import com.mycompany.transportesa.servicios.ViajeService;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class TransporteSa {

    public static void main(String[] args) {
        ViajeService viajeService = new ViajeService();
        ReservaService reservaService = new ReservaService();
        ChoferService choferService = new ChoferService();
        VehiculoService vehiculoService = new VehiculoService();
        
        
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--------- Menú ---------");
            System.out.println("1. Registrar Chofer");
            System.out.println("2. Registrar Vehículo");
            System.out.println("3. Ver Choferes");
            System.out.println("4. Ver Vehículos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("DNI: ");
                    String dni = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Nùmero Licencia: ");
                    String nroLicencia = sc.nextLine();
                    System.out.print("Chofer Categoria: ");
                    //agregar el chofer de la categoria con los datos ya cargados por el usuario
                   // String categoriachofer = sc.nextLine(); //            List<ChoferCategoria> categorias
                    //choferService.registrarChofer(new Chofer(dni, nombre, apellido,nroLicencia,categoria));
                    break;
                    
                case 2:
                    System.out.print("Patente: ");
                    String patente = sc.nextLine();
                    System.out.print("Capacidad: ");
                    Integer capacidad = sc.nextInt();
                    System.out.print("Año de fabricacion: ");
                    Integer anioFabricacion = sc.nextInt();
                    System.out.print("Kilometraje: ");
                    double kilometraje = sc.nextDouble();
                    
                    System.out.print("Tipo (1 = Colectivo, 2 = Minibús): ");
                    int tipo = sc.nextInt(); sc.nextLine();

                    if (tipo == 1) {
                        System.out.print("Posee piso doble?");
                        boolean pisoDoble= sc.nextBoolean();
                       // vehiculoService.registrarVehiculo(new Colectivo(patente, capacidad, anioFabricacion, kilometraje, pisoDoble));
                    } else {
                        System.out.print("Posee bodega?");
                        boolean tieneBodega= sc.nextBoolean();
                        System.out.print("Posee aire acondicionado?");
                        boolean aireAcondicionado= sc.nextBoolean();
                     //   vehiculoService.registrarVehiculo(new Minibus(patente, capacidad, anioFabricacion, kilometraje,tieneBodega,aireAcondicionado));
                    }
                    break;

                case 3:
                    choferService.mostrarChoferes();
                    break;

                case 4:
                   vehiculoService.mostrarVehiculos();
                    break;
            }
        } while (opcion != 0);

        System.out.println("¡Hasta Pronto :)!"); // Mensaje ultimo por despedida, necesario? no, pero qsy
        
        
        //Benja: Crear logica para agregar ciudades y crear viajes con ciudad de origen y destino
        //Lucas: Crear logica para agregar Vehículos y Choferes
        //Creo Ciudades
    /*
        Ciudad ciudadConcordia = new Ciudad("Concordia",ProvinciaEnum.ENTRE_RIOS);
        Ciudad ciudadParana = new Ciudad("Parana",ProvinciaEnum.ENTRE_RIOS);
        Ciudad ciudadRosario = new Ciudad("Rosario",ProvinciaEnum.SANTA_FE);
        Ciudad ciudadLanus = new Ciudad("Lanus",ProvinciaEnum.BUENOS_AIRES);
        
        //Creo Viajes
        //Se comenta hasta que se creen los choferes y vehiculos
        Viaje viaje1 = new Viaje("11/10/2025","22:23:10", "23:30:00",1000.00,100.1,10.0,ciudadConcordia,ciudadParana); //Hay que tomar el chofer y vehiculo creado por Caro Y ver como crear los viajes
        Viaje viaje2 = new Viaje("10/11/2025","11:11:10","13:00:00",1010.10,99.1,9.10,ciudadRosario,ciudadLanus);     // Lo mismo que arriba
        Viaje viaje3 = new Viaje("11/10/2025","23:23:10","24:00:00",1000.00,100.1,10.0,ciudadConcordia,ciudadParana); // Lo mismo qeu arriba
        Viaje viaje4 = new Viaje("11/10/2025","18:00:00","20:45:00",1000.00,100.1,10.0,ciudadConcordia,ciudadParana); // Lo mismo que arriba     
      */  
        //Asignación de choferes y vehiculos a los viajes
        //Se deben asignar choferes y vehiculos cuando esten creados
        /*viaje1.agregarUnChoferAlViaje(chofer1);
        viaje1.agregarUnVehiculoAlViaje(vehiculo1);
        viaje2.agregarUnChoferAlViaje(chofer2);
        viaje2.agregarUnVehiculoAlViaje(vehiculo2);
        viaje3.agregarUnChoferAlViaje(chofer3);
        viaje3.agregarUnVehiculoAlViaje(vehiculo3);
        viaje4.agregarUnChoferAlViaje(chofer4);
        viaje4.agregarUnVehiculoAlViaje(vehiculo4);*/
    /*    
        viajeService.agregarViaje(viaje1);
        viajeService.agregarViaje(viaje2);
        viajeService.agregarViaje(viaje3);
        viajeService.agregarViaje(viaje4);
        
       viajeService.mostrarViajesDetallados();
       */
       //viajeService.viajesPorVehiculo(vehiculo3); //Hay que crear un vehiculo con ese nombre y enviarlo
       //Termino lo de benja y Lucas punto 2,3,4 y 5
       
       InformeCantidadViajes service = new InformeCantidadViajes();
        // no agregaron choferes asi pos weno dara error por un tiempis
       //HashMap<Chofer, Integer> informe = service.cantidadViajesChofer(choferLista);
      // service.mostrarInformeCantidadViajes(informe);
    }
}
