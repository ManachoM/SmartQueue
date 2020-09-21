package com.rojosimigroup.smartqueue.repositories;

import com.rojosimigroup.smartqueue.models.Local;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepo extends MongoRepository<Local, String> {

    Local findByNombreLocal(String nombreLocal);
    Local findByDireccion(String direccion);
    

}
