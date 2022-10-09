package com.ortopedic.ortopedicWork.repositories;

import com.ortopedic.ortopedicWork.models.Reservations;
import org.springframework.data.repository.CrudRepository;

public interface ReservationsCrudRepository extends CrudRepository<Reservations,Integer> {
}
