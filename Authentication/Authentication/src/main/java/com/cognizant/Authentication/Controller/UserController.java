package com.cognizant.Authentication.Controller;

import java.util.Base64;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Authentication.AuthenticationApplication;
import com.cognizant.Authentication.Service.UserService;
import com.cognizant.Authentication.model.User;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin
public class UserController {
	
	
	@Autowired
	UserService userService;

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationApplication.class);

	@PostMapping("/users")
	public String register(@RequestBody User userList) {
		User user = userService.findByUserid(userList.getUserid());
		if (user == null) {
			LOGGER.info("" + userList.getUserType());
			User newUser = new User();
			newUser.setFirstname(userList.getFirstname());
			newUser.setLastname(userList.getLastname());
			newUser.setAge(userList.getAge());
			newUser.setGender(userList.getGender());
			newUser.setContact(userList.getContact());
			newUser.setUserid(userList.getUserid());
			newUser.setPassword(passwordEncoder().encode(userList.getPassword()));
			newUser.setUserType(userList.getUserType());
			newUser.setAnswer(userList.getAnswer());
			newUser.setSecretQuestion(userList.getSecretQuestion());
			if (userList.getUserType().equalsIgnoreCase("U")) {
				newUser.setStatus("A");
				userService.saveUser(newUser);
				return "A";
			} else if (userList.getUserType().equalsIgnoreCase("A")) {
				newUser.setStatus("P");
				userService.saveUser(newUser);
				return "P";
			} else {
				return "D";
			}
		} else
			return "User Already Exists";

	}

	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@GetMapping("users/{userid}")
	public User getUser(@PathVariable("userid") String userid) {
		return userService.findByUserid(userid);
	}
	

}
