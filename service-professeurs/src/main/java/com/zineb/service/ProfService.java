package com.zineb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zineb.model.Professeur;
import com.zineb.repository.ProfRepository;

@Service
public class ProfService {

	@Autowired
	private ProfRepository repo;
	
	public void save(Professeur p) {
		repo.save(p);
	}
	
	public List<Professeur> getAllProf(){
		return repo.findAll();
	}
	
	public Professeur getProfById(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
}
