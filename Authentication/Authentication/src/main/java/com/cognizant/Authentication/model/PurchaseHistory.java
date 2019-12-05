package com.cognizant.Authentication.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "purchase_history")
public class PurchaseHistory {

	@Id
	@Column(name = "ph_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "fk_pr_code")
	private Product productCode;
	@ManyToOne
	@JoinColumn(name = "fk_pu_id")
	private Purchase purchase;
	@ManyToOne
	@JoinColumn(name = "fk_q_id")
	private Quantity quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProductCode() {
		return productCode;
	}

	public void setProductCode(Product productCode) {
		this.productCode = productCode;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public Quantity getQuantity() {
		return quantity;
	}

	public void setQuantity(Quantity quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "PurchaseHistory [id=" + id + ", productCode=" + productCode + ", purchase=" + purchase + ", quantity="
				+ quantity + "]";
	}

}

