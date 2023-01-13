package com.lti.springboot.demo.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.springboot.demo.security.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

	public abstract AppUser findByUsername(String username);

}
