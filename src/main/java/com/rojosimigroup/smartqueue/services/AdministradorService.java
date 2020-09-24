package com.rojosimigroup.smartqueue.services;

import com.rojosimigroup.smartqueue.models.*;
import com.rojosimigroup.smartqueue.repositories.AdministradorRepo;
import com.rojosimigroup.smartqueue.repositories.ClienteRepo;
import com.rojosimigroup.smartqueue.repositories.LocalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/admin")
public class AdministradorService {
    @Autowired
    AdministradorRepo administradorRepo;

    @Autowired
    LocalRepo localRepo;

    @Autowired
    ClienteRepo clienteRepo;

    @RequestMapping(value = "/getAdmin/{rut}", method = RequestMethod.GET)
    public Administrador getAdmin(@PathVariable(value = "rut") String rut){
        return administradorRepo.findAdministradorByRut(rut);
    }


    @RequestMapping(value = "/{rut}", method = RequestMethod.GET)
    public Optional<Local> getLocal(@PathVariable(value = "rut") String rut){
        return localRepo.findById(administradorRepo.findAdministradorByRut(rut).getLocal());
    }

    @RequestMapping(value = "/{rut}", method = RequestMethod.DELETE)
    public Local hacerPasar(@PathVariable(value = "rut") String rut){
        Administrador admin = administradorRepo.findAdministradorByRut(rut);
        Optional<Local> oLocal = localRepo.findById(admin.getLocal());
        if(oLocal.isPresent()){
            Local local = oLocal.get();
            Cliente cliente = local.getFilaAsoc().getListaClientes().remove(0);
            cliente.getReserva().remove(0);
            clienteRepo.save(cliente);
            localRepo.save(local);
            return local;
        }else{
            System.out.println("No se encontró local :c");
            return null;
        }
    }

}
