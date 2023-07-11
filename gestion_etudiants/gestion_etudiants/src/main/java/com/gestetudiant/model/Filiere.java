package com.gestetudiant.model;

import jakarta.persistence.CascadeType;

import java.time.LocalDate;
import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Filiere {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	/**Une filière est désignée par son nom.*/
	private String nom;
	private String Description;
	
@OneToMany(mappedBy = "filiere", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Etudiant> etudiants;
@Enumerated(EnumType.STRING)
private Type type;
private LocalDate date_Ouverture;
private String departement;
}
