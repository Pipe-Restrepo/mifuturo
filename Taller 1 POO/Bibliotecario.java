package com.biblioteca.modelos;

//1. Se crea la clase extendida Bibliotecario y se importa la interfaz llamada Géstion

import com.biblioteca.interfaces.Biblioteca;

class Bibliotecario extends Persona implements Biblioteca {
    public Bibliotecario(String nombre, String apellido, int idBibliotecario) {
        super(nombre, apellido);
        this.idBibliotecario = idBibliotecario;
    }

//2. Aqui se llama mediante una anotación la información del Bibliotecario incluyendo un id personal
    @Override
    public void mostrarDatos() {
        System.out.println("Nombre y Apellido: " + nombre + " " + apellido);
        System.out.println("Codigo de Usuario: " + idBibliotecario);
    }

//3. Estas lineas sobrecarga la clase bibliotecario con el metodo prestar libro
    @Override
    public void prestarLibro(Libro libro, Usuario usuario) {
        if (libro.isDisponible()) {
            if (usuario.getLibrosPrestados() < 2) {
                libro.prestar();
                usuario.incrementarPrestamos();
                System.out.println("El libro '" + libro.getTitulo() + "' El libro ha sido prestado a " + usuario.getNombre());
            } else {
                System.out.println("El usuario " + usuario.getNombre() + " ya ha alcanzado el límite de préstamos del mes");
            }
        } else {
                System.out.println("El libro '" + libro.getTitulo() + "' ya no está disponible para prestamo");
            }
        }

//4. Estas lineas sobrecarga la clase bibliotecario con el metodo devolver libro
    @Override
    public void devolverLibro(Libro libro, Usuario usuario) {
        if (!libro.isDisponible()) {
            libro.devolverLibro();
            usuario.decrementarPrestamos();
            System.out.println("El libro '" + libro.getTitulo() + "' ya ha sido devuelto por " + usuario.getNombre());
        } else {
            System.out.println("El libro '" + libro.getTitulo() + "' ya está en la biblioteca y disponible para prestar");
        }
    }
}

