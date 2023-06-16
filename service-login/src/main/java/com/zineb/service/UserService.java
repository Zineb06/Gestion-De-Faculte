package com.zineb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zineb.entity.Login;
import com.zineb.repository.Repository;

@Service
public class UserService {

	@Autowired
	private Repository repo;
	
	public Login login(String username, String password) {
		Login login = repo.findByUsernameAndPassword(username, password);
		return login;
	}
	
}
