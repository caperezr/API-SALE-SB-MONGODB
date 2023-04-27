package com.cperez.apimongodb.model;


import com.cperez.apimongodb.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	private String id;
	private String description;
	private double cost;

	
	public Product(ProductDTO productDTO) {
		this.description = productDTO.getDescription();
		this.cost = productDTO.getCost();

	}
}
