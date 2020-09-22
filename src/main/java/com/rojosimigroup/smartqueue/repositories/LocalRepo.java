package com.rojosimigroup.smartqueue.repositories;

import com.rojosimigroup.smartqueue.models.Local;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface LocalRepo extends MongoRepository<Local, String> {

    public Local findByNombreLocal(String nombreLocal);
    public Local findByDireccion(String direccion);
    

}
