package com.rojosimigroup.smartqueue.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("local")
public class Local {
    @Id
    private String id;
    private String nombreLocal;
    private String direccion;
    private int cantidadPersonasAdmitidas;
    private Fila filaAsoc;

    public Local(String nombreLocal, String direccion, int cantidadPersonasAdmitidas) {
        this.nombreLocal = nombreLocal;
        this.direccion = direccion;
        this.cantidadPersonasAdmitidas = cantidadPersonasAdmitidas;
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
