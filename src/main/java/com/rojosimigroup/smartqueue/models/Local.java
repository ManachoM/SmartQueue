package com.rojosimigroup.smartqueue.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document("local")
public class Local {
    @Id
    private String id;
    private String nombreLocal;
    private String direccion;
    private int cantidadPersonasAdmitidas;
    private ArrayList<Cliente> genteLocal;

    private Fila filaAsoc;

    public Local(String nombreLocal, String direccion, int cantidadPersonasAdmitidas) {
        this.nombreLocal = nombreLocal;
        this.direccion = direccion;
        this.cantidadPersonasAdmitidas = cantidadPersonasAdmitidas;
        this.filaAsoc = new Fila(50);
        this.genteLocal = new ArrayList<Cliente>();
    }

    public String getNombreLocal() {
        return nombreLocal;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getCantidadPersonasAdmitidas() {
        return cantidadPersonasAdmitidas;
    }

    public Fila getFilaAsoc() {
        return filaAsoc;
    }

    public ArrayList<Cliente> getGenteLocal() {
        return genteLocal;
    }

    public void setNombreLocal(String newNombre){
        this.nombreLocal = newNombre;
    }

    public void setDireccion(String newDir){
        this.direccion = newDir;
    }

    public void setCantidadPersonasAdmitidas(int newCantidad){
        this.cantidadPersonasAdmitidas = newCantidad;
    }
}
