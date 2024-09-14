package com.biblioteca.interfaces;

import com.biblioteca.modelos.Libro;
import com.biblioteca.modelos.Usuario;

public interface Biblioteca {
        void prestarLibro(Libro libro, Usuario usuario);
        void devolverLibro(Libro libro, Usuario usuario);
}
