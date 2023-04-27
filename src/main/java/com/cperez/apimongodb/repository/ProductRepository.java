package com.cperez.apimongodb.repository;


import com.cperez.apimongodb.model.Product;

import java.util.List;

public interface ProductRepository {
	List<Product> getProducts();
	Product createProduct(Product product);
	Product getProductById(String id);
}
