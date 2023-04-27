package com.cperez.apimongodb.service.impl;

import com.cperez.apimongodb.dto.ProductDTO;
import com.cperez.apimongodb.dto.SaleDTO;
import com.cperez.apimongodb.dto.SaleDetailDTO;
import com.cperez.apimongodb.model.Client;
import com.cperez.apimongodb.model.Product;
import com.cperez.apimongodb.model.Sale;
import com.cperez.apimongodb.model.SaleDetail;
import com.cperez.apimongodb.repository.ClientRepository;
import com.cperez.apimongodb.repository.ProductRepository;
import com.cperez.apimongodb.repository.SaleRepository;
import com.cperez.apimongodb.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Sale> getSales() {
        return saleRepository.getSales();
    }

    @Override
    public List<Sale> getSalesByProduct(String nameProduct) {
        return saleRepository.getSalesByProduct(nameProduct);
    }

    @Override
    public Sale createSale(SaleDTO saleDTO) {

        List<SaleDetail> saleDetails = new ArrayList<>();
        for(SaleDetailDTO saleDetailDTO : saleDTO.getSaleDetailsDTO()) {
            Product product = productRepository.getProductById(String.valueOf(
                    saleDetailDTO.getIdProduct()));
            SaleDetail saleDetail = new SaleDetail(saleDetailDTO, product);
            saleDetails.add(saleDetail);
        }

        Sale sale = new Sale(saleDTO, saleDetails);
        sale.setClient(clientRepository.getClientById(saleDTO.getIdClient()));
        sale.setSaleDetails(saleDetails);

        return saleRepository.createSale(sale);
    }
}
