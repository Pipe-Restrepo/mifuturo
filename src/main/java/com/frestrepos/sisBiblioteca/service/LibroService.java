package com.frestrepos.sisBiblioteca.service;


import com.frestrepos.sisBiblioteca.model.Libro;
import com.frestrepos.sisBiblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    private final LibroRepository libroRepository;

    @Autowired
    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> obtenerTodosLosLibros() {
        return libroRepository.findAll();
    }

    public Optional<Libro> obtenerLibroPorId(Long id) {
        return libroRepository.findById(id);
    }

    public List<Libro> obtenerLibrosPorTitulo(String titulo) {
        return libroRepository.findByTitulo(titulo);
    }

    public List<Libro> obtenerLibrosPorAutor(String autor) {
        return libroRepository.findByAutor(autor);
    }

    public Optional<Libro> obtenerLibroPorIsbn(String isbn) {
        return Optional.ofNullable(libroRepository.findByIsbn(isbn));
    }

    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }

    public void actualizarDisponibilidad(Long id, boolean disponibilidad) {
        Optional<Libro> libroOpt = libroRepository.findById(id);
        if (libroOpt.isPresent()) {
            Libro libro = libroOpt.get();
            libro.setDisponibilidad(disponibilidad);
            libroRepository.save(libro);
        }
    }
}
