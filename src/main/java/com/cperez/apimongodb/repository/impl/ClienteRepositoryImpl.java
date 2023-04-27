package com.cperez.apimongodb.repository.impl;

import com.cperez.apimongodb.model.Client;
import com.cperez.apimongodb.repository.ClientRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepositoryImpl implements ClientRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Client> getClients() {
        return mongoTemplate.findAll(Client.class);
    }

    @Override
    public List<Client> getClientsByName(String name) {
        Query query = new Query();
        Criteria criteria = Criteria.where("name").is(name);
        query.addCriteria(criteria);
        return mongoTemplate.find(query, Client.class);
    }

    @Override
    public Client getClientById(String id) {
        Query query = new Query();
        Criteria criteria = Criteria.where("id").is(id);
        query.addCriteria(criteria);
        return mongoTemplate.findOne(query, Client.class);
    }

    @Override
    public Client createdClient(Client client) {
        return mongoTemplate.insert(client);
    }
}
