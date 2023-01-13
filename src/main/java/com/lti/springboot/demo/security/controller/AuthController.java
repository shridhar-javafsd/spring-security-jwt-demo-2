package com.lti.springboot.demo.security.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.springboot.demo.security.entity.Guest;
import com.lti.springboot.demo.security.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;

@RestController
public class AuthController {

	Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("hi")
	public String hi() {
		LOG.info("hi");
		return "This is secured API.";
	}

	@GetMapping("hello")
	public String hello() {
		LOG.info("hello");
		return "This is public API.";
	}

	@PostMapping("login")
	public String generateToken(@RequestBody Guest guest) throws Exception {
		LOG.info(guest.toString());
		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(guest.getUsername(), guest.getPassword()));
		} catch (Exception ex) {
			throw new Exception("Inavalid credentials!");
		}
		return jwtUtil.generateToken(guest.getUsername());
	}

}
