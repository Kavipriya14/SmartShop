package com.cognizant.smartshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.smartshop.model.Quantity;
import com.cognizant.smartshop.model.User;

public interface QuantityRepository extends JpaRepository<Quantity, String>{

}
