package com.frestrepos.sisBiblioteca.repository;

import com.frestrepos.sisBiblioteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    List<Usuario> findByNombre(String nombre);
}
