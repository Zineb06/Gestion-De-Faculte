package com.BIlham.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.BIlham.dao.NotDao;
import com.BIlham.dto.NoteDTO;
import com.BIlham.model.Note;
@Service
public class NoteServiceImp implements NoteSercice {
@Autowired
      NotDao dao;
	@Override
	public NoteDTO addNote(NoteDTO note) {
		NoteDTO dto = NoteDTO.builder().build();
		Note adr = new Note();
		BeanUtils.copyProperties(note, adr);
		Note note1  = dao.save(adr);
		BeanUtils.copyProperties(note1, dto);
		return dto;
	}

	@Override
	public NoteDTO getNotebyAppoge(int apogeeEtudiant) {
		NoteDTO dto = NoteDTO.builder().build();
		Note adr = dao.findById(apogeeEtudiant).get();
		BeanUtils.copyProperties(adr, dto);
		return dto;
	}

	
	@Override
	public void deleteNoteById(int id) {
		dao.deleteById(id);
	}
	@Override
	public List<Note>find_All(){
		return dao.findAll();
		
	}

	@Override
	public Optional<Note> findById(int id) {
		return dao.findById(id);
	}
	/*
	 * @Override
	 * 
	 * public NoteDTO updateNote(NoteDTO note) { NoteDTO note1 =
	 * NoteDTO.builder().build(); Optional<Note>
	 * optionalNote=dao.findById(note.getId()); if(optionalNote.isPresent()) { Note
	 * note2=optionalNote.get(); BeanUtils.copyProperties(note, note1); Note
	 * updateNote=dao.save(note2); BeanUtils.copyProperties(updateNote, note1);
	 * 
	 * } else { //handle error object not found } return note1;
	 * 
	 * }
	 */

	@Override
	public NoteDTO updateNote(NoteDTO note) {
		// TODO Auto-generated method stub
		return null;
	}

	
	 @Override
	 public List<Note> findByNoteetudiant(double note) {
	 List<Note>listNote=dao.findByNote(note); 
	 return listNote; 
	 }
	 @Override
	 public List <Note>findByAppogeeEtud(int apogeeEtudiant){
		 List<Note>listeNote=dao.findByApogeeEtudiant(apogeeEtudiant);
		 return listeNote;
	 }
	 //ce qui j'ai ajouter pour le recherche par le semestre 
	 public List<Note> findByAppogeeEtudAndSemestre(int apogeeEtudiant, String semestre) {
		    List<Note> notes = dao.findByApogeeEtudiant(apogeeEtudiant);
		    return notes.stream()
		                .filter(note -> note.getSemestre().equals(semestre))
		                .collect(Collectors.toList());
		}
	 
	


@Override
public List<Note> findByNomEtudiant(String nomEtudiant) {
	 List<Note>listeNote=dao.findByNomEtudiant(nomEtudiant);
	 return listeNote;
}
	

}

