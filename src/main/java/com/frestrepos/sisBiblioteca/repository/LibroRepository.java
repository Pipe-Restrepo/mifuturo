package com.frestrepos.sisBiblioteca.repository;

import com.frestrepos.sisBiblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long>{
    List<Libro> findByTitulo(String titulo);
    List<Libro> findByAutor(String autor);
    Libro findByIsbn(String isbn);
}