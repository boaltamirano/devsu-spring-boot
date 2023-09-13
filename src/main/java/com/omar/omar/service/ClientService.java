package com.omar.omar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.omar.omar.Helpers.ClientUtil;
import com.omar.omar.model.Client;
import com.omar.omar.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(Client client) {

        return clientRepository.save(client);
    }


    public List<Client> getAllClients() {
        return (List<Client>) clientRepository.findAll();
    }


    public Client getClientByIdentification(String identification) {
        Client client = clientRepository.getClientByIdentification(identification);
        if (client != null) {
            return client;
        }
        return null;
    }


    public Client updateClient(String identification, Client client) {

        Client existingClient = clientRepository.getClientByIdentification(identification);
        if (existingClient != null) {
            ClientUtil.updateFieldIfNotNull(client.getName(), existingClient::setName);
            ClientUtil.updateFieldIfNotNull(client.getGenre(), existingClient::setGenre);
            ClientUtil.updateFieldIfNotNull(client.getAddress(), existingClient::setAddress);
            ClientUtil.updateFieldIfNotNull(client.getPhone(), existingClient::setPhone);            
            ClientUtil.updateFieldIfNotNull(client.getStatus(), existingClient::setStatus);

            ClientUtil.updateFieldIfNotNull(client.getPassword(), existingClient::setPassword);

            existingClient.setAge(client.getAge() != 0 ? client.getAge() : existingClient.getAge());
            return clientRepository.save(existingClient);
        }
        return null;
    }


    @Transactional
    public void deleteClient(String identification) {
        clientRepository.deleteByIdentification(identification);
    }

}
