
package com.gestetudiant.controller;

import java.util.List;
import java.util.ArrayList;
import javax.management.AttributeNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestetudiant.Request.FiliereRequest;
import com.gestetudiant.Response.EtudiantResponse;
import com.gestetudiant.Response.FiliereResponse;
import com.gestetudiant.dto.EtudiantDTO;
import com.gestetudiant.dto.FiliereDTO;
import com.gestetudiant.service.EtudiantService;
import com.gestetudiant.service.FiliereService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/etudiants")
public class EtudiantController {
	@Autowired
	EtudiantService service;
	@Autowired
	FiliereService filiere;
		
	
	@GetMapping
	public List<EtudiantResponse> getAllEtudiants() {
	    List<EtudiantDTO> etudiantDTOs = service.getAllEtudiants();
	    List<EtudiantResponse> etudiantResponses = new ArrayList<>();
	    for (EtudiantDTO etudiantDTO : etudiantDTOs) {
	        EtudiantResponse etudiantResponse = EtudiantResponse.builder().build();
	        BeanUtils.copyProperties(etudiantDTO, etudiantResponse);
	        etudiantResponses.add(etudiantResponse);
	    }
	    return etudiantResponses;
	}
	
	
	 /*@PostMapping
	    public EtudiantResponse addEtudiant(@RequestBody EtudiantDTO etudiantDTO,
	            @RequestParam Long filiereId) throws ClassNotFoundException, AttributeNotFoundException {
		   EtudiantResponse response = EtudiantResponse.builder().build();
		    
	        EtudiantDTO addedEtudiant = service.addEtudiant(etudiantDTO, filiereId);
	        BeanUtils.copyProperties(addedEtudiant, response);
	        return response;
	    }
	 */
	
	
	  
	/*@PostMapping
	 public EtudiantResponse addEtudiant(@RequestBody EtudiantDTO request) {
		EtudiantResponse response = EtudiantResponse.builder().build();
		EtudiantDTO dto = EtudiantDTO.builder().build();
	    BeanUtils.copyProperties(request, dto);
	    EtudiantDTO savedDto = service.addEtudiant(dto);
	    BeanUtils.copyProperties(savedDto, response);
	    return response;
	}*/
	
	
		@GetMapping("/{id}")
		public EtudiantResponse getEtudiantById(@PathVariable long id) {
			EtudiantDTO dto = service.getEtudiantbyId(id);
			EtudiantResponse adResp = EtudiantResponse.builder().build();
			BeanUtils.copyProperties(dto, adResp);
			return adResp;
		}
		/*@PutMapping("/{id}")
		public EtudiantResponse updateEtudiant(@PathVariable Long id, @RequestBody EtudiantDTO etudiantDTO, @RequestParam Long filiereId) throws AttributeNotFoundException {
		    EtudiantResponse response = EtudiantResponse.builder().build();
		    EtudiantDTO updatedEtudiant = service.updateEtudiant(id, etudiantDTO, filiereId);
		    BeanUtils.copyProperties(updatedEtudiant, response);
		    
		    return response;
		}
		*/
		@PutMapping("/update/{id}")
		
		public EtudiantResponse updateEtudiant(@PathVariable Long id, @RequestBody EtudiantDTO  request) {
		    EtudiantDTO dto = service.getEtudiantbyId(id);
		    // Copie toutes les propriétés sauf l'ID
		    BeanUtils.copyProperties(request, dto, "id");
		    EtudiantDTO updatedDto = service.updateEtudiant(dto);
		    EtudiantResponse response = EtudiantResponse.builder().build();
		    BeanUtils.copyProperties(updatedDto, response);
		    return response;
		}
		
		
		@DeleteMapping("/{id}")
		public void deleteEtudiantById(@PathVariable long id) {
		    service.deleteEtudiant(id);
		}
		
		
	}