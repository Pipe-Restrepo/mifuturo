package com.frestrepos.sisBiblioteca.controllers;


import com.frestrepos.sisBiblioteca.model.Bibliotecario;
import com.frestrepos.sisBiblioteca.service.BibliotecarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bibliotecario")
public class BibliotecarioController {
    private final BibliotecarioService bibliotecarioService;

    @Autowired
    public BibliotecarioController(BibliotecarioService bibliotecarioService) {
        this.bibliotecarioService = bibliotecarioService;
    }

    @GetMapping
    public List<Bibliotecario> obtenerTodosLosBibliotecarios() {
        return bibliotecarioService.obtenerTodosLosBibliotecarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bibliotecario> obtenerBibliotecarioPorId(@PathVariable Long id) {
        Optional<Bibliotecario> bibliotecario = bibliotecarioService.obtenerBibliotecarioPorId(id);
        return bibliotecario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscarPorTurno")
    public List<Bibliotecario> obtenerBibliotecariosPorTurno(@RequestParam String turno) {
        return bibliotecarioService.obtenerBibliotecariosPorTurno(turno);
    }

    @PostMapping
    public Bibliotecario guardarBibliotecario(@RequestBody Bibliotecario bibliotecario) {
        return bibliotecarioService.guardarBibliotecario(bibliotecario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bibliotecario> actualizarBibliotecario(@PathVariable Long id, @RequestBody Bibliotecario bibliotecarioDetalles) {
        Optional<Bibliotecario> bibliotecario = bibliotecarioService.obtenerBibliotecarioPorId(id);
        if (bibliotecario.isPresent()) {
            bibliotecarioDetalles.setId(id);
            return ResponseEntity.ok(bibliotecarioService.guardarBibliotecario(bibliotecarioDetalles));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarBibliotecario(@PathVariable Long id) {
        bibliotecarioService.eliminarBibliotecario(id);
        return ResponseEntity.noContent().build();
    }
}
