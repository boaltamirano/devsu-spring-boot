package com.omar.omar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omar.omar.model.Client;
import com.omar.omar.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long clientId, Client client) {

        if (clientRepository.existsById(clientId)) {
            return clientRepository.save(client);
        }
        return null;
    }

    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    public Client getClient(Long clientId) {
        return clientRepository.findById(clientId).orElse(null);
    }
    
}
