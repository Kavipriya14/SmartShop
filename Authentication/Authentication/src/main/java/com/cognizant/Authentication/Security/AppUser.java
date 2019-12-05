package com.cognizant.Authentication.Security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cognizant.Authentication.AuthenticationApplication;
import com.cognizant.Authentication.model.User;


public class AppUser implements UserDetails {
	private User user; // entity reference
	private Collection<? extends GrantedAuthority> authorities; // to store role
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationApplication.class); // details

	public AppUser(User user) {
		// TODO Auto-generated constructor stub
		LOGGER.info("reger" + user.getPassword());
		ArrayList<String> roleList = new ArrayList<String>();
		roleList.add(user.getUserType());
		this.authorities = roleList.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
		LOGGER.info("Hello");
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUserid();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
