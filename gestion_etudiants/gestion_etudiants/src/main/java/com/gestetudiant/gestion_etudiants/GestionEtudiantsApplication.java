package com.gestetudiant.gestion_etudiants;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.gestetudiant.model.Etudiant;
import com.gestetudiant.model.Filiere;

@SpringBootApplication

@ComponentScan({"com.gestetudiant.service", " com.gestetudiant.controller"})
@EntityScan("com.gestetudiant.model")
@EnableJpaRepositories("com.gestetudiant.dao")

public class GestionEtudiantsApplication {
	public static void main(String[] args) {
		SpringApplication.run(GestionEtudiantsApplication.class, args);
	}

	

}
