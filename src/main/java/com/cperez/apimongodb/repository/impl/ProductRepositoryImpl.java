package com.cperez.apimongodb.repository.impl;

import com.cperez.apimongodb.model.Product;
import com.cperez.apimongodb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Product> getProducts() {
        return mongoTemplate.findAll(Product.class);
    }

    @Override
    public Product createProduct(Product product) {
        return mongoTemplate.insert(product);
    }

    @Override
    public Product getProductById(String id) {
        Query query = new Query();
        Criteria criteria = Criteria.where("id").is(id);
        query.addCriteria(criteria);
        return mongoTemplate.findOne(query, Product.class);
    }
}
