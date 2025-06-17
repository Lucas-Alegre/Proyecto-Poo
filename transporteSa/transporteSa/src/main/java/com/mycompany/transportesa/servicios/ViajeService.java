package com.mycompany.transportesa.servicios;

import com.mycompany.transportesa.entidades.*;
import java.util.ArrayList;

/**
 *
 * @author 
 */

public class ViajeService {

    private ArrayList<Viaje> listaViajes;

    public ViajeService() {
        listaViajes = new ArrayList<>();
    }

    public void agregarViaje(Viaje viaje) {
        listaViajes.add(viaje);
    }

    public void eliminarViaje(Viaje viaje) {
        listaViajes.remove(viaje);
    }

    public ArrayList<Viaje> getListaViajes() {
        return listaViajes;
    }

    // Planificar un viaje entre dos ciudades
    public Viaje planificarViaje(String fecha, String horaSalida, String horaLlegada,
                                  double precio, double distancia, double costo,
                                  Ciudad origen, Ciudad destino,
                                  Vehiculo vehiculo, Chofer chofer) {

        if (!choferLibreEseDia(chofer, fecha)) {
            System.out.println("El chofer ya tiene un viaje en esa fecha.");
            return null;
        }

        Viaje viaje = new Viaje(
            fecha,
            horaSalida,
            horaLlegada,
            precio,
            distancia,
            costo,
            EstadoDeViajeEnum.PROGRAMADO,
            origen,
            destino,
            vehiculo,
            chofer,
            null,
            new ArrayList<>()
        );

        listaViajes.add(viaje);
        chofer.getViajeLista().add(viaje);
        return viaje;
    }

    // Verifica si el chofer está libre ese día
    private boolean choferLibreEseDia(Chofer chofer, String fecha) {
        for (Viaje v : chofer.getViajeLista()) {
            if (v.getFecha().equals(fecha)) {
                return false;
            }
        }
        return true;
    }

    // Mostrar todos los viajes
    public void mostrarViajes() {
        for (Viaje v : listaViajes) {
            System.out.println(v);
        }
    }

    // Mostrar los viajes programados con información detallada
    public void mostrarViajesProgramadosDetallados() {
        System.out.println("-------------------- VIAJES PROGRAMADOS --------------------");

        for (Viaje viaje : listaViajes) {
            if (viaje.getEstadoDeViaje() == EstadoDeViajeEnum.PROGRAMADO) {
                System.out.println("Fecha: " + viaje.getFecha());
                System.out.println("Horario de salida: " + viaje.getHorarioSalida());
                System.out.println("Desde: " + viaje.getCiudadOrigen().getNombre());
                System.out.println("Hasta: " + viaje.getCiudadDestino().getNombre());
                System.out.println("Chofer: " + viaje.getChofer().getNombre() + " " + viaje.getChofer().getApellido());
                System.out.println("Vehículo: Patente " + viaje.getVehiculo().getPatente());
                System.out.println("Cantidad de pasajeros: " + viaje.getPasajeroLista().size());
                System.out.println("Precio por pasajero: $" + viaje.getPrecioPorPasajero());
                System.out.println("Estado: " + viaje.getEstadoDeViaje());
                System.out.println("-----------------------------------------------------------------------------");
            }
        }
    }

    // Informe detallado de viajes que tiene que realizar un colectivo
    public void mostrarViajesPorColectivoDetallado(Colectivo colectivo) {
        System.out.println("-------------------- INFORME DETALLADO DE VIAJES PARA EL COLECTIVO --------------------");
        System.out.println("Patente: " + colectivo.getPatente());

        boolean viajeActivo = false;

        for (Viaje viaje : listaViajes) {
            if (viaje.getVehiculo().equals(colectivo) &&
                viaje.getEstadoDeViaje() != EstadoDeViajeEnum.FINALIZADO) {

                viajeActivo = true;
                System.out.println("Fecha: " + viaje.getFecha());
                System.out.println("Horario salida: " + viaje.getHorarioSalida());
                System.out.println("Ciudad origen: " + viaje.getCiudadOrigen().getNombre());
                System.out.println("Ciudad destino: " + viaje.getCiudadDestino().getNombre());
                System.out.println("Chofer: " + viaje.getChofer().getNombre() + " " + viaje.getChofer().getApellido());
                System.out.println("Cantidad de pasajeros: " + viaje.getPasajeroLista().size());
                System.out.println("Precio por pasajero: $" + viaje.getPrecioPorPasajero());
                System.out.println("Estado: " + viaje.getEstadoDeViaje());
                System.out.println("-----------------------------------------------------------------------------");
            }
        }

        if (!viajeActivo) {
            System.out.println("No hay viajes programados o en curso para este colectivo.");
        }
    }
}
