package com.cperez.apimongodb.service;

import com.cperez.apimongodb.dto.ClientDTO;
import com.cperez.apimongodb.model.Client;

import java.util.List;

public interface ClientService {
    public List<Client> getClientsByName(String name);

    Client getClientById(String id);

    public Client createdClient(ClientDTO clientDTO);

    public List<Client> getClientsAll();
}
