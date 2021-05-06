package com.jonasdeoliveira.jdovendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jonasdeoliveira.jdovendas.dto.SaleDTO;
import com.jonasdeoliveira.jdovendas.entities.Sale;
import com.jonasdeoliveira.jdovendas.repositories.SaleRepository;
import com.jonasdeoliveira.jdovendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> list = repository.findAll(pageable);
		return list.map(x -> new SaleDTO(x));
	}

}
