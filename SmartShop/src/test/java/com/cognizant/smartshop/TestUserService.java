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

import com.cognizant.smartshop.model.User;
import com.cognizant.smartshop.repository.UserRepository;
import com.cognizant.smartshop.service.UserService;





public class TestUserService {

	@InjectMocks
	UserService userService;

	@Mock
	UserRepository userRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void findUserByIdTest() {
		User user = new User();
		user.setFirstname("Sankalp");
		user.setLastname("Khawade");
		user.setAge(21);
		user.setGender("Male");
		user.setContact("9750277077");
		user.setUserid("Lonavala");
		user.setPassword("pwd");
		user.setUserType("U");
		user.setSecretQuestion("Dream place");
		user.setAnswer("Pune");
		user.setStatus("A");

		when(userRepository.findByUserid("Lonavala")).thenReturn(user);

		// test
		User testUser = userService.findByUserid("Lonavala");

		assertEquals("Lonavala", testUser.getUserid());
		assertEquals("Sankalp", testUser.getFirstname());
		assertEquals("Khawade", testUser.getLastname());
		assertEquals(21, testUser.getAge());
		assertEquals("Male", testUser.getGender());
		assertEquals("9750277077", testUser.getContact());
		assertEquals("pwd", testUser.getPassword());
		assertEquals("U", testUser.getUserType());
		assertEquals("Dream place", testUser.getSecretQuestion());
		assertEquals("Pune", testUser.getAnswer());
		assertEquals("A", testUser.getStatus());

	}

	@Test
	public void findUserByStatusTest() {
		User user = new User();
		user.setFirstname("Sankalp");
		user.setLastname("Khawade");
		user.setAge(21);
		user.setGender("Male");
		user.setContact("9750277077");
		user.setUserid("Lonavala");
		user.setPassword("pwd");
		user.setUserType("U");
		user.setSecretQuestion("Dream place");
		user.setAnswer("Pune");
		user.setStatus("A");

		List<User> users = new ArrayList<>();
		users.add(user);

		when(userRepository.findByStatus("A")).thenReturn(users);

		// test
		List<User> testUserList = userService.findbyStatus("A");

		for (User testUser : testUserList) {
			assertEquals("Lonavala", testUser.getUserid());
			assertEquals("Sankalp", testUser.getFirstname());
			assertEquals("Khawade", testUser.getLastname());
			assertEquals(21, testUser.getAge());
			assertEquals("Male", testUser.getGender());
			assertEquals("9750277077", testUser.getContact());
			assertEquals("pwd", testUser.getPassword());
			assertEquals("U", testUser.getUserType());
			assertEquals("Dream place", testUser.getSecretQuestion());
			assertEquals("Pune", testUser.getAnswer());
			assertEquals("A", testUser.getStatus());
		}
	}
	
}
