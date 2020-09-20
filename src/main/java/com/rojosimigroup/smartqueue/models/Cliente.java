package com.rojosimigroup.smartqueue.models;

//import org.springframework.data.mongodb.core.mapping.Document;

//@Document("cliente");

public class Cliente extends Usuario{

    private int edad;
    private boolean discapacidad;
    private Reserva reserva;



    public Cliente(String nombre, String apellido, String rut, String telefono, int edad, boolean discapacidad, Reserva reserva) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.telefono = telefono;
        this.edad = edad;
        this.discapacidad = discapacidad;
        this.reserva = reserva;

    }

    public int getEdad() {
        return edad;
    }

    public boolean isDiscapacidad() {
        return discapacidad;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public void setDiscapacidad(boolean discapacidad) {
        this.discapacidad = discapacidad;
    }
}
