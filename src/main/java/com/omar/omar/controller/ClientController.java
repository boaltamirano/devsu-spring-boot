package com.omar.omar.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping()
    public ResponseEntity<?> createClient(@Valid @RequestBody Client client, BindingResult result) {
        logger.info("Se creo un cliente correctamente");
        return CustomUtils.createEntityResponse(client, () -> clientService.createClient(client), result);
    }

    @GetMapping()
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        logger.info("Se ha consultado la lista de todos los clientes.");
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{identification}")
    public ResponseEntity<ClientDTO> getClientByIdentification(@PathVariable String identification) {
        ClientDTO client = clientService.getClientByIdentification(identification);
        if (client != null) {
            logger.info("Se ha consultado el cliente con identificación: {}", identification);
            return ResponseEntity.ok(client);
        }
        logger.info("No se ha encontrado el cliente con identificación: {}", identification);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{identification}")
    public ResponseEntity<Client> updateCliente(@PathVariable String identification,
            @Valid @RequestBody Client client) {
        Client updatedClient = clientService.updateClient(identification, client);
        if (updatedClient != null) {
            logger.info("Se ha actualizado el cliente con identificación: {}", identification);
            return ResponseEntity.ok(updatedClient);
        }
        logger.info("No se ha encontrado el cliente con identificación: {} para actualizar", identification);
        return ResponseEntity.notFound().build();
    }

}
