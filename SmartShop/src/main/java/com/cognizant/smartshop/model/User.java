package com.cognizant.smartshop.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "user_id")
	private String userid;
	@Column(name = "user_firstname")
	private String firstname;
	@Column(name = "user_lastname")
	private String lastname;
	@Column(name = "user_age")
	private int age;
	@Column(name = "user_gender")
	private String gender;
	@Column(name = "user_contact_no")
	private String contact;
	@Column(name = "user_password")
	private String password;
	@Column(name = "user_type")
	private String userType;
	@Column(name = "user_status")
	private String status;
	@Column(name = "user_answer")
	private String answer;
	@Column(name = "user_question")
	private String secretQuestion;
	@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy = "user")
	private Set<Purchase> purchases;

	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	

	public Set<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(Set<Purchase> purchases) {
		this.purchases = purchases;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age
				+ ", gender=" + gender + ", contact=" + contact + ", password=" + password + ", userType="
				+ userType + ", status=" + status + ", answer=" + answer + ", secretQuestion=" + secretQuestion
				+ "]";
	}

	

}
