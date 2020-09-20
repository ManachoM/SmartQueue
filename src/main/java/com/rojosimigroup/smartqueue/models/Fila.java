package com.rojosimigroup.smartqueue.models;

import com.mongodb.internal.connection.Time;
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
    private int tiempoEstimado;


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

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public boolean isActivacion() {
        return activacion;
    }

    public void setActivacion() {
        if(this.activacion){
            this.activacion = false;
        }
        else{
            this.activacion = true;
        }
    }

    //Setters
    public void setCantidadDePersonas(int cantidadDePersonas) {
        this.cantidadDePersonas = cantidadDePersonas;
    }
    public void setCantidadDePersonasMax(int cantidadDePersonasMax) {
        this.cantidadDePersonasMax = cantidadDePersonasMax;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    //Métodos
    /*
    * Agrega un cliente específico a la fila.
    * */
    public void agregarCliente(Cliente cliente){
        this.listaClientes.add(cliente);
    }

    /*
    * Calcula el tiempo estimado en base al número de cliente en la fila.
    * */
    public int calcularTiempoEstimado(int indexCliente){
        int resultado = (indexCliente+1) * this.tiempoEstimado;
        return resultado; //en minutos
    }
    /*
     * Calcula el tiempo estimado en base al cliente específico en la fila.
     * */
    public int calcularTiempoEstimado(Cliente cliente){
        int resultado = (this.listaClientes.indexOf(cliente) + 1) * this.tiempoEstimado;
        return resultado; //en minutos
    }

}
