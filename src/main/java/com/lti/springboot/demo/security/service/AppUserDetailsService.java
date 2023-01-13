package com.lti.springboot.demo.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lti.springboot.demo.security.entity.AppUser;
import com.lti.springboot.demo.security.repository.AppUserRepository;

import java.util.ArrayList;
import org.springframework.security.core.userdetails.User;

@Service
public class AppUserDetailsService implements UserDetailsService {

	Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AppUserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LOG.info("loadUserByUsername invoked");
		AppUser appUser = repository.findByUsername(username);
		LOG.debug(appUser.toString());
		return new User(appUser.getUserName(), appUser.getPassword(), new ArrayList<>());
	}
}
