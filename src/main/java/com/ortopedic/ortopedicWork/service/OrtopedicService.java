package com.ortopedic.ortopedicWork.service;

import com.ortopedic.ortopedicWork.models.Ortopedic;
import com.ortopedic.ortopedicWork.repositories.OrtopedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrtopedicService {

    @Autowired
    private OrtopedicRepository ortopedicRepository;

    public List<Ortopedic> getAllOrtopedic(){
        return ortopedicRepository.getAll();
    }

    public Optional<Ortopedic> getOrtopedic(int ortopedic_id){
        return ortopedicRepository.getOrtopedic(ortopedic_id);
    }

    public Ortopedic insertOrtopedic(Ortopedic ortopedic){
        return ortopedicRepository.save(ortopedic);
    }

    public Ortopedic updateOrtopedic(Ortopedic ortopedic){
        if (ortopedic.getId() != null){
            Optional<Ortopedic> ortopedicTem = ortopedicRepository.getOrtopedic(ortopedic.getId());
            if (!ortopedicTem.isEmpty()){
                if (ortopedic.getName() != null){
                    ortopedicTem.get().setName(ortopedic.getName());
                }
                if (ortopedic.getBrand() != null){
                    ortopedicTem.get().setBrand(ortopedic.getBrand());
                }
                if (ortopedic.getYear() != null){
                    ortopedicTem.get().setYear(ortopedic.getYear());
                }
                if (ortopedic.getDescription() != null){
                    ortopedicTem.get().setDescription(ortopedic.getDescription());
                }
                if (ortopedic.getCategory() != null){
                    ortopedicTem.get().setCategory(ortopedic.getCategory());
                }
                if (ortopedic.getMessages() != null){
                    ortopedicTem.get().setMessages(ortopedic.getMessages());
                }
                if (ortopedic.getReservations() != null){
                    ortopedicTem.get().setReservations(ortopedic.getReservations());
                }
                return ortopedicRepository.save(ortopedicTem.get());
            }else {
                return ortopedic;
            }
        }else {
            return ortopedic;
        }
    }

    public Boolean deleteOrtopedic(int ortopedic_id){
        Boolean success = ortopedicRepository.getOrtopedic(ortopedic_id).map(ortopedic -> {
            ortopedicRepository.delete(ortopedic);
            return true;
        }).orElse(false);
        return success;
    }
}
