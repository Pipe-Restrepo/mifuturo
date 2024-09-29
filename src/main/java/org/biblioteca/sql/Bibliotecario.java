package org.biblioteca.sql;

//1. Se crea la clase extendida Bibliotecario y se importa la interfaz llamada Géstion

import org.biblioteca.sql.Libro;
import org.biblioteca.sql.Persona;

    public class Bibliotecario extends Persona implements Biblioteca {
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

    @Override
    public void agregarUsuario(Libro libro) {

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

    public void devolverLibro(Libro libro, Usuario usuario) {
        if (!libro.isDisponible()) {
            libro.devolverLibro();
            usuario.decrementarPrestamos();
            System.out.println("El libro '" + libro.getTitulo() + "' ya ha sido devuelto por " + usuario.getNombre());
        } else {
            System.out.println("El libro '" + libro.getTitulo() + "' ya está en la biblioteca y disponible para prestar");
        }
    }

    //5. Metodos para agregar, actualizar y eliminar libros y usuarios usuario

    public void agregarLibro(Libro libro) {
        System.out.println("El libro '" + libro.getTitulo() + "' libro agregado correctamente");
    }

    public void actualizarLibro(Libro libro) {
        System.out.println("El libro '" + libro.getTitulo() + "' libro actualizado correctamente");
    }

    public void eliminarLibro(Libro libro) {
        System.out.println("El libro '" + libro.getTitulo() + "' libro eliminado correctamente");
    }


    public void agregarUsuario(Usuario usuario) {
        System.out.println("Usuario '" + Usuario.getid() + "' usuario agregado correctamente");
    }

        @Override
        public void actualizarUsuario(Usuario usuario) {
            System.out.println("Usuario '" + Usuario.getid() + "' usuario actualizado correctamente");
        }

        @Override
        public void eliminarUsuario(Usuario usuario) {
            System.out.println("Usuario '" + Usuario.getid() + "' usuario eliminado correctamente");
        }
    }
