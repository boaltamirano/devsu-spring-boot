package com.omar.omar.controller;

import static org.mockito.Mockito.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.omar.omar.Utils.TestUtil;
import com.omar.omar.model.Client;
import com.omar.omar.model.dto.ClientDTO;
import com.omar.omar.service.ClientService;

public class ClientControllerTest {
    private ClientController clientController;
    private ClientService clientService;

    @BeforeEach
    public void setUp() {
        clientService = mock(ClientService.class);
        clientController = new ClientController(clientService);
    }

    @Test
    public void testCreateClient() {
        Client client = new Client();
        ClientDTO clientDTO = new ClientDTO();
        BindingResult result = mock(BindingResult.class);

        when(clientService.createClient(client)).thenReturn(clientDTO);

        ResponseEntity<?> responseEntity = clientController.createClient(client, result);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

    @Test
    public void testGetAllClients() {
        List<Client> clients = TestUtil.createSampleClients();
        when(clientService.getAllClients()).thenReturn(clients);

        ResponseEntity<List<Client>> responseEntity = clientController.getAllClients();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(clients, responseEntity.getBody());
    }
}
