package com.cperez.apimongodb.controller;

import com.cperez.apimongodb.dto.ClientDTO;
import com.cperez.apimongodb.model.Client;
import com.cperez.apimongodb.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> createdClient(@RequestBody ClientDTO clientDTO) {
        try {
            Client client = clientService.createdClient(clientDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(client);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Client>> finfAll() {
        try {
            List<Client> clients = clientService.getClientsAll();
            return ResponseEntity.status(HttpStatus.OK).body(clients);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/byname/{name}")
    public ResponseEntity<List<Client>> getClientsByName(@PathVariable String name){
        try {
            List<Client> clients = clientService.getClientsByName(name);
            return ResponseEntity.status(HttpStatus.OK).body(clients);
        }
        catch(Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable String id){
        try {
            Client client = clientService.getClientById(id);
            return ResponseEntity.status(HttpStatus.OK).body(client);
        }
        catch(Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }


}
