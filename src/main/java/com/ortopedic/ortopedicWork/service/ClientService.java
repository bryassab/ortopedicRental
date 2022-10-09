package com.ortopedic.ortopedicWork.service;

import com.ortopedic.ortopedicWork.models.Client;
import com.ortopedic.ortopedicWork.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClient(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int client_id){
        return clientRepository.getClient(client_id);
    }

    public Client inserClient(Client client){
        if (client.getClient_id() != null){
            Optional<Client> clientTem = clientRepository.getClient(client.getClient_id());
            if (clientTem.isEmpty()){
                if (client.getClient_name() != null && client.getEmail() != null && client.getAge() != null && client.getPassword() != null){
                    return clientRepository.save(client);
                }else {
                    return client;
                }
            }else {
                return client;
            }
        }else {
            return client;
        }
    }

    public Client updateClient(Client client){
        if (client.getClient_id() != null){
            Optional<Client> clientTem = clientRepository.getClient(client.getClient_id());
            if (!clientTem.isEmpty()){
                if (client.getClient_name() != null){
                    clientTem.get().setClient_name(client.getClient_name());
                }
                if (client.getEmail() != null){
                    clientTem.get().setEmail(client.getEmail());
                }
                if (client.getAge() != null){
                    clientTem.get().setAge(client.getAge());
                }
                if (client.getPassword() != null){
                    clientTem.get().setPassword(client.getPassword());
                }
                return clientRepository.save(clientTem.get());
            }else {
                return client;
            }
        }else {
            return client;
        }
    }

    public Boolean deleteClient(int client_id){
        Boolean success = clientRepository.getClient(client_id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return success;

    }
}
