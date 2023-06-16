package com.zineb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zineb.entity.Login;


@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Login, Integer> {
	
	Login findByUsernameAndPassword(String username, String password);
}
