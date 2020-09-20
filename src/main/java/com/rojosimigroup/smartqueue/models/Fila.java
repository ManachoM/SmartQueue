package com.rojosimigroup.smartqueue.models;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;

public class Fila {
    @Id
    private int id;
    //Atributos de construccion
    private int cantidadDePersonasMax;

    //Atributos
    private int cantidadDePersonas = 0;
    private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    private boolean activacion = false;


    //Constructor
    public Fila(int cantidadDePersonasMax) {
        this.cantidadDePersonasMax = cantidadDePersonasMax;
    }
    //Getters
    public int getCantidadDePersonas() {
        return cantidadDePersonas;
    }
    public int getCantidadDePersonasMax() {
        return cantidadDePersonasMax;
    }
    public boolean getActivacion() {
        return activacion;
    }

    //Setters
    public void setCantidadDePersonas(int cantidadDePersonas) {
        this.cantidadDePersonas = cantidadDePersonas;
    }
    public void setCantidadDePersonasMax(int cantidadDePersonasMax) {
        this.cantidadDePersonasMax = cantidadDePersonasMax;
    }


}
