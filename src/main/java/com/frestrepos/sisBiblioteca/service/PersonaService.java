package com.frestrepos.sisBiblioteca.service;


import com.frestrepos.sisBiblioteca.model.Persona;
import com.frestrepos.sisBiblioteca.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> obtenerTodasLasPersonas() {
        return personaRepository.findAll();
    }

    public Optional<Persona> obtenerPersonaPorId(Long id) {
        return personaRepository.findById(id);
    }

    public Persona guardarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id);
    }
}
