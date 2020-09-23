package com.rojosimigroup.smartqueue.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("usuario")
public class Usuario {

    @Id
    protected String id;
    //Atributos constructores
    private String nombre;
    private String apellido;
    private String rut;
    private String telefono;

    //Constructor
    public Usuario(String nombre, String apellido, String rut, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.telefono = telefono;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getRut() {
        return rut;
    }

    public String getTelefono() {
        return telefono;
    }



    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIdAdmin() {
        return id;
    }

    public void setIdAdmin(String idAdmin) {
        this.id = idAdmin;
    }
}
