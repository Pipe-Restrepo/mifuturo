package com.frestrepos.sisBiblioteca.controllers;


import com.frestrepos.sisBiblioteca.model.Persona;
import com.frestrepos.sisBiblioteca.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    private final PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public List<Persona> obtenerTodasLasPersonas() {
        return personaService.obtenerTodasLasPersonas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable Long id) {
        Optional<Persona> persona = personaService.obtenerPersonaPorId(id);
        return persona.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Persona guardarPersona(@RequestBody Persona persona) {
        return personaService.guardarPersona(persona);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Long id, @RequestBody Persona personaDetalles) {
        Optional<Persona> persona = personaService.obtenerPersonaPorId(id);
        if (persona.isPresent()) {
            personaDetalles.setId(id);
            return ResponseEntity.ok(personaService.guardarPersona(personaDetalles));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable Long id) {
        personaService.eliminarPersona(id);
        return ResponseEntity.noContent().build();
    }
}
