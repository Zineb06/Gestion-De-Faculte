package com.gestetudiant.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.gestetudiant.dao.FiliereDao;
import com.gestetudiant.dto.EtudiantDTO;
import com.gestetudiant.dto.FiliereDTO;
import com.gestetudiant.model.Etudiant;
import com.gestetudiant.model.Filiere;

@Service
public class FiliereServiceImpl implements FiliereService {
	@Autowired
	FiliereDao dao;
	@Autowired
	EtudiantService es;
	
	@Override
	public List<FiliereDTO> getAllFilieres() {
	    List<Filiere> filieres = dao.findAll();
	    List<FiliereDTO> dtos = new ArrayList<>();

	    for (Filiere f : filieres) {
	        FiliereDTO dto = new FiliereDTO();
	        BeanUtils.copyProperties(f, dto);
	        dtos.add(dto);}
	        return dtos;
	    
	    }
	   
	

	public FiliereDTO addFiliere(FiliereDTO f) {
		FiliereDTO dto = FiliereDTO.builder().build();
		Filiere fi = new Filiere();
		BeanUtils.copyProperties(f, fi);
		Filiere f1  = dao.save(fi);
		BeanUtils.copyProperties(f1, dto);
		return dto;
	}
	
	@Override
	public FiliereDTO addEtudiantToFiliere(Long filiereId, EtudiantDTO etudiantDTO) throws ClassNotFoundException, AttributeNotFoundException {
	    FiliereDTO filiereDTO = getFilierebyId(filiereId);
	    if (filiereDTO == null) {
	        throw new ResourceNotFoundException("Filiere not found with id " + filiereId);
	    }
	    EtudiantDTO addedEtudiant = es.addEtudiant(etudiantDTO, filiereId);
	    filiereDTO.getEtudiants().add(addedEtudiant);
	    return updateFiliere(filiereDTO);
	}
	

	@Override
	
	public FiliereDTO  getFilierebyId(long id) {
		FiliereDTO dto = FiliereDTO.builder().build();
		Filiere fi = dao.findById(id).get();
		BeanUtils.copyProperties(fi, dto);
		return dto;
	}
@Override
	public FiliereDTO updateFiliere(FiliereDTO f) {
		FiliereDTO dto = FiliereDTO.builder().build();
	    Optional<Filiere> optionalfi = dao.findById(f.getId());
	    
	    if (optionalfi.isPresent()) {
	        Filiere fil = optionalfi.get();
	        BeanUtils.copyProperties(f, fil);
	        Filiere updatedFil = dao.save(fil);
	        BeanUtils.copyProperties(updatedFil, dto);
	    } else {
	        // handle error - object not found
	    }
	    
	    return dto;
	}

	@Override
	public boolean deleteFiliere(long id) {
		 Optional<Filiere> optionalfi = dao.findById(id);
		    
		    if (optionalfi.isPresent()) {
		        dao.delete(optionalfi.get());
		        return true;
		    } else {
		        return false;
		    }
	}
	
	
	
	

   /* @Override
    public List<EtudiantDTO> getEtudiantsByFiliereId(Long filiereId) throws ClassNotFoundException {
        Filiere filiere = dao.findById(filiereId).orElseThrow(() -> new ClassNotFoundException("Filiere not found"));
        List<Etudiant> etudiants = new ArrayList<>(filiere.getEtudiants());
        List<EtudiantDTO> etudiantDTOs = new ArrayList<>();
        for (Etudiant etudiant : etudiants) {
            EtudiantDTO etudiantDTO = new EtudiantDTO();
            BeanUtils.copyProperties(etudiant, etudiantDTO);
            etudiantDTO.setFiliere(filiere.getNom());
            etudiantDTOs.add(etudiantDTO);
        }
        return etudiantDTOs;
    }
    
*/
	public List<EtudiantDTO> getEtudiantsByFiliereId(Long filiereId) throws ClassNotFoundException {
	    Filiere filiere = dao.findById(filiereId).orElseThrow(() -> new ClassNotFoundException("Filiere not found"));
	    List<Etudiant> etudiants = new ArrayList<>(filiere.getEtudiants());
	    List<EtudiantDTO> etudiantDTOs = new ArrayList<>();
	    for (Etudiant etudiant : etudiants) {
	        EtudiantDTO etudiantDTO = new EtudiantDTO();
	        BeanUtils.copyProperties(etudiant, etudiantDTO);
	        etudiantDTO.setFiliere(filiere.getNom());
	        etudiantDTOs.add(etudiantDTO);
	    }
	    return etudiantDTOs;
	}



}
