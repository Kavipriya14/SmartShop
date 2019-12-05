package com.cognizant.smartshop.model;



import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@Column(name = "pr_code")
	private String productCode;
	@Column(name = "pr_name")
	private String productName;
	@Column(name = "pr_brand")
	private String brand;
	@Column(name = "pr_rate")
	private int rate;
	@Column(name = "pr_stock")
	private int stock;
	@Column(name = "pr_add_date")
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date date;
	@Column(name = "pr_aisle")
	private String aisle;
	@Column(name = "pr_shelf")
	private String shelf;
	@Column(name = "pr_date_manufacture")
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date manufactureDate;
	@Column(name = "pr_date_expiry")
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date expiryDate;
	@Column(name = "pr_image")
	private String image;
	@Column(name = "pr_type")
	private String productType;
	@JsonIgnore
	@ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)
	private List<Purchase> purchases;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)
	private List<Quantity> quantity;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}



	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAisle() {
		return aisle;
	}

	public void setAisle(String aisle) {
		this.aisle = aisle;
	}

	public String getShelf() {
		return shelf;
	}

	public void setShelf(String shelf) {
		this.shelf = shelf;
	}

	

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}
	

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	public List<Quantity> getQuantity() {
		return quantity;
	}

	public void setQuantity(List<Quantity> quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", brand=" + brand + ", rate="
				+ rate + ", stock=" + stock + ", date=" + date + ", aisle=" + aisle + ", shelf=" + shelf
				+ ", manufactureDate=" + manufactureDate + ", expiryDate=" + expiryDate + ", image=" + image
				+ ", productType=" + productType + "]";
	}

}