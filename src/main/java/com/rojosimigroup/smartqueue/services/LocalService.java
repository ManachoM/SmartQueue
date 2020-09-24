package com.rojosimigroup.smartqueue.services;


import com.rojosimigroup.smartqueue.models.*;
import com.rojosimigroup.smartqueue.repositories.AdministradorRepo;
import com.rojosimigroup.smartqueue.repositories.ClienteRepo;
import com.rojosimigroup.smartqueue.repositories.LocalRepo;
import com.sun.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/home")
public class LocalService {

    @Autowired
    private LocalRepo localRepo;

    @Autowired
    private ClienteRepo clienteRepo;

    @Autowired
    private AdministradorRepo administradorRepo;

    @RequestMapping(value = "/{localName}", method = RequestMethod.POST)
    public void anadirAFila(@RequestBody Cliente cliente, @PathVariable(value = "localName") String nombre){
        java.util.Optional<Local> oLocal = java.util.Optional.ofNullable(localRepo.findByNombreLocal(nombre));
        if(oLocal.isPresent()) {
            Local local = (Local) oLocal.get();
            Fila fila = local.getFilaAsoc();

            java.util.Optional<Cliente> oCliente = java.util.Optional.ofNullable(clienteRepo.findClienteByRut(cliente.getRut()));
            Reserva newReserva = new Reserva(System.currentTimeMillis(), ((Local) oLocal.get()).getId());
            if(oCliente.isEmpty()){
            cliente.ingresarReserva(newReserva);
            clienteRepo.save(cliente);
                }else {
                Cliente currentCliente = oCliente.get();

                currentCliente.ingresarReserva(newReserva);
                clienteRepo.save(currentCliente);
                  }
            fila.agregarCliente(cliente);
            local.setFilaAsoc(fila);
            localRepo.save(local);
        }else{
            System.out.println("No se pudo agregar a fila :c");
        }

    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Local> getAll(){
        return localRepo.findAll();
    }

    @RequestMapping(value = "/regLocal", method = RequestMethod.POST)
    public Local crearLocal(@RequestBody Local newLocal){
        System.out.println("Se registró local");
        return localRepo.save(newLocal);
    }

    @RequestMapping(value = "/regAdmin", method = RequestMethod.POST)
    public void crearAdmin(@RequestBody Administrador newAdministrador){
        administradorRepo.save(newAdministrador);
        System.out.println("Se creo admin");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public java.util.Optional<Local> login(@RequestBody Administrador administrador){
        String mail = administrador.getCorreo();
        String password = administrador.getPassword();
        String id = administrador.getIdAdmin();
        java.util.Optional<Administrador> oAdmin = administradorRepo.findById(id);
        if(oAdmin.isPresent()){
            if(oAdmin.get().getCorreo() == mail && oAdmin.get().getPassword() == password){
                System.out.println("funcionó el loggeo c:");
                return localRepo.findById(administradorRepo.findAdministradorByCorreo(oAdmin.get().getCorreo()).getLocal());
            }else System.out.println("no funcionó el loggeo :c");
        }else System.out.println("No existe este admin :s");

        return null;
    }

}
