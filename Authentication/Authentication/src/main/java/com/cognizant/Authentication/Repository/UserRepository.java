package com.cognizant.Authentication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.Authentication.model.User;





public interface UserRepository  extends JpaRepository<User, String>{
	
	User findByUserid(String userid);

	List<User> findByStatus(String status);

	

}
