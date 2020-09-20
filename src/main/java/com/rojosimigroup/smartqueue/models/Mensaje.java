package com.rojosimigroup.smartqueue.models;

public class Mensaje {
    private String texto;
    private Cliente cliente;

    //Constructor
    public Mensaje(Cliente cliente) {
        this.cliente = cliente;
    }

    //Getters
    public String getTexto() {
        return texto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    //Setters
    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
