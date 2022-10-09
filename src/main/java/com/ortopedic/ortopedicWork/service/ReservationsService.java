package com.ortopedic.ortopedicWork.service;

import com.ortopedic.ortopedicWork.models.Reservations;
import com.ortopedic.ortopedicWork.repositories.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        if (reservations.getReservation_id() != null){
            Optional<Reservations> reservationTem = reservationsRepository.getReservation(reservations.getReservation_id());
            if(reservationTem.isEmpty()){
                if (reservations.getStart_date() != null && reservations.getDevolution_date() != null && reservations.getStatus() != null){
                    return reservationsRepository.save(reservations);
                }else {
                    return reservations;
                }
            }else {
                return reservations;
            }
        }else {
            return reservations;
        }
    }

    public Reservations updateReservation(Reservations reservations){
        if (reservations.getReservation_id() != null){
            Optional<Reservations> reservationTem = reservationsRepository.getReservation(reservations.getReservation_id());
            if (!reservationTem.isEmpty()){
                if (reservations.getStart_date() != null){
                    reservationTem.get().setStart_date(reservations.getStart_date());
                }
                if (reservations.getDevolution_date() != null){
                    reservationTem.get().setDevolution_date(reservations.getDevolution_date());
                }
                if (reservations.getStatus() != null){
                    reservationTem.get().setStatus(reservations.getStatus());
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
}
