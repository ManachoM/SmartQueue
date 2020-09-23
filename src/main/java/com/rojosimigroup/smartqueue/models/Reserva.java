package com.rojosimigroup.smartqueue.models;

import com.mongodb.internal.connection.Time;

public class Reserva {
    //Atributos construcción
    private long horaDePedido;
    private Local local;

    //Constructor
    public Reserva(long horaDePedido, Local local) {
        this.horaDePedido = horaDePedido;
        this.local = local;
    }
    //Getters
    public long getHoraDePedido() {
        return horaDePedido;
    }

    public Local getLocal() {
        return local;
    }


    //Setters
    public void setHoraDePedido(long horaDePedido) {
        this.horaDePedido = horaDePedido;
    }

    public void setLocal(Local newLocal) {this.local = newLocal;}
}
