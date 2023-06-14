package com.zineb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zineb.model.Professeur;
import com.zineb.service.ProfService;

@RestController 
public class ProfController {

	@Autowired
	private ProfService service;
	
	@GetMapping("/professeurs")
	public ModelAndView getAllProf() {
		List<Professeur> list = service.getAllProf();
		return new ModelAndView("professeurs","list", list);
	}
	
	@GetMapping("/listprof")
	public ModelAndView showProf() {
		return new ModelAndView("redirect:/professeurs");
	}
	
	@PostMapping("/saveProf")
	public ModelAndView addProf(@ModelAttribute Professeur p, RedirectAttributes ra) {
		service.save(p);
		ra.addFlashAttribute("message", "Professeur enregistré avec succès! ");
		return new ModelAndView("redirect:/professeurs");
	}
	
	@GetMapping("/deleteProf/{id}")
	public ModelAndView deleteProf(@PathVariable("id") int id, RedirectAttributes ra) {
		service.delete(id);
		ra.addFlashAttribute("msg", "Professeur supprimé avec succès! ");
		return new ModelAndView("redirect:/professeurs");
	}
	
	@GetMapping("/editProf/{id}")
	public ModelAndView editProf(@PathVariable("id") int id, Model model) {
	
		Professeur p = service.getProfById(id);
		model.addAttribute("user", p);
		return new ModelAndView("editForm");
	}
	
	@PostMapping("/service-professeurs/searchProf")
	public ModelAndView searchProf(@ModelAttribute("search") Professeur p, Model model) {
		int id = p.getId();
		Professeur prof = service.getProfById(id);
		model.addAttribute("user", prof);
		return new ModelAndView("search");	
	}
	
}
