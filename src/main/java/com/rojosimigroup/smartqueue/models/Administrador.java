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
    //Getters
    public String getCorreo() {
        return correo;
    }

    public Local getLocal() {
        return local;
    }

    //Setters
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    //Métodos
    /*
    * Método que obtiene la activacion de la fila, es decir, si está activada o no.
    * */
    public boolean getActivacion(){
        return local.getFilaAsoc().getActivacion();
    }

    /*
    * Método que activa una fila si esta está desactivada.
    * */
    public void inicializarFila(){
        //Caso fila activada
        if(getActivacion()) {
            System.out.println("La fila ya está activada");
            return;
        }
        //Caso fila desactivada: Se activa.
        else{
            this.getLocal().getFilaAsoc().setActivacion();
        }
    }

    /*
    * Método que cambia el nombre del local
    * */
    private void cambiarNombreLocal(String nuevoNombre){
        this.getLocal().setNombreLocal(nuevoNombre);
    }

    /*
    *
    * */
}
