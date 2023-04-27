package com.cperez.apimongodb.model;

import com.cperez.apimongodb.dto.SaleDTO;
import com.cperez.apimongodb.dto.SaleDetailDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
	@Id
	private String id;
	private Client client;
	private double total;
	private List<SaleDetail> saleDetails;
	
	public Sale(SaleDTO saleDTO, List<SaleDetail> saleDetails) {
		double total = 0.0;
		for(int i = 0; i < saleDetails.size(); i++) {
			total+= saleDTO.getSaleDetailsDTO().get(i).getQuantity() *
					saleDetails.get(i).getProduct().getCost();
		}
		this.total = total;
	}
}
