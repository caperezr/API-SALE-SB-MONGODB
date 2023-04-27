package com.cperez.apimongodb.repository;


import com.cperez.apimongodb.model.Sale;

import java.util.List;

public interface SaleRepository {
	List<Sale> getSales();
	List<Sale> getSalesByProduct(String nameProduct);

	Sale createSale(Sale sale);
}
