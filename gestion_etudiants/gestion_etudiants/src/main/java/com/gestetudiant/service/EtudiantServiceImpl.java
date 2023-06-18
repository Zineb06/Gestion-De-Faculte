package com.gestetudiant.service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestetudiant.model.*;

import com.gestetudiant.dao.*;
import com.gestetudiant.dto.EtudiantDTO;
import com.gestetudiant.dto.FiliereDTO;
@Service
public class EtudiantServiceImpl  implements EtudiantService{

	@Autowired
	EtudiantDao dao;
	@Autowired
    FiliereDao daof;
	
    @Override
	public List<EtudiantDTO> getAllEtudiants() {
	    List<Etudiant> etudiants = dao.findAll();
	    List<EtudiantDTO> dtos = new ArrayList<>();
	    for (Etudiant e : etudiants) {
	        Filiere filiere = e.getFiliere();
	        String nomFiliere = filiere != null ? filiere.getNom() : null;
	        EtudiantDTO dto = EtudiantDTO.builder().build();
	        BeanUtils.copyProperties(e, dto);
	        dto.setFiliere(nomFiliere);
	        dtos.add(dto);
	    }
	    return dtos;
	}
	
	
    @Override
	public EtudiantDTO getEtudiantbyId(long id) {
		EtudiantDTO dto = EtudiantDTO.builder().build();
		Etudiant e = dao.findById(id).get();
		Filiere filiere = e.getFiliere();
	    String nomFiliere = filiere != null ? filiere.getNom() : null;
	    BeanUtils.copyProperties(e, dto);
	    dto.setFiliere(nomFiliere);
		BeanUtils.copyProperties(e, dto);
		return dto;
	}

    /*public EtudiantDTO addEtudiant(EtudiantDTO etudiantDTO, Long filiereId) throws ClassNotFoundException, AttributeNotFoundException {
    	  Filiere filiere = daof.findById(filiereId)
          		.orElseThrow(() -> new AttributeNotFoundException("La filière avec l'ID " + filiereId + " n'existe pas."));
        // Créer un objet Etudiant à partir des données reçues
        Etudiant etudiant = new Etudiant();
        BeanUtils.copyProperties(etudiantDTO, etudiant);

        // Ajouter l'étudiant à la filière
        filiere.getEtudiants().add(etudiant);

        // Enregistrer les modifications
        daof.save(filiere);

        // Renvoyer l'étudiant ajouté
        return etudiantDTO;
    }*/

    public EtudiantDTO addEtudiant(EtudiantDTO etudiantDTO, Long filiereId) throws ClassNotFoundException, AttributeNotFoundException {
        Filiere filiere = daof.findById(filiereId)
                .orElseThrow(() -> new AttributeNotFoundException("Filiere not found with id " + filiereId));
        Etudiant etudiant = new Etudiant();
        BeanUtils.copyProperties(etudiantDTO, etudiant);
        etudiant.setFiliere(filiere);
        Etudiant savedEtudiant = dao.save(etudiant);
        EtudiantDTO savedEtudiantDTO = new EtudiantDTO();
        BeanUtils.copyProperties(savedEtudiant, savedEtudiantDTO);
        return savedEtudiantDTO;
    }
 
   /* public EtudiantDTO addEtudiant(EtudiantDTO etudiant, Long filiereId)throws ClassNotFoundException, AttributeNotFoundException {
    	EtudiantDTO dto = EtudiantDTO.builder().build();
    	Etudiant e = new Etudiant();
		BeanUtils.copyProperties(etudiant, e);
        // Vérifier si la filière existe
        Filiere filiere = daof.findById(filiereId)
        		.orElseThrow(() -> new AttributeNotFoundException("La filière avec l'ID " + filiereId + " n'existe pas."));

        // Affecter la filière à l'étudiant
        e.setFiliere(filiere);
            

        // Affecter la filière à l'étudiant
        e.setFiliere(filiere);

        // Enregistrer l'étudiant dans la base de données
        Etudiant e1 = dao.save(e);
    	BeanUtils.copyProperties(e1, dto);
		return dto;
    }
*/
	/*public EtudiantDTO  addEtudiant(EtudiantDTO etudiant) {
		EtudiantDTO dto = EtudiantDTO.builder().build();
		Etudiant fi = new Etudiant();
		BeanUtils.copyProperties(etudiant, fi);
		Etudiant f1  = dao.save(fi);
		BeanUtils.copyProperties(f1, dto);
		return dto;
	}*/

	/*@Override
	public EtudiantDTO updateEtudiant(Long id, EtudiantDTO etudiantDTO, Long filiereId) throws AttributeNotFoundException {
	    Etudiant etudiant = dao.findById(id)
	            .orElseThrow(() -> new AttributeNotFoundException("L'étudiant avec l'ID " + id + " n'existe pas."));

	    BeanUtils.copyProperties(etudiantDTO, etudiant);
	    
	    // Vérifier si la filière existe
	    Filiere filiere = daof.findById(filiereId)
	            .orElseThrow(() -> new AttributeNotFoundException("La filière avec l'ID " + filiereId + " n'existe pas."));

	    // Affecter la filière à l'étudiant
	    etudiant.setFiliere(filiere);

	    dao.save(etudiant);
	    
	    return etudiantDTO;
	}
*/
    
    
    @Override
    
    public EtudiantDTO updateEtudiant(EtudiantDTO dto) {
        Optional<Etudiant> optionalEtudiant = dao.findById(dto.getId());
        if (optionalEtudiant.isPresent()) {
            Etudiant existingEtudiant = optionalEtudiant.get();
            BeanUtils.copyProperties(dto, existingEtudiant);
            Etudiant updatedEtudiant = dao.save(existingEtudiant);
            EtudiantDTO updatedDto = EtudiantDTO.builder().build();
            BeanUtils.copyProperties(updatedEtudiant, updatedDto);
      
        } else {
            // handle error - object not found
        }
        return dto;
    }
    
    
    
    
    
   /* @Override
    public EtudiantDTO updateEtudiant(Long id, EtudiantDTO etudiant) {
        EtudiantDTO dto = EtudiantDTO.builder().build();
        Optional<Etudiant> optionalEtudiant = dao.findById(id);

        if (optionalEtudiant.isPresent()) {
            Etudiant existingEtudiant = optionalEtudiant.get();
            existingEtudiant.setNom(etudiant.getNom());
            existingEtudiant.setPrenom(etudiant.getPrenom());
            existingEtudiant.setDateNaissance(etudiant.getDateNaissance());
            existingEtudiant.setCne(etudiant.getCne());
            existingEtudiant.setCin(etudiant.getCin());
            existingEtudiant.setNumapp(etudiant.getNumapp());
            existingEtudiant.setNiveau(etudiant.getNiveau());
            BeanUtils.copyProperties(etudiant, existingEtudiant);
            Etudiant updatedEtudiant = dao.save(existingEtudiant);
            BeanUtils.copyProperties(updatedEtudiant, dto);
        } else {
            // handle error - object not found
        }

        return dto;
    }
    
    
  */

	
	@Override
	public boolean deleteEtudiant(long id) {
	    Optional<Etudiant> optionalEt = dao.findById(id);
	    
	    if (optionalEt.isPresent()) {
	        dao.delete(optionalEt.get());
	        return true;
	    } else {
	        return false;
	    }
	}


}