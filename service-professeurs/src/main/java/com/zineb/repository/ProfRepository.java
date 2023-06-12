package com.zineb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zineb.model.Professeur;

@Repository
public interface ProfRepository extends JpaRepository<Professeur, Integer> {

}
