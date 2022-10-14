package com.ortopedic.ortopedicWork.controllers;

import com.ortopedic.ortopedicWork.models.Ortopedic;
import com.ortopedic.ortopedicWork.service.OrtopedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Ortopedic")
public class OrtopedicController {

    @Autowired
    private OrtopedicService ortopedicService;

    @GetMapping("/all")
    public List<Ortopedic> getAllOrtopedics(){
        return ortopedicService.getAllOrtopedic();
    }

    @GetMapping("/{id}")
    public Optional<Ortopedic> getOrtopedic(@PathVariable("id") int ortopedic_id){
        return ortopedicService.getOrtopedic(ortopedic_id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Ortopedic insertOrtopedic(@RequestBody Ortopedic ortopedic){
        return  ortopedicService.insertOrtopedic(ortopedic);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Ortopedic updateOrtopedic(@RequestBody Ortopedic ortopedic){
        return ortopedicService.updateOrtopedic(ortopedic);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteOrtopedic(@PathVariable("id") int ortopedic_id){
        return ortopedicService.deleteOrtopedic(ortopedic_id);
    }

}
