package com.rojosimigroup.smartqueue.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;



public class Cliente extends Usuario{

    //private String idCliente;
    //Atributos construcción
    private int edad;
    private boolean discapacidad;
    private ArrayList<Reserva> reserva = new ArrayList<Reserva>();

    //Constructor
    public Cliente(String nombre, String apellido, String rut, String telefono, int edad, boolean discapacidad) {
        super(nombre, apellido, rut, telefono);
        this.edad = edad;
        this.discapacidad = discapacidad;
    }

    //Getters

    public int getEdad() {
        return edad;
    }

    public boolean isDiscapacidad() {
        return discapacidad;
    }

    public ArrayList<Reserva> getReserva() {
        return reserva;
    }

    //Setters
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setReserva(ArrayList<Reserva> reserva) {
        this.reserva = reserva;
    }

    public void setDiscapacidad(boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    //Métodos
    public void reservarFila(int indexReserva){
        this.getReserva().get(indexReserva).getLocal().getFilaAsoc().agregarCliente(this);
    }

    public void ingresarReserva(Reserva reserva){
        this.reserva.add(reserva);
    }

    public int consultarLugar(int indexReserva){
        return this.getReserva().get(indexReserva).getLocal().getFilaAsoc().getListaClientes().indexOf(this);
    }

    public String getId() {
        return id;
    }

    public void setIdCliente(String idCliente) {
        this.id = idCliente;
    }
}
