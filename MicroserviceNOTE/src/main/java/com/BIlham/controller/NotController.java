package com.BIlham.controller;

import java.security.PublicKey;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.BIlham.dto.NoteDTO;
import com.BIlham.model.Note;
import com.BIlham.request.NoteRequest;
import com.BIlham.response.NoteResponse;
import com.BIlham.service.NoteSercice;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.servlet.http.HttpServletRequest;

import com.BIlham.request.NoteRequest;
import com.BIlham.response.NoteResponse;

import lombok.Data;

@Controller
@RequestMapping("/notes")
@Data
public class NotController {
	@Autowired
	NoteSercice service;

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/Add_Note")
	public String addnot() {
		return "Add_Note";
	}

	@GetMapping("/ALLNOTE")
	public ModelAndView findALL() {

		List<Note> List = service.find_All();
		return new ModelAndView("ALLNOTE", "note", List);
	}

		@PostMapping("/save")
	public String addNot(@ModelAttribute Note n) {
		NoteResponse noteResp = NoteResponse.builder().build();
		NoteDTO dto = NoteDTO.builder().build();
		BeanUtils.copyProperties(n, dto);
		NoteDTO dto1 = service.addNote(dto);
		BeanUtils.copyProperties(dto1, noteResp);
		return "redirect:/notes/ALLNOTE";

	}

	
	@GetMapping("/gerer_les notes")
	public ModelAndView gereNotes(Model model) {
		List<Note> notList = service.find_All();
		model.addAttribute("note", notList);
		ModelAndView m = new ModelAndView();
		m.setViewName("gerer_les notes");
		return m;
	}

	@RequestMapping("/supprimer/{id}")
	public String delete(@PathVariable int id) {
		service.deleteNoteById(id);
		return "redirect:/notes/ALLNOTE";
	}

	@RequestMapping("/modifier/{id}")
	public String modifier(@PathVariable("id") int id, Model model) {
		NoteDTO noteD = service.getNotebyAppoge(id);
		model.addAttribute("note", noteD);
		return "modifier";
	}

	@RequestMapping("/chercher")
	public String chercher() {
		return "chercher";
	}
	

	
	  @GetMapping("chercherAppogee/{apogeeEtudiant}") public String
	  chercherApp(@RequestParam int apogeeEtudiant,Model model){ List<Note>
	  listNote=service.findByAppogeeEtud(apogeeEtudiant);
	  model.addAttribute("note", listNote); return "resultatAP"; }
	  
	  
	
	 @RequestMapping("/chercherAP") public String chercherAP() {
	  return"chercherAppogee"; }
	  
	 
	 
	 @GetMapping("/rechercherSeme/{apogeeEtudiant}/{semestre}")  
	 public String rechercherNotesParEtudiant(@RequestParam int apogeeEtudiant,@RequestParam com.BIlham.model.semestre semestre ,Model model) {
		    List<Note> listNote=service.findByAppogeeEtud(apogeeEtudiant);
		    if (semestre != null && ! semestre.toString().equalsIgnoreCase("T")) {
		        listNote = listNote.stream()
		                .filter(note -> note.getSemestre().equals(semestre))
		                .collect(Collectors.toList());
		 model.addAttribute("selectedSemester", semestre); 
		 }
	          model.addAttribute("notes", listNote);
		     return "NotesSem";
		}
		  
		  
	 @RequestMapping("/ChAppSeme") public String chercherAPSE() {
		  return"ChAppSeme"; }
		  
		/*
		 * @RequestMapping("/TestTélécharger") public String Telecharger() {
		 * return"TestTélécharger"; }
		 */
	 
	 @RequestMapping("/techargmentfin") public String TelechargerNotefin() {
		  return"techargmentfin"; }
	 
	
	 
	 @GetMapping("/telechargenotes/{apogeeEtudiant}/{semestre}")  
	 public String telechargerNotes(@RequestParam int apogeeEtudiant,@RequestParam com.BIlham.model.semestre semestre ,Model model) {
		    List<Note> listNote=service.findByAppogeeEtud(apogeeEtudiant);
		    if (semestre != null && ! semestre.toString().equalsIgnoreCase("T")) {
		        listNote = listNote.stream()
		                .filter(note -> note.getSemestre().equals(semestre))
		                .collect(Collectors.toList());
		 model.addAttribute("selectedSemester", semestre); 
		 }
	          model.addAttribute("notes", listNote);
		     return "TestTélécharger";
		}

	 
	 @GetMapping("/chercherId/{nomEtudiant}") 
	  public String chercherNoteParId(@RequestParam String nomEtudiant, Model model) 
	  { List<Note> listNote = service.findByNomEtudiant(nomEtudiant);
	  model.addAttribute("note", listNote); 
	  return "resultats"; }
}