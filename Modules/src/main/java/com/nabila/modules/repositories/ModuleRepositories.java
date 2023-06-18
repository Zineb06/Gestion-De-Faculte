package com.nabila.modules.repositories;

import com.nabila.modules.entities.Module;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepositories extends JpaRepository<Module,Long> {
    Page<Module> findByNomCour(String kw, Pageable pageable);
}
