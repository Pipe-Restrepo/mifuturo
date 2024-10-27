package com.frestrepos.sisBiblioteca.controllers;


import com.frestrepos.sisBiblioteca.model.Libro;
import com.frestrepos.sisBiblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class LibroController {
    private final LibroService libroService;

    @Autowired
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<Libro> obtenerTodosLosLibros() {
        return libroService.obtenerTodosLosLibros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerLibroPorId(@PathVariable Long id) {
        Optional<Libro> libro = libroService.obtenerLibroPorId(id);
        return libro.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscarPorTitulo")
    public List<Libro> obtenerLibrosPorTitulo(@RequestParam String titulo) {
        return libroService.obtenerLibrosPorTitulo(titulo);
    }

    @GetMapping("/buscarPorAutor")
    public List<Libro> obtenerLibrosPorAutor(@RequestParam String autor) {
        return libroService.obtenerLibrosPorAutor(autor);
    }

    @GetMapping("/buscarPorIsbn")
    public ResponseEntity<Libro> obtenerLibroPorIsbn(@RequestParam String isbn) {
        Optional<Libro> libro = libroService.obtenerLibroPorIsbn(isbn);
        return libro.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Libro guardarLibro(@RequestBody Libro libro) {
        return libroService.guardarLibro(libro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Long id, @RequestBody Libro libroDetalles) {
        Optional<Libro> libro = libroService.obtenerLibroPorId(id);
        if (libro.isPresent()) {
            libroDetalles.setId(id);
            return ResponseEntity.ok(libroService.guardarLibro(libroDetalles));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
