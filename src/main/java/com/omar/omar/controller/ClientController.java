package com.omar.omar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omar.omar.model.Client;
import com.omar.omar.service.IServices.IClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @PostMapping()
    public ResponseEntity<Client> createClient(@RequestBody Client client) {

        

        Client createClient = clientService.createClient(client);
        return ResponseEntity.ok(createClient);
    }

}
