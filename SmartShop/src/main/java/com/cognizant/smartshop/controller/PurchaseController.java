package com.cognizant.smartshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.smartshop.model.Purchase;
import com.cognizant.smartshop.model.PurchaseHistory;
import com.cognizant.smartshop.service.PurchaseService;

@RestController
@CrossOrigin

public class PurchaseController {

	@Autowired
	PurchaseService purchaseService;

	@PostMapping("/purchase")
	public void purchase(@RequestBody Purchase purchase) {
		purchaseService.purchase(purchase);
	}

	@PostMapping("/{purchaseId}/{productCode}/{quantity}")
    public boolean purchaseHistory(@PathVariable("purchaseId") int purchaseId,
                  @PathVariable("productCode") String productCode, @PathVariable("quantity") int quantity) {
		System.err.println("Entering prchase history");
           return purchaseService.purchaseHistory(purchaseId, productCode, quantity);
    }

	
	@PutMapping("/purchase")
	public void updatePurchase(@RequestBody Purchase newPurchase) {
		purchaseService.updatePurchase(newPurchase);
	}
	@GetMapping("/purchase/history/{userId}")
	public List<PurchaseHistory> getPurchaseHistory(@PathVariable("userId") String userId) {
		return purchaseService.getPurchaseHistory(userId);
	}
	
	@GetMapping("/purchase")
    public int getPurchase() {
           
                  return purchaseService.getPurchase();
    
    }

	

}
