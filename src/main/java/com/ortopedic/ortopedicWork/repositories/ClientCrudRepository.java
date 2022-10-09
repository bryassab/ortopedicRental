package com.ortopedic.ortopedicWork.repositories;

import com.ortopedic.ortopedicWork.models.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<Client,Integer> {
}
