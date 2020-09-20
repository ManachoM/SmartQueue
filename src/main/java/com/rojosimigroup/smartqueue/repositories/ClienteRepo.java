package com.rojosimigroup.smartqueue.repositories;

import com.rojosimigroup.smartqueue.models.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepo extends MongoRepository<Cliente, String> {
    Cliente findClienteByRut(String rut);
    List<Cliente> findClientesByDiscapacidad(Boolean disc);

}
