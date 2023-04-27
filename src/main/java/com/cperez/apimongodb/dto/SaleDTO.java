package com.cperez.apimongodb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleDTO {
	private String idClient;
	private ArrayList<SaleDetailDTO> saleDetailsDTO;
}
