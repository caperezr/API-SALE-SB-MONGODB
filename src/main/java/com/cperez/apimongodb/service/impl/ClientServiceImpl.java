package com.cperez.apimongodb.service.impl;

import com.cperez.apimongodb.dto.ClientDTO;
import com.cperez.apimongodb.model.Client;
import com.cperez.apimongodb.repository.impl.ClienteRepositoryImpl;
import com.cperez.apimongodb.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClienteRepositoryImpl clienteRepository;
    @Override
    public List<Client> getClientsByName(String name) {
        return clienteRepository.getClientsByName(name);
    }

    @Override
    public Client getClientById(String id) {
        return clienteRepository.getClientById(id);
    }

    @Override
    public Client createdClient(ClientDTO clientDTO) {
        Client client = new Client(clientDTO);
        return clienteRepository.createdClient(client);
    }

    @Override
    public List<Client> getClientsAll() {
        return clienteRepository.getClients();
    }
}
