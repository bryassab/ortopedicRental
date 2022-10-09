package com.ortopedic.ortopedicWork.repositories;

import com.ortopedic.ortopedicWork.models.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}
