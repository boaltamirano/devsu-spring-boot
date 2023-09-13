package com.omar.omar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omar.omar.Helpers.ClientUtil;
import com.omar.omar.model.Client;
import com.omar.omar.repository.ClientRepository;
import com.omar.omar.service.IServices.IClientService;

@Service
public class ClientService implements IClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client createClient(Client client) {

        Client updatedClient = ClientUtil.initializeClientData(client);

        return clientRepository.save(updatedClient);
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

    @Override
    public Client getClientById(Long clientId) {
        throw new UnsupportedOperationException("Unimplemented method 'getClientById'");
    }

    
}
