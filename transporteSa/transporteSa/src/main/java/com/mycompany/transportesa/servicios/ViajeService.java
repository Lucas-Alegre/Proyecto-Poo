package com.mycompany.transportesa.servicios;

import com.mycompany.transportesa.entidades.*;
import com.mycompany.transportesa.excepciones.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public void asignarVehiculoAUnViaje(Viaje viaje, Vehiculo vehiculo) {
        viaje.setVehiculo(vehiculo);
    }

    public Viaje crearUnViaje(String fecha, String horaSalida, String horaLlegada,
            double precio, double distancia, double costo,
            Ciudad origen, Ciudad destino) throws CiudadesIgualesExcepcion{

        if (origen.equals(destino)) {
            throw new CiudadesIgualesExcepcion("La ciudad de origen y destino no pueden ser la misma.");
        }

        Viaje viajeNuevaVersion = new Viaje(
                fecha,
                horaSalida,
                horaLlegada,
                precio,
                distancia,
                costo,
                EstadoDeViajeEnum.PROGRAMADO,
                origen,
                destino
        );
        listaViajes.add(viajeNuevaVersion);
        return viajeNuevaVersion;

    }

    public void asignarVehiculoAUnViaje(Vehiculo vehiculo, Viaje viaje) {
        //Crear logica de validación
        viaje.setVehiculo(vehiculo);
        vehiculo.getViajeLista().add(viaje);
        System.out.println("El Vehiculo " + vehiculo + "fue asignado correctamente al viaje: " + viaje);
    }

    public void asignarChoferAUnViaje(Viaje viaje, Chofer chofer) throws ChoferOcupadoExcepcion {
        // Convertir fechas  QUE SON TIPO STRING DE ENTRADA (Esto lo tuve que googlear porque no tenia idea) a LocalDateTime para comparación
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime nuevaSalida = LocalDateTime.parse(viaje.getFecha() + " " + viaje.getHorarioSalida(), formatter);
        LocalDateTime nuevaLlegada = LocalDateTime.parse(viaje.getFecha() + " " + viaje.getHorarioLlegada(), formatter);

        //sin esto hay error cuandos se pasa de dia //suma un dia si pasa eso
        if (nuevaLlegada.isBefore(nuevaSalida)) {
            nuevaLlegada = nuevaLlegada.plusDays(1);
        }

        // Validar disponibilidad del chofer considerando tiempo entre viajes
        for (Viaje viajeExistente : chofer.getViajeLista()) {
            LocalDateTime salidaExistente = LocalDateTime.parse(viajeExistente.getFecha() + " " + viajeExistente.getHorarioSalida(), formatter);
            LocalDateTime llegadaExistente = LocalDateTime.parse(viajeExistente.getFecha() + " " + viajeExistente.getHorarioLlegada(), formatter);

            // Ajuste para viajes existentes que cruzan medianoche
            if (llegadaExistente.isBefore(salidaExistente)) {
                llegadaExistente = llegadaExistente.plusDays(1);
            }
            //Validacion para 8 horas de descanso
            boolean tieneDescansoSuficiente = nuevaSalida.isAfter(llegadaExistente.plusHours(8)) || nuevaSalida.equals(llegadaExistente.plusHours(8));
            boolean noInterfiereConViajeAnterior = nuevaLlegada.isBefore(salidaExistente.minusHours(8)) || nuevaLlegada.equals(salidaExistente.minusHours(8));

            if (!(tieneDescansoSuficiente || noInterfiereConViajeAnterior)) {
                throw new ChoferOcupadoExcepcion("El chofer no está disponible. Requiere mínimo 8 horas de descanso. " + "Último viaje programado: " + viajeExistente.getFecha() + " " + viajeExistente.getHorarioSalida() + " - " + viajeExistente.getHorarioLlegada() + ". Intento de asignar: " + viaje.getFecha() + " " + viaje.getHorarioSalida() + " - " + viaje.getHorarioLlegada());
            }
        }

        viaje.setChofer(chofer);
        chofer.getViajeLista().add(viaje);
        System.out.println("El chofer " + chofer + "fue asignado correctamente al viaje: " + viaje);
    }

    //2. Planificar un viaje entre dos ciudades
    public Viaje planificarViaje(String fecha, String horaSalida, String horaLlegada,
            double precio, double distancia, double costo,
            Ciudad origen, Ciudad destino, Vehiculo vehiculo, Chofer chofer)
            throws ChoferOcupadoExcepcion, CiudadesIgualesExcepcion, ExcesoDePasajerosException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime nuevaSalida = LocalDateTime.parse(fecha + " " + horaSalida, formatter);
        LocalDateTime nuevaLlegada = LocalDateTime.parse(fecha + " " + horaLlegada, formatter);

        //sin esto hay error cuandos se pasa de dia //suma un dia si pasa eso
        if (nuevaLlegada.isBefore(nuevaSalida)) {
            nuevaLlegada = nuevaLlegada.plusDays(1);
        }

        // Validar disponibilidad del chofer considerando tiempo entre viajes
        for (Viaje viajeExistente : chofer.getViajeLista()) {
            LocalDateTime salidaExistente = LocalDateTime.parse(viajeExistente.getFecha() + " " + viajeExistente.getHorarioSalida(), formatter);
            LocalDateTime llegadaExistente = LocalDateTime.parse(viajeExistente.getFecha() + " " + viajeExistente.getHorarioLlegada(), formatter);

            // Ajuste para viajes existentes que cruzan medianoche
            if (llegadaExistente.isBefore(salidaExistente)) {
                llegadaExistente = llegadaExistente.plusDays(1);
            }
            //Validacion para 8 horas de descanso
            boolean tieneDescansoSuficiente = nuevaSalida.isAfter(llegadaExistente.plusHours(8)) || nuevaSalida.equals(llegadaExistente.plusHours(8));
            boolean noInterfiereConViajeAnterior = nuevaLlegada.isBefore(salidaExistente.minusHours(8)) || nuevaLlegada.equals(salidaExistente.minusHours(8));

            if (!(tieneDescansoSuficiente || noInterfiereConViajeAnterior)) {
                throw new ChoferOcupadoExcepcion("El chofer no está disponible. Requiere mínimo 8 horas de descanso. " + "Último viaje programado: " + viajeExistente.getFecha() + " " + viajeExistente.getHorarioSalida() + " - " + viajeExistente.getHorarioLlegada() + ". Intento de asignar: " + fecha + " " + horaSalida + " - " + horaLlegada);
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

        //llamamos al metodo que valida capacidad de pasajeros antes de agregar la lista a viajes
        validarCapacidadVehiculo(viaje);
        //se agrega el viaje si esta todo ok
        listaViajes.add(viaje);
        //se suma el viaje a la lista de chofer
        chofer.getViajeLista().add(viaje);
        return viaje;
    }

    //Valida si un colectivo tiene menos de 60 pasajeros y un minibus menos de 20 pasajeros.
    public void validarCapacidadVehiculo(Viaje viaje) throws ExcesoDePasajerosException {
        int cantidadPasajeros = viaje.getPasajeroLista().size();

        if (viaje.getVehiculo() instanceof Colectivo && cantidadPasajeros > 60) {
            throw new ExcesoDePasajerosException("El colectivo no puede transportar mas de 60 pasajeros.");
        }

        if (viaje.getVehiculo() instanceof Minibus && cantidadPasajeros > 20) {
            throw new ExcesoDePasajerosException("El minibús no puede transportar mas de 20 pasajeros");
        }
    }

    public void validarYAgregarPasajero(Viaje viaje, Pasajero pasajero) throws ExcesoDePasajerosException {
        int capacidad = viaje.getVehiculo().getCapacidad();
        if (viaje.getPasajeroLista().size() >= capacidad){
            throw new ExcesoDePasajerosException("El vehículo ya está completo.");
        }

        viaje.agregarPasajero(pasajero);
    }

    //4. Mostrar los viajes programados con informacion detallada
    public void mostrarViajesProgramadosDetallados() {

        for (Viaje viaje : listaViajes) {
            if (viaje.getEstadoDeViaje() == EstadoDeViajeEnum.PROGRAMADO) {
                System.out.println("Fecha: " + viaje.getFecha());
                System.out.println("Horario de salida: " + viaje.getHorarioSalida());
                System.out.println("Desde: " + viaje.getCiudadOrigen().getNombre());
                System.out.println("Hasta: " + viaje.getCiudadDestino().getNombre());
               
               if (viaje.getChofer() != null) {
                    System.out.println("Chofer: " + viaje.getChofer().getNombre() + " " + viaje.getChofer().getApellido());
                } else {
                    System.out.println("Chofer: [NO ASIGNADO]");
                }


                if (viaje.getVehiculo() != null) {
                    System.out.println("Vehículo: Patente " + viaje.getVehiculo().getPatente());
                   
                } else {
                    System.out.println("Vehículo: [NO ASIGNADO]");
                }

                if (viaje.getPasajeroLista() != null && !viaje.getPasajeroLista().isEmpty()) {
                    System.out.println("Cantidad de pasajeros: " + viaje.getPasajeroLista().size());
                } else {
                    System.out.println("Cantidad de pasajeros: [NINGUNO ASIGNADO]");
                }

                //System.out.println("Chofer: " + viaje.getChofer().getNombre() + " " + viaje.getChofer().getApellido());
                //System.out.println("Vehículo: Patente " + viaje.getVehiculo().getPatente());
                //System.out.println("Cantidad de pasajeros: " + viaje.getPasajeroLista().size()); // Cuando se cargue hay que hacer una validacion que no supere la cantidad de asientos del vehiculo (colectivo:60 y minibus:20)
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
            /*if (viaje.getVehiculo().equals(colectivo)
                    && viaje.getEstadoDeViaje() != EstadoDeViajeEnum.FINALIZADO)*/
                if (viaje.getVehiculo() != null 
                && viaje.getVehiculo().equals(colectivo)
                && viaje.getEstadoDeViaje() != EstadoDeViajeEnum.FINALIZADO) {

                tieneViajesPendientes = true;
                System.out.println("Fecha: " + viaje.getFecha());
                System.out.println("Horario salida: " + viaje.getHorarioSalida());
                System.out.println("Ciudad origen: " + viaje.getCiudadOrigen().getNombre());
                
                System.out.println("Ciudad destino: " + viaje.getCiudadDestino().getNombre());
                 if (viaje.getChofer() != null) {
                System.out.println("Chofer: " + viaje.getChofer().getNombre() + " " + viaje.getChofer().getApellido());
                } else {
                    System.out.println("Chofer: [NO ASIGNADO]");
                }

                if (viaje.getPasajeroLista() != null) {
                    System.out.println("Cantidad de pasajeros: " + viaje.getPasajeroLista().size());
                } else {
                    System.out.println("Cantidad de pasajeros: [NINGUNO]");
                }
                
                //System.out.println("Chofer: " + viaje.getChofer().getNombre() + " " + viaje.getChofer().getApellido());
                //System.out.println("Cantidad de pasajeros: " + viaje.getPasajeroLista().size());
                System.out.println("Precio por pasajero: $" + viaje.getPrecioPorPasajero());
                System.out.println("Estado: " + viaje.getEstadoDeViaje());
            }
        }

        if (!tieneViajesPendientes) {
            System.out.println("No hay viajes para este colectivo.");
        }

    }
}
