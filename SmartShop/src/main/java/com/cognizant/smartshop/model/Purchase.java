package com.cognizant.smartshop.model;



import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "purchase")
public class Purchase {

	@Id
	@Column(name = "pu_id")
	private int id;
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Column(name = "pu_date")
	private Date date;
	@Column(name = "pu_amount")
	private int totalAmount;
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "fk_user_id")
	private User user;
	@JsonIgnore
	@OneToMany(mappedBy = "purchase")
	private Set<PurchaseHistory> purchaseHistories;
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "purchase_history", joinColumns = @JoinColumn(name = "fk_pu_id"), inverseJoinColumns = @JoinColumn(name = "fk_pr_code"))
	private List<Product> products;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<PurchaseHistory> getPurchaseHistories() {
		return purchaseHistories;
	}

	public void setPurchaseHistories(Set<PurchaseHistory> purchaseHistories) {
		this.purchaseHistories = purchaseHistories;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", date=" + date + ", totalAmount=" + totalAmount + ", user=" + user + "]";
	}

}