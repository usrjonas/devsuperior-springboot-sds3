package com.jonasdeoliveira.jdovendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonasdeoliveira.jdovendas.dto.SellerDTO;
import com.jonasdeoliveira.jdovendas.entities.Seller;
import com.jonasdeoliveira.jdovendas.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository repository;
	
	public List<SellerDTO> findAll() {
		List<Seller> list = repository.findAll();
		return list.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}

}
