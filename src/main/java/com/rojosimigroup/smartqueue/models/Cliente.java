package com.rojosimigroup.smartqueue.models;

import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;

//@Document("cliente");

public class Cliente extends Usuario{

    private int edad;
    private boolean discapacidad;
    private ArrayList<Reserva> reserva = new ArrayList<Reserva>();

    public Cliente(String nombre, String apellido, String rut, String telefono, int edad, boolean discapacidad) {
        super(nombre, apellido, rut, telefono);
        this.edad = edad;
        this.discapacidad = discapacidad;
    }

    public void reservaFila(){

    }

    public void consultarLugar(){

    }

    public int getEdad() {
        return edad;
    }

    public boolean isDiscapacidad() {
        return discapacidad;
    }

    public ArrayList<Reserva> getReserva() {
        return reserva;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setReserva(ArrayList<Reserva> reserva) {
        this.reserva = reserva;
    }

    public void setDiscapacidad(boolean discapacidad) {
        this.discapacidad = discapacidad;
    }
}
