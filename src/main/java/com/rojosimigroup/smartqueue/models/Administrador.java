package com.rojosimigroup.smartqueue.models;

public class Administrador extends Usuario{
    private String correo;

    public Administrador(String nombre, String apellido, String rut, String telefono, boolean discapacidad, String correo) {
        super(nombre, apellido, rut, telefono, discapacidad);
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
