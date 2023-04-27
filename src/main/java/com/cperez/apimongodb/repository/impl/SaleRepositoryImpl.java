package com.cperez.apimongodb.repository.impl;

import com.cperez.apimongodb.model.Sale;
import com.cperez.apimongodb.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.core.query.Query;
import java.util.List;

@Repository
public class SaleRepositoryImpl implements SaleRepository {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public List<Sale> getSales() {
        return mongoTemplate.findAll(Sale.class);
    }

    @Override
    public List<Sale> getSalesByProduct(String nameProduct) {
        Query query = new Query();
        Criteria criteria = Criteria.where("saleDetails.product.description").is(nameProduct);
        query.addCriteria(criteria);
        return mongoTemplate.find(query, Sale.class);
    }

    @Override
    public Sale createSale(Sale sale) {
        return mongoTemplate.insert(sale);
    }
}
