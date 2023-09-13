package com.omar.omar.Helpers;

import java.util.stream.Stream;

import com.omar.omar.model.Client;

public class ClientUtil {
    
    public static Client initializeClientData(Client client) {
        return Stream.of(client)
                .map(c -> {
                    c.setIdentification(client.getIdentification());
                    c.setName(client.getName());
                    c.setGenre(client.getGenre());
                    c.setAge(client.getAge());
                    c.setAddress(client.getAddress());
                    c.setPhone(client.getPhone());
                    c.setPassword(client.getPassword());
                    c.setStatus(client.getStatus());
                    return c;
                })
                .findFirst()
                .orElse(client);
    }
       
}
