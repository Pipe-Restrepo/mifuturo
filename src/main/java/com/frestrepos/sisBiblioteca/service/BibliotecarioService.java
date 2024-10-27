package com.frestrepos.sisBiblioteca.service;


import com.frestrepos.sisBiblioteca.model.Bibliotecario;
import com.frestrepos.sisBiblioteca.repository.BibliotecarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BibliotecarioService {
    private final BibliotecarioRepository bibliotecarioRepository;

    @Autowired
    public BibliotecarioService(BibliotecarioRepository bibliotecarioRepository) {
        this.bibliotecarioRepository = bibliotecarioRepository;
    }

    public List<Bibliotecario> obtenerTodosLosBibliotecarios() {
        return bibliotecarioRepository.findAll();
    }

    public Optional<Bibliotecario> obtenerBibliotecarioPorId(Long id) {
        return bibliotecarioRepository.findById(id);
    }

    public List<Bibliotecario> obtenerBibliotecariosPorTurno(String turno) {
        return bibliotecarioRepository.findByTurno(turno);
    }

    public Bibliotecario guardarBibliotecario(Bibliotecario bibliotecario) {
        return bibliotecarioRepository.save(bibliotecario);
    }

    public void eliminarBibliotecario(Long id) {
        bibliotecarioRepository.deleteById(id);
    }
}
