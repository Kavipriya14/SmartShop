package com.cognizant.smartshop.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.smartshop.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
	
	Product findByProductCode(String productCode);

	List<Product> findByProductType(String productType);

	@Query(value = "select distinct pr_type from product", nativeQuery = true)
	List<String> findProductType();


}
