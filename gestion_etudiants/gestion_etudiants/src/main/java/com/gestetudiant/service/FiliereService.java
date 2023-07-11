package com.gestetudiant.service;


import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestetudiant.dto.EtudiantDTO;
import com.gestetudiant.dto.FiliereDTO;
@Service
public interface FiliereService {
	@Autowired
	FiliereDTO addFiliere(FiliereDTO  f);
	
	FiliereDTO  getFilierebyId(long id);
	
    FiliereDTO updateFiliere(FiliereDTO f);
    
    public boolean deleteFiliere(long id);

    List<FiliereDTO> getAllFilieres();

    FiliereDTO addEtudiantToFiliere(Long filiereId, EtudiantDTO etudiantDTO) throws ClassNotFoundException, AttributeNotFoundException ;
	List<EtudiantDTO> getEtudiantsByFiliereId(Long filiereId) throws ClassNotFoundException;
}
