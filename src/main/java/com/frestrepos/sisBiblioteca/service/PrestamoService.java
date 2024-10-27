package com.frestrepos.sisBiblioteca.service;


import com.frestrepos.sisBiblioteca.model.Prestamo;
import com.frestrepos.sisBiblioteca.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PrestamoService {
    private final PrestamoRepository prestamoRepository;
    private final LibroService libroService;

    @Autowired
    public PrestamoService(PrestamoRepository prestamoRepository, LibroService libroService) {
        this.prestamoRepository = prestamoRepository;
        this.libroService = libroService;
    }

    public List<Prestamo> obtenerTodosLosPrestamos() {
        return prestamoRepository.findAll();
    }

    public Optional<Prestamo> obtenerPrestamoPorId(Long id) {
        return prestamoRepository.findById(id);
    }

    public List<Prestamo> obtenerPrestamosPorUsuario(Long usuarioId) {
        return prestamoRepository.findByUsuarioId(usuarioId);
    }

    public List<Prestamo> obtenerPrestamosPorFechaPrestamo(LocalDate fechaPrestamo) {
        return prestamoRepository.findByFechaPrestamo(fechaPrestamo);
    }

    public List<Prestamo> obtenerPrestamosPendientes(LocalDate fechaActual) {
        return prestamoRepository.findByFechaDevolucionAfter(fechaActual);
    }

    public Prestamo guardarPrestamo(Prestamo prestamo) {
        libroService.actualizarDisponibilidad(prestamo.getUsuario().getId(), false);
        return prestamoRepository.save(prestamo);
    }

    public void eliminarPrestamo(Long id) {
        Optional<Prestamo> prestamo = prestamoRepository.findById(id);
        if (prestamo.isPresent()) {
            libroService.actualizarDisponibilidad(prestamo.get().getUsuario().getId(), true);
            prestamoRepository.deleteById(id);
        }
    }
}
