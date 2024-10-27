package com.frestrepos.sisBiblioteca.repository;

import com.frestrepos.sisBiblioteca.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long>{
}
