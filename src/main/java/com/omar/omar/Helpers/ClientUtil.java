package com.omar.omar.Helpers;

import java.util.function.Consumer;

import com.omar.omar.model.Client;

public class ClientUtil {

    public static Client initializeClientData(Client client) {

        client.setIdentification(client.getIdentification());
        client.setName(client.getName());
        client.setGenre(client.getGenre());
        client.setAge(client.getAge());
        client.setAddress(client.getAddress());
        client.setPhone(client.getPhone());
        client.setPassword(client.getPassword());
        client.setStatus(client.getStatus());

        return client;
    }

    public static <T> void updateFieldIfNotNull(T newValue, Consumer<T> updater) {
        if (newValue != null) {
            updater.accept(newValue);
        }
    }
}
