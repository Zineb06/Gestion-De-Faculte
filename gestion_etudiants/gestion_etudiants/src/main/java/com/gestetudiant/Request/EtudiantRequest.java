package com.gestetudiant.Request;

import java.util.Date;

import com.gestetudiant.model.Filiere;
import com.gestetudiant.model.Niveau;

import lombok.Builder;
import lombok.Data;

@Data

public class EtudiantRequest {
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String email;
	private String cne;
	private String cin;
	private String numapp;
	private Niveau niveau;
}
