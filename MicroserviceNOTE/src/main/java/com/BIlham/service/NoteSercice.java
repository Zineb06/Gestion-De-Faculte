package com.BIlham.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.BIlham.dto.NoteDTO;
import com.BIlham.model.Note;

public interface NoteSercice {
	public NoteDTO addNote(NoteDTO note);
	public NoteDTO getNotebyAppoge(int apogeeEtudiant);
	public void deleteNoteById(int id);
	List<Note> find_All();
	public Optional<Note> findById(int id);
	NoteDTO updateNote(NoteDTO note);
	//ca qui ajouter 
	
	List<Note> findByAppogeeEtud(int apogeeEtudiant);
	List<Note> findByNoteetudiant(double note);
	public List<Note> findByAppogeeEtudAndSemestre(int apogeeEtudiant, String semestre);
	
	List<Note> findByNomEtudiant(String nomEtudiant);
	

}

