package com.rojosimigroup.smartqueue.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document("local")
public class Local {
    @Id
    private String id;
    //Atributos construcción
    private String nombreLocal;
    private String direccion;
    private int cantidadPersonasAdmitidas;
    private int genteLocal;

    //Atributo que se crea en el mismo constructor.
    private Fila filaAsoc;

    //Constructor
    public Local(String nombreLocal, String direccion, int cantidadPersonasAdmitidas) {
        this.nombreLocal = nombreLocal;
        this.direccion = direccion;
        this.cantidadPersonasAdmitidas = cantidadPersonasAdmitidas;
        this.filaAsoc = new Fila(50);
        this.genteLocal = 0;
    }
    //Getters
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

    public int getGenteLocal() {
        return genteLocal;
    }

    //Setters
    public void setNombreLocal(String newNombre){
        this.nombreLocal = newNombre;
    }

    public void setDireccion(String newDir){
        this.direccion = newDir;
    }

    public void setCantidadPersonasAdmitidas(int newCantidad){
        this.cantidadPersonasAdmitidas = newCantidad;
    }

    public void setFilaAsoc(Fila newFila){ this.filaAsoc = newFila; }

    //Métodos
    public void aumentarGenteLocal() {
        this.genteLocal += 1;
    }

    public void decrementarGenteLocal() {
        this.genteLocal += -1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
