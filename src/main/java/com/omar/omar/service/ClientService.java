package com.omar.omar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omar.omar.Helpers.CustomUtils;
import com.omar.omar.model.Client;
import com.omar.omar.model.dto.ClientDTO;
import com.omar.omar.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientDTO createClient(Client client) {
        Client clientResponse = clientRepository.save(client);
        return CustomUtils.clientReturn(clientResponse);
    }

    public List<Client> getAllClients() {
        return (List<Client>) clientRepository.findAll();
    }

    public ClientDTO getClientByIdentification(String identification) {
        Client client = clientRepository.getClientByIdentification(identification);
        if (client != null) {
            return CustomUtils.clientReturn(client);
        }
        return null;
    }

    public Client updateClient(String identification, Client client) {

        Client existingClient = clientRepository.getClientByIdentification(identification);
        if (existingClient != null) {
            CustomUtils.updateFieldIfNotNull(client.getName(), existingClient::setName);
            CustomUtils.updateFieldIfNotNull(client.getGenre(), existingClient::setGenre);
            CustomUtils.updateFieldIfNotNull(client.getAddress(), existingClient::setAddress);
            CustomUtils.updateFieldIfNotNull(client.getPhone(), existingClient::setPhone);

            CustomUtils.updateFieldIfNotNull(client.getPassword(), existingClient::setPassword);

            existingClient.setAge(client.getAge() != 0 ? client.getAge() : existingClient.getAge());
            existingClient.setStatus(
                    client.getStatus() && client.getStatus() != existingClient.getStatus() ? client.getStatus()
                            : existingClient.getStatus());

            return clientRepository.save(existingClient);
        }
        return existingClient;
    }

}
