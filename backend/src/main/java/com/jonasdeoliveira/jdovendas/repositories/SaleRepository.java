package com.jonasdeoliveira.jdovendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonasdeoliveira.jdovendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

}
