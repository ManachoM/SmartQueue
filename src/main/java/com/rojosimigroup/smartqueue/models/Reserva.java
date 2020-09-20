package com.rojosimigroup.smartqueue.models;

import com.mongodb.internal.connection.Time;

public class Reserva {
    private Time horaDePedido;

    //Constructor
    public Reserva(Time horaDePedido) {
        this.horaDePedido = horaDePedido;
    }
    //Getters
    public Time getHoraDePedido() {
        return horaDePedido;
    }
    //Setters
    public void setHoraDePedido(Time horaDePedido) {
        this.horaDePedido = horaDePedido;
    }
}
