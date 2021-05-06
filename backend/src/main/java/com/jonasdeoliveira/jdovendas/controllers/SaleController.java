package com.jonasdeoliveira.jdovendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonasdeoliveira.jdovendas.dto.SaleDTO;
import com.jonasdeoliveira.jdovendas.dto.SaleSuccessDTO;
import com.jonasdeoliveira.jdovendas.dto.SaleSumDTO;
import com.jonasdeoliveira.jdovendas.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping	
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
		Page<SaleDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value="/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGoupedBySellerount(){
		List<SaleSumDTO> list = service.amountGoupedBySeller();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value="/success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> successGoupedBySellerount(){
		List<SaleSuccessDTO> list = service.successGoupedBySeller();
		return ResponseEntity.ok(list);
	}
	
}
