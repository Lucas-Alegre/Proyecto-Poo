package com.mycompany.transportesa.servicios;

import com.mycompany.transportesa.entidades.*;
import com.mycompany.transportesa.excepciones.*;

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

    public void mostrarViajes() {
        for (Viaje v : listaViajes) {
            System.out.println(v);
        }
    }

    //2. Planificar un viaje entre dos ciudades
    public Viaje planificarViaje(String fecha, String horaSalida, String horaLlegada,
            double precio, double distancia, double costo,
            Ciudad origen, Ciudad destino, Vehiculo vehiculo, Chofer chofer) throws ChoferOcupadoExcepcion, CiudadesIgualesExcepcion {

        // Antes de crear el viaje, verifica que el chofer esté disponible ese día
        for (Viaje v : chofer.getViajeLista()) {
            if (v.getFecha().equals(fecha)) {
                throw new ChoferOcupadoExcepcion("El chofer ya tiene un viaje programado para la fecha " + fecha);
            }
        }
        if (origen.equals(destino)) {
            throw new CiudadesIgualesExcepcion("La ciudad de origen y destino no pueden ser la misma.");
        }

        // Crea el nuevo viaje con todos los datos
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

    //4. Mostrar los viajes programados con informacion detallada
    public void mostrarViajesProgramadosDetallados() {

        for (Viaje viaje : listaViajes) {
            if (viaje.getEstadoDeViaje() == EstadoDeViajeEnum.PROGRAMADO) {
                System.out.println("Fecha: " + viaje.getFecha());
                System.out.println("Horario de salida: " + viaje.getHorarioSalida());
                System.out.println("Desde: " + viaje.getCiudadOrigen().getNombre());
                System.out.println("Hasta: " + viaje.getCiudadDestino().getNombre());
                System.out.println("Chofer: " + viaje.getChofer().getNombre() + " " + viaje.getChofer().getApellido());
                System.out.println("Vehículo: Patente " + viaje.getVehiculo().getPatente());
                System.out.println("Cantidad de pasajeros: " + viaje.getPasajeroLista().size()); // Cuando se cargue hay que hacer una validacion que no supere la cantidad de asientos del vehiculo (colectivo:60 y minibus:20)
                System.out.println("Precio por pasajero: $" + viaje.getPrecioPorPasajero());
                System.out.println("Estado: " + viaje.getEstadoDeViaje());
            }
        }
    }

    //5. Informe detallado de viajes que tiene que realizar un colectivo
    public void mostrarViajesPorColectivoDetallado(Colectivo colectivo) {
        System.out.println("Patente: " + colectivo.getPatente());

        boolean tieneViajesPendientes = false;

        for (Viaje viaje : listaViajes) {
            if (viaje.getVehiculo().equals(colectivo)
                    && viaje.getEstadoDeViaje() != EstadoDeViajeEnum.FINALIZADO) {

                tieneViajesPendientes = true;
                System.out.println("Fecha: " + viaje.getFecha());
                System.out.println("Horario salida: " + viaje.getHorarioSalida());
                System.out.println("Ciudad origen: " + viaje.getCiudadOrigen().getNombre());
                System.out.println("Ciudad destino: " + viaje.getCiudadDestino().getNombre());
                System.out.println("Chofer: " + viaje.getChofer().getNombre() + " " + viaje.getChofer().getApellido());
                System.out.println("Cantidad de pasajeros: " + viaje.getPasajeroLista().size());
                System.out.println("Precio por pasajero: $" + viaje.getPrecioPorPasajero());
                System.out.println("Estado: " + viaje.getEstadoDeViaje());
            }
        }

        if (!tieneViajesPendientes) {
            System.out.println("No hay viajes para este colectivo.");
        }

    }
    //FALTA EXCEPCION: validar: que las cuidades y origen no sean iguales y  se valide si el vehículo ya está ocupado ese día
}
