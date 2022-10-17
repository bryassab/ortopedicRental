package com.ortopedic.ortopedicWork.service;

import com.ortopedic.ortopedicWork.models.ReportClient;
import com.ortopedic.ortopedicWork.models.ReportStatus;
import com.ortopedic.ortopedicWork.models.Reservations;
import com.ortopedic.ortopedicWork.repositories.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationsService {

    @Autowired
    private ReservationsRepository reservationsRepository;

    public List<Reservations> getAllReservations(){
        return reservationsRepository.getAll();
    }

    public Optional<Reservations> getReservation(int reservation_id){
        return reservationsRepository.getReservation(reservation_id);
    }

    public Reservations insertReservation(Reservations reservations){
        return reservationsRepository.save(reservations);
    }

    public Reservations updateReservation(Reservations reservations){
        if (reservations.getIdReservation() != null){
            Optional<Reservations> reservationTem = reservationsRepository.getReservation(reservations.getIdReservation());
            if (!reservationTem.isEmpty()){
                if (reservations.getStartDate() != null){
                    reservationTem.get().setStartDate(reservations.getStartDate());
                }
                if (reservations.getDevolutionDate() != null){
                    reservationTem.get().setDevolutionDate(reservations.getDevolutionDate());
                }
                if (reservations.getStatus() != null){
                    reservationTem.get().setStatus(reservations.getStatus());
                }
                if (reservations.getClient() != null){
                    reservationTem.get().setClient(reservations.getClient());
                }
                if (reservations.getOrtopedic() != null){
                    reservationTem.get().setOrtopedic(reservations.getOrtopedic());
                }
                if (reservations.getScore() != null){
                    reservationTem.get().setScore(reservations.getScore());
                }
                return  reservationsRepository.save(reservationTem.get());
            }else {
                return reservations;
            }
        }else {
            return reservations;
        }
    }

    public Boolean deleteReservation(int reservation_id){
        Boolean success = reservationsRepository.getReservation(reservation_id).map(reservations -> {
            reservationsRepository.delete(reservations);
            return true;
        }).orElse(false);
        return success;
    }

    public List<Reservations> getByStatus(String status){
        return reservationsRepository.getByStatus(status);
    }

    public List<ReportClient> getReservationClient(){
        return reservationsRepository.getReservationClient();
    }

    public ReportStatus getReportStatus(){
        return reservationsRepository.getReportStatus();
    }

    public List<Reservations> allByDates(String dateStart, String dateEnd){
        SimpleDateFormat convertDate = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = new Date();
        Date devolutionDate = new Date();
        try{
            startDate = convertDate.parse(dateStart);
            devolutionDate = convertDate.parse(dateEnd);
        }catch (ParseException e){
            e.printStackTrace();
        }
        if (startDate.before(devolutionDate)){
            return reservationsRepository.getAllByDates(startDate,devolutionDate);
        }else {
            return new ArrayList<>();
        }
    }
}
