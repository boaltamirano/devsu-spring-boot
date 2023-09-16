package com.omar.omar.Utils;

import java.util.ArrayList;
import java.util.List;

import com.omar.omar.model.Client;

public class TestUtil {
    
    public static List<Client> createSampleClients() {
        List<Client> clients = new ArrayList<>();

        Client client1 = new Client();
        client1.setIdentification("client1");
        client1.setPassword("password1");
        client1.setStatus(true);

        Client client2 = new Client();
        client2.setIdentification("client2");
        client2.setPassword("password2");
        client2.setStatus(true);

        clients.add(client1);
        clients.add(client2);

        return clients;
    }
}
