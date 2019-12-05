package com.cognizant.smartshop.repository;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.smartshop.model.Product;
import com.cognizant.smartshop.model.Purchase;
import com.cognizant.smartshop.model.PurchaseHistory;



@Repository
public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, String> {

	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "insert into purchase_history(fk_pr_code, fk_pu_id,fk_q_id) values(?1,?2,?3)")
	void save(String productCode, int purchaseId,int quantity);

	List<PurchaseHistory> findByPurchase(Purchase purchase);

	

	
}
