package com.zineb;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.zineb.model.Professeur;
import com.zineb.repository.ProfRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class GestionDesProfesseursApplicationTests {

	@Autowired private ProfRepository repo;
	
	@Test
	public void testAdd() {
		Professeur prof = new Professeur();
		prof.setCin("ia1212");
		prof.setDepartement("biologie");
		prof.setEmail("samira@gmail.com");
		prof.setNom("hafidi");
		prof.setPrenom("samire");
		prof.setTel("0611111111");
		
		Professeur savedProf = repo.save(prof);
		Assertions.assertThat(savedProf).isNotNull();
		Assertions.assertThat(savedProf.getId()).isGreaterThan(0);
		
	}
	
	@Test
	public void testListAll() {
		Iterable<Professeur> profs = repo.findAll();
		Assertions.assertThat(profs).hasSizeGreaterThan(0);
		
		for(Professeur prof : profs) {
			System.out.println(prof);
		}
	}
	
	@Test
	public void testUpdateProf() {
		Integer id = 202;
		Optional<Professeur> optProf = repo.findById(id);
		Professeur prof = optProf.get();
		prof.setTel("0612121212");
		
		Professeur updatedProf = repo.findById(id).get();
		Assertions.assertThat(updatedProf.getTel()).isEqualTo("0612121212");
	}
		
	@Test
	public void testGet() {
		Integer id = 202;
		Optional<Professeur> optProf = repo.findById(id);
		Assertions.assertThat(optProf).isPresent();
		System.out.println(optProf.get());
	}
	
	@Test
	public void testDelete() {
		Integer id = 252;
		repo.deleteById(id);
		
		Optional<Professeur> optProf = repo.findById(id);
		Assertions.assertThat(optProf).isNotPresent();
	}

} 
	