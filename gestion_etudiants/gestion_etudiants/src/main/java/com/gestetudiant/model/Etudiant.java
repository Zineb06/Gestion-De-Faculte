package com.gestetudiant.model;

import java.time.*;
import java.util.Date;
import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Etudiant {

@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String nom;
private String prenom;
private LocalDate dateNaissance;
private String cne;
private String cin;
private String numapp;
@Enumerated(EnumType.STRING)
private Niveau niveau;
@ManyToOne
private Filiere filiere;
}
