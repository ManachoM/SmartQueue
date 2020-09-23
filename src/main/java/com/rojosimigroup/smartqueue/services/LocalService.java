package com.rojosimigroup.smartqueue.services;


import com.mongodb.internal.connection.Time;
import com.rojosimigroup.smartqueue.models.*;
import com.rojosimigroup.smartqueue.repositories.AdministradorRepo;
import com.rojosimigroup.smartqueue.repositories.ClienteRepo;
import com.rojosimigroup.smartqueue.repositories.LocalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            fila.agregarCliente(cliente);
            local.setFilaAsoc(fila);
            localRepo.save(local);

            Optional<Cliente> oCliente = clienteRepo.findById(cliente.getIdCliente());
            Reserva newReserva = new Reserva(System.currentTimeMillis(), oLocal.get());
            if(oCliente.isEmpty()){
                cliente.ingresarReserva(newReserva);
                clienteRepo.save(cliente);
            }else {
                Cliente currentCliente = oCliente.get();
                currentCliente.ingresarReserva(newReserva);
                clienteRepo.save(currentCliente);
                }

        }else{
            System.out.println("No se pudo agregar a fila :c");
        }

    }

    @RequestMapping(value = "/regLocal", method = RequestMethod.POST)
    public void crearLocal(@RequestBody Local newLocal){
        localRepo.save(newLocal);
    }

    @RequestMapping(value = "/regAdmin", method = RequestMethod.POST)
    public void crearAdmin(@RequestBody Administrador newAdministrador){
        administradorRepo.save(newAdministrador);
    }

}
