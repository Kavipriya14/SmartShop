package com.cognizant.Authentication.Controller;



import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Authentication.AuthenticationApplication;
import com.cognizant.Authentication.Repository.UserRepository;
import com.cognizant.Authentication.model.User;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@CrossOrigin
@RestController
public class AuthenticationController {

	@Autowired
	UserRepository userRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationApplication.class);

	@GetMapping("/authenticate")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
		LOGGER.info("START OF AUTH FUNCTION");
		HashMap<String, String> map = new HashMap<String, String>();
		String JWT = generateJwt((getUser(authHeader)));
		String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString();
		LOGGER.info("JWT:{}", JWT);
		map.put("Token", JWT);
		map.put("Role", role);
		LOGGER.info("Role:{}", role);
		String userId = getUser(authHeader);
		User user = userRepository.findByUserid(userId);
		if (user.getStatus().equalsIgnoreCase("P")) {
			map.put("Token", null);
		}
		LOGGER.info("END OF AUTH FUNCTION");
		return map;
	}

	private String getUser(String authHeader) {
		String encodedCredentials = authHeader.split(" ", 2)[1];
		String decoded = new String(Base64.getDecoder().decode(encodedCredentials));
		String user = decoded.substring(0, decoded.indexOf(':'));
		return user;
	}

	@SuppressWarnings("unused")
	private String getPassword(String authHeader) {
		String encodedCredentials = authHeader.split(" ", 2)[1];
		String decoded = new String(Base64.getDecoder().decode(encodedCredentials));
		String pwd = decoded.substring(decoded.indexOf(':') + 1);
		return pwd;
	}

	private String generateJwt(String user) {
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);
		// Set the token issue time as current time
		builder.setIssuedAt(new Date());
		// Set the token expiry as 20 minutes from now
		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");
		String token = builder.compact();
		return token;
	}
}
