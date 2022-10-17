package com.ortopedic.ortopedicWork.repositories;

import com.ortopedic.ortopedicWork.models.Client;
import com.ortopedic.ortopedicWork.models.ReportClient;
import com.ortopedic.ortopedicWork.models.ReportStatus;
import com.ortopedic.ortopedicWork.models.Reservations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationsRepository {

    @Autowired
    private ReservationsCrudRepository reservationsCrudRepository;

    public List<Reservations> getAll(){
        return (List<Reservations>) reservationsCrudRepository.findAll();
    }

    public Optional<Reservations> getReservation(int reservation_id){
        return reservationsCrudRepository.findById(reservation_id);
    }

    public Reservations save(Reservations reservation){
        return reservationsCrudRepository.save(reservation);
    }

    public void delete(Reservations reservation){
        reservationsCrudRepository.delete(reservation);
    }

    public List<Reservations> getByStatus(String status){
        return reservationsCrudRepository.findByStatus(status);
    }

    public List<Reservations> getAllByDates(Date startDate, Date devolutionDate){
        return reservationsCrudRepository.findAllByStartDateAfterAndStartDateBefore(startDate,devolutionDate);
    }

    public List<ReportClient> getReservationClient(){
        List<ReportClient> clientReport = new ArrayList<>();
        List<Object[]> report = reservationsCrudRepository.reservationsClient();
        for(Object[] i : report){
            clientReport.add(new ReportClient((long) i[1], (Client) i[0]));
        }
        return clientReport;
    }

    public ReportStatus getReportStatus(){
        List<Reservations> Completed= reservationsCrudRepository.findByStatus("completed");
        List<Reservations> Cancelled= reservationsCrudRepository.findByStatus("cancelled");
        return new ReportStatus(Completed.size(),Cancelled.size());
    }
}
