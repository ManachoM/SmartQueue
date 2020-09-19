package com.rojosimigroup.smartqueue.services;

import com.rojosimigroup.smartqueue.models.Usuario;
import com.rojosimigroup.smartqueue.repositories.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/usuario")
public class UsuarioService {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Usuario> getAll(){
        System.out.println("Probando los controller c:");
        return this.usuarioRepo.findAll();
    }

    @RequestMapping(value = "/{rut}", method = RequestMethod.GET)
    @ResponseBody
    public Usuario getByRut(@PathVariable(value = "rut") String rut){
        return this.usuarioRepo.findUserByRut(rut);
    }

    @RequestMapping(value = "/ingresar", method = RequestMethod.POST)
    public void create(@RequestBody Usuario usuario){
        usuarioRepo.save(usuario);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public Usuario edit(@RequestBody Usuario usuario){
        Usuario currentUser = this.usuarioRepo.findUserByRut(usuario.getRut());
        currentUser.setNombre(usuario.getNombre());
        currentUser.setApellido(usuario.getApellido());
        currentUser.setTelefono(usuario.getTelefono());
        currentUser.setDiscapacidad(usuario.isDiscapacidad());
        usuarioRepo.save(currentUser);
        return currentUser;
    }


}
