package com.cperez.apimongodb.service.impl;

import com.cperez.apimongodb.dto.ProductDTO;
import com.cperez.apimongodb.model.Product;
import com.cperez.apimongodb.repository.ProductRepository;
import com.cperez.apimongodb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    @Override
    public Product createProduct(ProductDTO productDTO) {
        Product product = new Product(productDTO);
        return productRepository.createProduct(product);
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.getProductById(id);
    }
}
