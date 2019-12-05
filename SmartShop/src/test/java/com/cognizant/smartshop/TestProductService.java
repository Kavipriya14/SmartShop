package com.cognizant.smartshop;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cognizant.smartshop.model.Product;
import com.cognizant.smartshop.repository.ProductRepository;
import com.cognizant.smartshop.service.ProductService;



public class TestProductService {

	@InjectMocks
	ProductService productService;
	
	@Mock
	ProductRepository productRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@Transactional
	public void testGetProduct() {
		
		List<Product> products = new ArrayList<Product>();
		
		Product productOne = new Product();
		productOne.setProductCode("HPB001");
		productOne.setProductName("Blender");
		productOne.setBrand("Prestige");
		productOne.setRate(350);
		productOne.setStock(2);
		productOne.setDate(new Date());
		productOne.setAisle("Lane 1");
		productOne.setShelf("B2");
		productOne.setManufactureDate(new Date());
		productOne.setExpiryDate(new Date());
		productOne.setImage("https://images.unsplash.com/flagged/photo-1572609239482-d3a83f976aa0?ixlib=rb-1.2.1");
		productOne.setProductType("Home Appliances");
		
		Product productTwo = new Product();
		productTwo.setProductCode("HSW001");
		productTwo.setProductName("Washing Machine");
		productTwo.setBrand("Samsung");
		productTwo.setRate(35000);
		productTwo.setStock(2);
		productTwo.setDate(new Date());
		productTwo.setAisle("Lane 1");
		productTwo.setShelf("B2");
		productTwo.setManufactureDate(new Date());
		productTwo.setExpiryDate(new Date());
		productTwo.setImage("https://images.unsplash.com/flagged/photo-1572609239482-d3a83f976aa0?ixlib=rb-1.2.1");
		productTwo.setProductType("Home Appliances");
		
		products.add(productOne);
		products.add(productTwo);
		
		when(productRepository.findAll()).thenReturn(products);
		
		//test
		
		List<Product> testProducts = productService.getProduct();
		
		assertEquals(2, testProducts.size());
		verify(productRepository, times(1)).findAll();
		
		
	}
	
	@Test
	public void testGetProductByCode() {
		Product productOne = new Product();
		productOne.setProductCode("HPB001");
		productOne.setProductName("Blender");
		productOne.setBrand("Prestige");
		productOne.setRate(350);
		productOne.setStock(2);
		productOne.setDate(new Date());
		productOne.setAisle("Lane 1");
		productOne.setShelf("B2");
		productOne.setManufactureDate(new Date());
		productOne.setExpiryDate(new Date());
		productOne.setImage("https://images.unsplash.com/flagged/photo-1572609239482-d3a83f976aa0?ixlib=rb-1.2.1");
		productOne.setProductType("Home Appliances");
		
		when(productRepository.findByProductCode("HPB001")).thenReturn(productOne);
		
		//test
		
		Product testProduct = productService.findProductByCode("HPB001");
		
		assertEquals("HPB001", testProduct.getProductCode());
	}
	
	@After
	public void shutdown() {
		
	}
	
}
