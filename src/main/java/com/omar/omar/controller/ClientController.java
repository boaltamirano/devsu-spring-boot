package com.omar.omar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.omar.omar.Helpers.CustomUtils;
import com.omar.omar.model.Client;
import com.omar.omar.model.dto.ClientDTO;
import com.omar.omar.service.ClientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping()
    public ResponseEntity<?> createClient(@Valid @RequestBody Client client, BindingResult result) {

        return CustomUtils.createEntityResponse(client, () -> clientService.createClient(client), result);
    }

    @GetMapping()
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{identification}")
    public ResponseEntity<ClientDTO> getClientByIdentification(@PathVariable String identification) {
        ClientDTO client = clientService.getClientByIdentification(identification);
        if (client != null) {
            return ResponseEntity.ok(client);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{identification}")
    public ResponseEntity<Client> updateCliente(@PathVariable String identification,
            @Valid @RequestBody Client client) {
        Client updatedClient = clientService.updateClient(identification, client);
        if (updatedClient != null) {
            return ResponseEntity.ok(updatedClient);
        }
        return ResponseEntity.notFound().build();
    }

}
