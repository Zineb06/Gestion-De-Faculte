package com.zineb.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@Getter
public class ProfResponse {

	private String prenom;
	private String nom;
	private String email;
	private String tel;
	private String cin;
	private String departement;

}
