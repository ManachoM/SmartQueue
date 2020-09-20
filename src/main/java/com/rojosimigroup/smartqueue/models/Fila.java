package com.rojosimigroup.smartqueue.models;
import org.springframework.data.annotation.Id;

public class Fila {
    @Id
    private int id;

    private int cantidadDePersonas = 0;
    private int cantidadDePersonasMax;

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

    //Setters
    public void setCantidadDePersonas(int cantidadDePersonas) {
        this.cantidadDePersonas = cantidadDePersonas;
    }
    public void setCantidadDePersonasMax(int cantidadDePersonasMax) {
        this.cantidadDePersonasMax = cantidadDePersonasMax;
    }
}
