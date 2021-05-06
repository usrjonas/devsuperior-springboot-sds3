package com.jonasdeoliveira.jdovendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jonasdeoliveira.jdovendas.dto.SaleSuccessDTO;
import com.jonasdeoliveira.jdovendas.dto.SaleSumDTO;
import com.jonasdeoliveira.jdovendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	@Query("SELECT new com.jonasdeoliveira.jdovendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) " +
			" FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGoupedBySeller();
	
	@Query("SELECT new com.jonasdeoliveira.jdovendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) " +
			" FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGoupedBySeller();

}
