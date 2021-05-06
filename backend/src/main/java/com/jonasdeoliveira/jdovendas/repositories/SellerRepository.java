package com.jonasdeoliveira.jdovendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonasdeoliveira.jdovendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long>{

}
