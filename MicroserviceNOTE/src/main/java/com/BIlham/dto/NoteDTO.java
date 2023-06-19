package com.BIlham.dto;

import com.BIlham.model.observation;
import com.BIlham.model.semestre;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@Getter
public class NoteDTO {
	private int id;
	private String nomModule;
	private int apogeeEtudiant;
	private String nomEtudiant;
	private double note;
	private observation observation;
	private semestre semestre;
	
}
