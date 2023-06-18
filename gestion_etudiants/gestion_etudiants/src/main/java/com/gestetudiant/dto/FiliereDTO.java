package com.gestetudiant.dto;


import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import com.gestetudiant.model.Niveau;
import com.gestetudiant.model.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FiliereDTO {
	private Long id;
	private String nom;
	private String Description;
	private List<EtudiantDTO> etudiants;
    public FiliereDTO(Long id, String nom) {
        this.id = id;
        this.nom = nom;
        this.etudiants = new ArrayList<>();
    }
    public List<EtudiantDTO> getEtudiants() {
        if(etudiants == null){
            etudiants = new ArrayList<>(); // initialize the etudiants list
        }
        return etudiants;
        
    }
	private Type type;
	private LocalDate date_Ouverture;
	private String departement;
}
