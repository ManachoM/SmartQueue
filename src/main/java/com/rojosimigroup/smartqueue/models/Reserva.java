package com.rojosimigroup.smartqueue.models;

import com.mongodb.internal.connection.Time;

public class Reserva {
    private Time horaDePedido;
    private Local local;

    //Constructor
    public Reserva(Time horaDePedido,Local local) {
        this.horaDePedido = horaDePedido;
        this.local = local;
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
