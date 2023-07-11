package com.gestetudiant.service;




import java.util.Collection;
import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.stereotype.Service;

import com.gestetudiant.dto.EtudiantDTO;
import com.gestetudiant.model.Etudiant;
@Service
public interface EtudiantService {

	EtudiantDTO getEtudiantbyId(long id);
	
//	public EtudiantDTO updateEtudiant(Long id, EtudiantDTO etudiantDTO, Long filiereId) throws AttributeNotFoundException;
	
    boolean deleteEtudiant(long id);


	
    EtudiantDTO addEtudiant(EtudiantDTO etudiant, Long filiereId)
			throws ClassNotFoundException, AttributeNotFoundException;

	List<EtudiantDTO> getAllEtudiants();

	EtudiantDTO updateEtudiant(EtudiantDTO etudiant);




	
}
