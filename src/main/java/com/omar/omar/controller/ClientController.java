package com.omar.omar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omar.omar.model.Client;
import com.omar.omar.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping()
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client createClient = clientService.createClient(client);
        return ResponseEntity.ok(createClient);
    }

    @GetMapping()
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{identification}")
    public ResponseEntity<Client> getClientByIdentification(@PathVariable String identification) {
        Client client = clientService.getClientByIdentification(identification);
        if (client != null) {
            return ResponseEntity.ok(client);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{identification}")
    public ResponseEntity<Client> updateCliente(@PathVariable String identification, @RequestBody Client client) {
        Client updatedClient = clientService.updateClient(identification, client);
        if (updatedClient != null) {
            return ResponseEntity.ok(updatedClient);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{identification}")
    public ResponseEntity<Void> deleteClient(@PathVariable String identification) {
        clientService.deleteClient(identification);
        return ResponseEntity.noContent().build();
    }
}
