package com.BIlham.response;

import com.BIlham.model.observation;
import com.BIlham.model.semestre;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
@Getter
@Data
@Builder
public class NoteResponse {
	private String nomModule;
	private String nomEtudiant;
	private int apogeeEtudiant;
	private double note;
	private observation observation;
	private semestre semestre;
}
