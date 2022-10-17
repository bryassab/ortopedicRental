package com.ortopedic.ortopedicWork.repositories;

import com.ortopedic.ortopedicWork.models.Reservations;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;


public interface ReservationsCrudRepository extends CrudRepository<Reservations,Integer> {

    @Query("SELECT client, COUNT(*) FROM Reservations group by client order by COUNT(client) DESC")
    public List<Object[]> reservationsClient();

    public List<Reservations> findAllByStartDateAfterAndStartDateBefore(Date startDate, Date devolutionDate);

    public List<Reservations> findByStatus(String status);


}
