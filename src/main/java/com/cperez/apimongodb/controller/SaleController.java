package com.cperez.apimongodb.controller;

import com.cperez.apimongodb.dto.SaleDTO;
import com.cperez.apimongodb.model.Product;
import com.cperez.apimongodb.model.Sale;
import com.cperez.apimongodb.service.SaleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/sales")
@Slf4j
public class SaleController {
	@Autowired
	private SaleService saleService;
	
	@GetMapping("")
	public ResponseEntity<List<Sale>> getSales(){
		try {
			List<Sale> sales = saleService.getSales();
			return ResponseEntity.status(HttpStatus.OK).body(sales);
		}
		catch(Exception ex) {
			log.error(ex.getMessage());
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/byproduct/{nameProduct}")
	public ResponseEntity<List<Sale>> getSalesByProduct(@PathVariable String nameProduct){
		try {
			List<Sale> sales = saleService.getSalesByProduct(nameProduct);
			return ResponseEntity.status(HttpStatus.OK).body(sales);
		}
		catch(Exception ex) {
			log.error(ex.getMessage());
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PostMapping("")
	@Transactional
	public ResponseEntity<Sale> createSale(@RequestBody SaleDTO saleDto){
		try {
			Sale sale = saleService.createSale(saleDto);
			return ResponseEntity.status(HttpStatus.CREATED).body(sale);
		}
		catch(Exception ex) {
			log.error(ex.getMessage());
			return ResponseEntity.internalServerError().build();
		}
	}
	
}
