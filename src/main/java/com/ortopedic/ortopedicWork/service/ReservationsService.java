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
}
