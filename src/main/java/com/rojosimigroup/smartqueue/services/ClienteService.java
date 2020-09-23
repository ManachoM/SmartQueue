package com.rojosimigroup.smartqueue.services;


import com.rojosimigroup.smartqueue.models.Cliente;
import com.rojosimigroup.smartqueue.models.Fila;
import com.rojosimigroup.smartqueue.models.Local;
import com.rojosimigroup.smartqueue.repositories.ClienteRepo;
import com.rojosimigroup.smartqueue.repositories.LocalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    String idLocal = cliente.getReserva().get(0).getLocal().getId();
    Optional<Local> oLocal = localRepo.findById(idLocal);
    if(oLocal.isPresent()){
        Local local = oLocal.get();
        Fila filaLocal = local.getFilaAsoc();
        return filaLocal.calcularTiempoEstimado(cliente);
    }else{
        System.out.println("No se encontró local :c");
        return -1;
    }
    }
}
