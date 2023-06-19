package com.BIlham.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="note")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="nomModule")
	private String nomModule;
	@Column(name="apogeeEtudiant")
	private int apogeeEtudiant;
	@Column(name="nomEtudiant")
	private String nomEtudiant;
	@Column(name="observation")
	@Enumerated(EnumType.STRING)
	private observation observation;
	@Column(name="note")
	private Double note;
	@Column(name="semestre")
	@Enumerated(EnumType.STRING)
	private semestre semestre;
	

}

