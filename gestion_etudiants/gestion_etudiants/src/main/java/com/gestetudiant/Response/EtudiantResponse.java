package com.gestetudiant.Response;

import java.time.*;
import java.util.Date;

import com.gestetudiant.model.Etudiant;
import com.gestetudiant.model.Filiere;
import com.gestetudiant.model.Niveau;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantResponse {
	private Long id;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String cne;
	private String cin;
	private String numapp;
	private Niveau niveau;
	private Filiere filiere;
	
}
