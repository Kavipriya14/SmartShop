package com.cognizant.smartshop.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.smartshop.SmartShopApplication;
import com.cognizant.smartshop.model.User;
import com.cognizant.smartshop.service.UserService;



@RestController
@CrossOrigin
public class SuperUserController {

	@Autowired
	UserService userService;

	private static final Logger LOGGER = LoggerFactory.getLogger(SmartShopApplication.class);

	@GetMapping(value = "/superuser")
	public List<User> findPendingAdmin() {
		return userService.findbyStatus("P");
	}

	@PutMapping(value = "/superuser/{userid}/{status}")
	public String superUserResponse(@PathVariable("userid") String userid, @PathVariable("status") String status) {
		User pendingAdmin = userService.findByUserid(userid);
		LOGGER.info("Old User Status: " + pendingAdmin.getStatus());
		pendingAdmin.setStatus(status);
		LOGGER.info("New User Status: " + pendingAdmin.getStatus());
		if (status.equalsIgnoreCase("A"))
			userService.saveUser(pendingAdmin);
		else if (status.equalsIgnoreCase("D"))
			userService.deleteById(userid);
		return pendingAdmin.getStatus();
	}
}
