/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.transportesa;

import com.mycompany.transportesa.entidades.Colectivo;
import com.mycompany.transportesa.entidades.Minibus;
import com.mycompany.transportesa.servicios.ChoferService;
import com.mycompany.transportesa.servicios.VehiculoService;
import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class TransporteSa {

    public static void main(String[] args) {
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
                        vehiculoService.registrarVehiculo(new Colectivo(patente, capacidad, anioFabricacion, kilometraje, pisoDoble));
                    } else {
                        System.out.print("Posee bodega?");
                        boolean tieneBodega= sc.nextBoolean();
                        System.out.print("Posee aire acondicionado?");
                        boolean aireAcondicionado= sc.nextBoolean();
                        vehiculoService.registrarVehiculo(new Minibus(patente, capacidad, anioFabricacion, kilometraje,tieneBodega,aireAcondicionado));
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
    }
}
