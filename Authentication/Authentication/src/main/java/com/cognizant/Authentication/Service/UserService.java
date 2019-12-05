package com.cognizant.Authentication.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.Authentication.Repository.UserRepository;
import com.cognizant.Authentication.model.User;



@Component
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public User findByUserid(String userid){
		return userRepository.findByUserid(userid);
		
	}
	
	@Transactional
	public List<User> findbyStatus(String status) {
		return userRepository.findByStatus(status);
	}

	@Transactional
	public void saveUser(User user)
	{
		userRepository.save(user);
	}

	@Transactional
	public void deleteById(String userid) {
		userRepository.deleteById(userid);
		
	}
	
	
	
	
	
	
	

}
