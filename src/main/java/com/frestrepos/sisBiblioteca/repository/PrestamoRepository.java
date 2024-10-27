package com.frestrepos.sisBiblioteca.repository;

import com.frestrepos.sisBiblioteca.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    List<Prestamo> findByUsuarioId(Long usuarioId);
    List<Prestamo> findByFechaPrestamo(LocalDate fechaPrestamo);
    List<Prestamo> findByFechaDevolucionAfter(LocalDate fecha);
}
