package com.rojosimigroup.smartqueue.repositories;

import com.rojosimigroup.smartqueue.models.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface UsuarioRepo extends MongoRepository<Usuario, String>{

    Usuario findUserByRut(String rut);
    List<Usuario> findByDiscapacidad(Boolean disc);

}
