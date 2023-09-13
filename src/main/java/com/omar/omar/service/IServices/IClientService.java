package com.omar.omar.service.IServices;

import java.util.List;

import com.omar.omar.model.Client;

public interface IClientService {
    public Client createClient(Client client);
	public Client getClientById(Long clientId);
	public void deleteClient(Long clientId);
	public List<Client> getAllClients();
}
