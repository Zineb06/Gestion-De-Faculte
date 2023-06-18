package com.gestetudiant.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestetudiant.dto.EtudiantDTO;
import com.gestetudiant.model.Etudiant;

public interface EtudiantDao extends JpaRepository<Etudiant, Long>{
public List<Etudiant> findByNomContains(String nom);
List<Etudiant> findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCaseOrNumappContainingIgnoreCase(String nom, String prenom, String numapp);

}
