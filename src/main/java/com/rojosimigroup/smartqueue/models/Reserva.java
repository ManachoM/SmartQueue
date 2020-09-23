package com.rojosimigroup.smartqueue.models;

import com.mongodb.internal.connection.Time;

public class Reserva {
    //Atributos construcción
    private long horaDePedido;
    private String localId;

    //Constructor
    public Reserva(long horaDePedido, String local) {
        this.horaDePedido = horaDePedido;
        this.localId = local;
    }
    //Getters
    public long getHoraDePedido() {
        return horaDePedido;
    }

    public String getLocal() {
        return localId;
    }


    //Setters
    public void setHoraDePedido(long horaDePedido) {
        this.horaDePedido = horaDePedido;
    }

    public void setLocal(String newLocal) {this.localId = newLocal;}
}
