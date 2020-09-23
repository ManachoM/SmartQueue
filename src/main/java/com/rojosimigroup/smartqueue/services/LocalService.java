package com.rojosimigroup.smartqueue.services;


import com.mongodb.internal.connection.Time;
import com.rojosimigroup.smartqueue.models.*;
import com.rojosimigroup.smartqueue.repositories.AdministradorRepo;
import com.rojosimigroup.smartqueue.repositories.ClienteRepo;
import com.rojosimigroup.smartqueue.repositories.LocalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;

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
        Optional<Local> oLocal = Optional.ofNullable(localRepo.findByNombreLocal(nombre));
        if(oLocal.isPresent()) {
            Local local = oLocal.get();
            Fila fila = local.getFilaAsoc();

          //  Optional<Cliente> oCliente = Optional.ofNullable(clienteRepo.findClienteByRut(cliente.getRut()));
            Reserva newReserva = new Reserva(System.currentTimeMillis(), oLocal.get().getId());
            //if(oCliente.isEmpty()){
            cliente.ingresarReserva(newReserva);
            clienteRepo.save(cliente);
           // }else {
           //     Cliente currentCliente = oCliente.get();
           //     currentCliente.ingresarReserva(newReserva);
           //     clienteRepo.save(currentCliente);
           //     }
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
    public void crearLocal(@RequestBody Local newLocal){
        localRepo.save(newLocal);
        System.out.println("Se registró local");
    }

    @RequestMapping(value = "/regAdmin", method = RequestMethod.POST)
    public void crearAdmin(@RequestBody Administrador newAdministrador){
        administradorRepo.save(newAdministrador);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(@RequestBody Administrador administrador){
        String mail = administrador.getCorreo();
        String password = administrador.getPassword();
        String id = administrador.getIdAdmin();
        Optional<Administrador> oAdmin = administradorRepo.findById(id);
        if(oAdmin.isPresent()){
            if(oAdmin.get().getCorreo() == mail && oAdmin.get().getPassword() == password){
                System.out.println("funcionó el loggeo c:");
            }else System.out.println("no funcionó el loggeo :c");
        }else System.out.println("No existe este admin :s");
    }

}
