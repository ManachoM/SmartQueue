package com.rojosimigroup.smartqueue.services;


import com.rojosimigroup.smartqueue.models.Cliente;
import com.rojosimigroup.smartqueue.models.Fila;
import com.rojosimigroup.smartqueue.models.Local;
import com.rojosimigroup.smartqueue.repositories.ClienteRepo;
import com.rojosimigroup.smartqueue.repositories.LocalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/lugarFila")
public class ClienteService {

    @Autowired
    ClienteRepo clienteRepo;

    @Autowired
    LocalRepo localRepo;

    @RequestMapping(value = "/{rut}", method = RequestMethod.GET)
    public int encontrarLugarFila(@PathVariable(value = "rut") String rut){
    Cliente cliente = clienteRepo.findClienteByRut(rut);
    String idLocal = cliente.getReserva().get(0).getLocal();
    Optional<Local> oLocal = localRepo.findById(idLocal);
    if(oLocal.isPresent()){
        Local local = oLocal.get();
        Fila filaLocal = local.getFilaAsoc();
        System.out.println(cliente.getId());
        int i = filaLocal.indexOfCliente(cliente);
        return i+1;
    }else{
        System.out.println("No se encontró local :c");
        return -1;
    }
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Cliente> getAll(){
        return clienteRepo.findAll();

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void create(@RequestBody Cliente cliente){
        clienteRepo.save(cliente);
        System.out.println("Se creo cliente");
    }
}
