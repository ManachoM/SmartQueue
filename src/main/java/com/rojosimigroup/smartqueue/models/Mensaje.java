package com.rojosimigroup.smartqueue.models;

public class Mensaje {
    private String texto;
    private Cliente cliente;

    public Mensaje(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTexto() {
        return texto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
