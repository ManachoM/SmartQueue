package com.rojosimigroup.smartqueue.models;

public class Administrador extends Usuario{
    //Atributos construccion
    private String correo;
    private Local local;

    public Administrador(String nombre, String apellido, String rut, String telefono, boolean discapacidad, String correo, Local local) {
        super(nombre, apellido, rut, telefono);
        this.correo = correo;
        this.local = local;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
