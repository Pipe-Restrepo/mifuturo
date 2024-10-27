package com.frestrepos.sisBiblioteca.controllers;


import com.frestrepos.sisBiblioteca.model.Prestamo;
import com.frestrepos.sisBiblioteca.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prestamo")
public class PrestamoController {
    private final PrestamoService prestamoService;

    @Autowired
    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @GetMapping
    public List<Prestamo> obtenerTodosLosPrestamos() {
        return prestamoService.obtenerTodosLosPrestamos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> obtenerPrestamoPorId(@PathVariable Long id) {
        Optional<Prestamo> prest;
        return null;
    }
}