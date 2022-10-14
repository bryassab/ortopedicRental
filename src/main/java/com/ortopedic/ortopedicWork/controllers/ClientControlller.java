package com.ortopedic.ortopedicWork.controllers;

import com.ortopedic.ortopedicWork.models.Client;
import com.ortopedic.ortopedicWork.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Client")
public class ClientControlller {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAllClients(){
        return clientService.getAllClient();
    }

    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int client_id){
        return clientService.getClient(client_id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client insertClient(@RequestBody Client client){
        return  clientService.inserClient(client);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client updateClient(@RequestBody Client client){
        return clientService.updateClient(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteClient(@PathVariable("id") int client_id){
        return clientService.deleteClient(client_id);
    }
}
