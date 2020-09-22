package com.rojosimigroup.smartqueue.repositories;

import com.rojosimigroup.smartqueue.models.Cliente;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepo extends MongoRepository<Cliente, String> {
    public Cliente findClienteByRut(String rut);
    public List<Cliente> findClientesByDiscapacidad(Boolean disc);

}
