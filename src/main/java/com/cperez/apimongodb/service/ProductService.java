package com.cperez.apimongodb.service;

import com.cperez.apimongodb.dto.ProductDTO;
import com.cperez.apimongodb.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getProducts();
    public Product createProduct(ProductDTO productDTO);
    public Product getProductById(String id);
}
