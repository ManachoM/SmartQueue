package com.rojosimigroup.smartqueue.repositories;


import com.rojosimigroup.smartqueue.models.Administrador;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepo extends MongoRepository<Administrador, String> {
    Administrador findAdministradorByCorreo(String correo);

}
