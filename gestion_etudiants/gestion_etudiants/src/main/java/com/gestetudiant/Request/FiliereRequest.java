package com.gestetudiant.Request;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.gestetudiant.Response.FiliereResponse;
import com.gestetudiant.model.Etudiant;
import com.gestetudiant.model.Filiere;
import com.gestetudiant.model.Niveau;
import com.gestetudiant.model.Type;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FiliereRequest {
	private String nom;
	private String Description;
	private Type type;
	private LocalDate date_Ouverture;
	private String departement;
	
}
