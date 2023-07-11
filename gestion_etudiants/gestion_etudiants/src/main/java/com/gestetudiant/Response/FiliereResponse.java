package com.gestetudiant.Response;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

import com.gestetudiant.dto.EtudiantDTO;
import com.gestetudiant.model.Etudiant;
import com.gestetudiant.model.Filiere;
import com.gestetudiant.model.Niveau;
import com.gestetudiant.model.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@Repository
@AllArgsConstructor
@NoArgsConstructor
public class FiliereResponse {
	public FiliereResponse(Filiere f) {
		nom = f.getNom();
		Description = f.getDescription();
	}
	private Long id;
	private String nom;
	private String Description;
	private List<EtudiantDTO> etudiants;
	private Type type;
	private LocalDate date_Ouverture;
	private String departement;
}

