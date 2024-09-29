package org.biblioteca.sql;

import org.biblioteca.sql.Libro;
import org.biblioteca.sql.Usuario;

public interface Biblioteca {
    void prestarLibro(Libro libro, Usuario usuario);
    void devolverLibro(Libro libro, Usuario usuario);
    void agregarLibro(Libro libro);
    void actualizarLibro(Libro libro);
    void eliminarLibro(Libro libro);
    void agregarUsuario(Usuario usuario);
    void actualizarUsuario(Usuario usuario);
    void eliminarUsuario(Usuario usuario);
}