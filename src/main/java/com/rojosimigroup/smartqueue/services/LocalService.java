package com.rojosimigroup.smartqueue.services;


import com.rojosimigroup.smartqueue.models.Cliente;
import com.rojosimigroup.smartqueue.models.Fila;
import com.rojosimigroup.smartqueue.models.Local;
import com.rojosimigroup.smartqueue.repositories.ClienteRepo;
import com.rojosimigroup.smartqueue.repositories.LocalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    @RequestMapping(value = "/{localId}", method = RequestMethod.POST)
    public void anadirAFila(@RequestBody Cliente cliente, @PathVariable(value = "localId") String id){
        Optional<Local> oLocal = localRepo.findById(id);
        if(oLocal.isPresent()) {
            Local local = oLocal.get();
            Fila fila = local.getFilaAsoc();
            fila.agregarCliente(cliente);
            localRepo.save(local);
        }else{
            System.out.println("No se pudo agregar a fila :c");
        }

        //Optional<Cliente> oCliente = clienteRepo.findById(cliente.getId());
        //if(oCliente.isEmpty()){
        //    clienteRepo.save(cliente);
        //}

    }

    @RequestMapping(value = "/regLocal", method = RequestMethod.POST)
    public void crearLocal(@RequestBody Local newLocal){
        localRepo.save(newLocal);
    }

}
