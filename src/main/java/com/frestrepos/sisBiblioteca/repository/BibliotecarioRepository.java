package com.frestrepos.sisBiblioteca.repository;

import com.frestrepos.sisBiblioteca.model.Bibliotecario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BibliotecarioRepository extends JpaRepository<Bibliotecario, Long> {
    List<Bibliotecario> findByTurno(String turno);
}
