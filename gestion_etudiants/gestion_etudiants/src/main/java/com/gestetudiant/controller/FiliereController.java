package com.gestetudiant.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestetudiant.Request.FiliereRequest;
import com.gestetudiant.Response.EtudiantResponse;
import com.gestetudiant.Response.FiliereResponse;
import com.gestetudiant.dto.EtudiantDTO;
import com.gestetudiant.dto.FiliereDTO;
import com.gestetudiant.service.EtudiantService;
import com.gestetudiant.service.FiliereService;
import java.util.Collection;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/filieres")
public class FiliereController {

	@Autowired
		FiliereService service;
	@Autowired
	EtudiantService service1;
		
	@PostMapping("/add")
	public FiliereResponse addFiliere(@RequestBody FiliereRequest request) {
	    FiliereResponse response = FiliereResponse.builder().build();
	    FiliereDTO dto = FiliereDTO.builder().build();
	    BeanUtils.copyProperties(request, dto);
	    FiliereDTO savedDto = service.addFiliere(dto);
	    BeanUtils.copyProperties(savedDto, response);
	    return response;
	}
	
	

	@PostMapping("/filiere/{filiereId}/etudiant")
	public FiliereResponse addEtudiantToFiliere(@PathVariable Long filiereId, @RequestBody EtudiantDTO etudiantDTO) throws Exception {
	    FiliereDTO updatedFiliere = service.addEtudiantToFiliere(filiereId, etudiantDTO);
	    FiliereResponse response = new FiliereResponse();
	    BeanUtils.copyProperties(updatedFiliere, response);
	    return response;
	}
	
	@GetMapping("/get")
	public List<FiliereResponse> getAllFilieres() {
	    List<FiliereDTO> dtos = service.getAllFilieres();
	    List<FiliereResponse> responses = new ArrayList<>();

	    for (FiliereDTO dto : dtos) {
	        FiliereResponse response = new FiliereResponse();
	        BeanUtils.copyProperties(dto, response);
	        responses.add(response);
	    }
	    return responses;
	}
	
	
	@GetMapping("/{id}")
	public FiliereResponse getFilById(@PathVariable long id) {
	    FiliereDTO dto = service.getFilierebyId(id);
	    FiliereResponse adResp = FiliereResponse.builder().build();
	    BeanUtils.copyProperties(dto, adResp);
	    return adResp;
	}

	/*@GetMapping("/{id}")		
	public FiliereResponse getFilById(@PathVariable long id) throws ClassNotFoundException {
	    FiliereDTO dto = service.getFilierebyId(id);
	    FiliereResponse adResp = FiliereResponse.builder().build();
	    BeanUtils.copyProperties(dto, adResp);
	    List<EtudiantDTO> etudiants = service.getEtudiantsByFiliereId(id);
	    if (etudiants != null) {
	        adResp.setEtudiants(etudiants);
	    }
	    return adResp;
	}
		*/
	@GetMapping("/get/{id}")
	public FiliereResponse getFilById1(@PathVariable long id) throws ClassNotFoundException {
	    FiliereDTO dto = service.getFilierebyId(id);
	    FiliereResponse filiereResp = new FiliereResponse();
	    BeanUtils.copyProperties(dto, filiereResp);
	    List<EtudiantDTO> etudiants = service.getEtudiantsByFiliereId(id);
	    filiereResp.setEtudiants(etudiants);
	    return filiereResp;
	}
		
	
	
	
	
		@DeleteMapping("/delete/{id}")
		public void deleteFilById(@PathVariable long id) {
		    service.deleteFiliere(id);
		    
		}
		@PutMapping("/update/{id}")
		public FiliereResponse updateFilById(@PathVariable long id, @RequestBody FiliereRequest request) {
		    FiliereDTO dto = service.getFilierebyId(id);
		    BeanUtils.copyProperties(request, dto);
		    FiliereDTO updatedDto = service.updateFiliere(dto);
		    FiliereResponse response = FiliereResponse.builder().build();
		    BeanUtils.copyProperties(updatedDto, response);
		    return response;
		}
}