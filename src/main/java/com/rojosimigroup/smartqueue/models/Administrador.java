package com.rojosimigroup.smartqueue.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("admin")
public class Administrador extends Usuario{


    private String idAdmin;
    //Atributos construccion
    private String correo;
    private String localId;
    private String password;

    public Administrador(String nombre, String apellido, String rut, String telefono, String correo, String localId, String password) {
        super(nombre, apellido, rut, telefono);
        this.correo = correo;
        this.localId = localId;
        this.password = password;
    }

    //Getters
    public String getCorreo() {
        return correo;
    }

    public String getLocal() {
        return localId;
    }

    //Setters
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    //Métodos
    /*
    * Método que obtiene la activacion de la fila, es decir, si está activada o no.
    * */
  //  public boolean getActivacion(){
    //      return local.getFilaAsoc().getActivacion();
  //  }

    /*
    * Método que activa una fila si esta está desactivada.
    * */
  /* public void inicializarFila(){
        //Caso fila activada
        if(getActivacion()) {
            System.out.println("La fila ya está activada");
        }
        //Caso fila desactivada: Se activa.
        else{
            this.getLocal().getFilaAsoc().setActivacion();
        }*/


    /*
    * Método que cambia el nombre del local
    * */
   /* private void cambiarNombreLocal(String nuevoNombre){
        this.getLocal().setNombreLocal(nuevoNombre);
    }
    /*
    * Método que cambia la ubicación del local
    * */
   /* private void cambiarUbicacionLocal(String ubicacion){
        this.getLocal().setDireccion(ubicacion);
    }

    /*
    * Método que cambia los admitidos del local
    * */
    /*private void cambiarAdmitidos(int admitidos){
        this.getLocal().setCantidadPersonasAdmitidas(admitidos);
    }

    /*
    * Método que pasa el primer cliente en la fila a la lista de clientes en el local.
    * También, borra un cliente en el local y borra
    * */
    /*public void pasarCliente(){
        Cliente clienteEnAtencion = this.getLocal().getFilaAsoc().getListaClientes().get(0);
        this.getLocal().getFilaAsoc().getListaClientes().remove(0);
        this.getLocal().aumentarGenteLocal();
    }
    /*
    * Se decrementa en uno la cantidad de clientes que están en el local.
    * */
   /* public void borrarClienteLocal(){
        this.getLocal().decrementarGenteLocal();
    }
    /*
    * Pasa a primero a un cliente solo si tiene activa la casilla de discapacidad.
    * */
   /* public void pasarAPrimero(Cliente cliente){
        if(cliente.isDiscapacidad()) {
            int indexClienteDis = this.getLocal().getFilaAsoc().getListaClientes().indexOf(cliente);
            this.getLocal().getFilaAsoc().getListaClientes().remove(indexClienteDis);
            this.getLocal().getFilaAsoc().getListaClientes().add(0, cliente);
        }
        else{
            System.out.println("No esta en la fila");
        }
    }*/

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }
}
