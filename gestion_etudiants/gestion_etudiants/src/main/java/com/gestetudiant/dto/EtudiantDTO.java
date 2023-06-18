package com.gestetudiant.dto;

import java.time.*;
import java.util.Date;

import com.gestetudiant.model.Filiere;
import com.gestetudiant.model.Niveau;
import jakarta.persistence.EnumType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EtudiantDTO {
	private Long id;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String cne;
	private String cin;
	private String numapp;
	private Niveau niveau;
	private String filiere;
	
}
