package com.cperez.apimongodb.repository;

import com.cperez.apimongodb.model.Client;

import java.util.List;

public interface ClientRepository {
    List<Client> getClients();
    List<Client> getClientsByName(String name);

    Client getClientById(String id);
    Client createdClient(Client client);

}
