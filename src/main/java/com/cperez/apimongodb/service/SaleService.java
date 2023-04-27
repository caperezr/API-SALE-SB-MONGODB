package com.cperez.apimongodb.service;


import com.cperez.apimongodb.dto.SaleDTO;
import com.cperez.apimongodb.model.Sale;

import java.util.List;

public interface SaleService {
	List<Sale> getSales();
	List<Sale> getSalesByProduct(String nameProduct);
	Sale createSale(SaleDTO saleDTO);
}
