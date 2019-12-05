package com.cognizant.smartshop;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cognizant.smartshop.model.Purchase;
import com.cognizant.smartshop.model.User;
import com.cognizant.smartshop.repository.PurchaseRepository;
import com.cognizant.smartshop.service.PurchaseService;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class TestPurchaseService {

	@InjectMocks
	PurchaseService purchaseService;
	
	@Mock
	PurchaseRepository purchaseRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetPurchase() {
		User userOne = new User();
		userOne.setUserid("korangu");
		Purchase purchaseOne = new Purchase();
		purchaseOne.setId(1);
		purchaseOne.setDate(new Date());
		purchaseOne.setTotalAmount(200);
		purchaseOne.setUser(userOne);
		
		User userTwo = new User();
		userTwo.setUserid("psycho");
		Purchase purchaseTwo = new Purchase();
		purchaseTwo.setId(2);
		purchaseTwo.setDate(new Date());
		purchaseTwo.setTotalAmount(2000);
		purchaseTwo.setUser(userTwo);
		
		User userThree = new User();
		userThree.setUserid("caramel");
		Purchase purchaseThree = new Purchase();
		purchaseThree.setId(3);
		purchaseThree.setDate(new Date());
		purchaseThree.setTotalAmount(20000);
		purchaseThree.setUser(userThree);
		
		when(purchaseRepository.findLastId()).thenReturn(3);
		
		//test
		
		int id = purchaseService.getPurchase();
		assertEquals(3, id);
	}
}

