package com.zineb.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@Getter

public class ProfesseurDto {
	private int id;
	private String prenom;
	private String nom;
	private String email;
	private String tel;
	private String cin;
	private String departement;
}
