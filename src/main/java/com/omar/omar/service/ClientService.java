package com.omar.omar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omar.omar.Helpers.ClientUtil;
import com.omar.omar.model.Client;
import com.omar.omar.repository.ClientRepository;
import com.omar.omar.service.IServices.IClientService;

@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client createClient(Client client) {

        Client updatedClient = ClientUtil.initializeClientData(client);

        return clientRepository.save(updatedClient);
    }

    @Override
	public List<Client> getAllClients() {
		return (List<Client> )clientRepository.findAll();
	}

    public Client updateClient(String identification, Client client) {

        // if (clientRepository.existsById(identification)) {
        // return clientRepository.save(client);
        // }
        return null;
    }

    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    @Override
    public Client getClientById(Long clientId) {
        throw new UnsupportedOperationException("Unimplemented method 'getClientById'");
    }

}
