package com.cperez.apimongodb.model;


import com.cperez.apimongodb.dto.SaleDetailDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDetail {

	private Product product;
	private int quantity;
	private double subtotal;
	
	public SaleDetail(SaleDetailDTO saleDetailDTO, Product product) {
		this.product = product;
		this.quantity = saleDetailDTO.getQuantity();
		this.subtotal = saleDetailDTO.getQuantity() * product.getCost();
	}
}
