package com.BIlham.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BIlham.model.Note;
@Repository
public interface NotDao extends JpaRepository<Note,Integer> {
	//ce qui ajouter pour chercher Appoge
	
    
    
    List<Note> findByNote(double note);
    List<Note> findByApogeeEtudiant(int apogeeEtudiant);
    List<Note> findByNomEtudiant(String nomEtudiant);
}
