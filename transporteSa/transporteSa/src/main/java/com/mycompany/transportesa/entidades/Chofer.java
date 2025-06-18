/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transportesa.entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class Chofer extends Persona {

    private String nroLicencia;
    private List<ChoferCategoria> categorias;
    private List<Viaje> viajeLista;

    public Chofer(long dni, String nombre,
            String apellido, String nroLicencia,
            List<ChoferCategoria> categorias, List<Viaje> viajeLista) {
        super(dni, nombre, apellido);
        this.nroLicencia = nroLicencia;
        this.categorias = categorias;
        this.viajeLista = viajeLista;
    }

    public String getNroLicencia() {
        return this.nroLicencia;
    }

    public void setNroLicencia(String nuevoNroLicencia) {
        this.nroLicencia = nuevoNroLicencia;
    }

    public List<ChoferCategoria> getCategorias() {
        return this.categorias;
    }

    public void setCategorias(List<ChoferCategoria> categorias) {
        this.categorias = categorias;
    }

    public List<Viaje> getViajeLista() {
        return viajeLista;
    }

    public void setViajeLista(List<Viaje> viajeLista) {
        this.viajeLista = viajeLista;
    }

    public void agregarCategoria(ChoferCategoria categoria) {
        categorias.add(categoria);
    }

    //El chofer tiene viajes ese dia???
    public boolean estaDisponible(String fecha, String horaSalida, String horaLlegada) {
           //Transformo todo los String a tipo LocalDateTime para tratar fecha y hora en su conjunto
           //formatter es el nombre del formateador mucha imaginacion no tengo
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            LocalDateTime nuevaSalida = LocalDateTime.parse(fecha + " " + horaSalida, formatter);
            LocalDateTime nuevaLlegada = LocalDateTime.parse(fecha + " " + horaLlegada, formatter);

            for (Viaje v : viajeLista) {
                LocalDateTime salidaExistente = LocalDateTime.parse(v.getFecha() + " " + v.getHorarioSalida(), formatter);
                LocalDateTime llegadaExistente = LocalDateTime.parse(v.getFecha() + " " + v.getHorarioLlegada(), formatter);

                if(nuevaSalida.isBefore(llegadaExistente.plusHours(8))) {
                    return false;
                } else {
                }
            }
            return true;
    }

}
