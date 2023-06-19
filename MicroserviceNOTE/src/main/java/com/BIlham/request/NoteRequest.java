package com.BIlham.request;

import com.BIlham.model.observation;
import com.BIlham.model.semestre;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoteRequest {
	private String nomModule;
	private int apogeeEtudiant;
	private String nomEtudiant;
	private double note;
	private observation observation;
	private semestre semestre;
}
