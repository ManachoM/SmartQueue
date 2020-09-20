package com.rojosimigroup.smartqueue.models;

public class Reserva {
    private time horaDePedido;

    //Constructor
    public Reserva(time horaDePedido) {
        this.horaDePedido = horaDePedido;
    }
    //Getters
    public time getHoraDePedido() {
        return horaDePedido;
    }
    //Setters
    public void setHoraDePedido(time horaDePedido) {
        this.horaDePedido = horaDePedido;
    }
}
