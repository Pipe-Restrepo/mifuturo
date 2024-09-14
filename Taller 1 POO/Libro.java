package com.biblioteca.modelos;

//Encapsulamiento

//1. Se crea la clase libro con sus atributos privados

public class Libro {

    private String titulo;
    private String autor;
    private int isbn;
    private boolean disponible;

//2. Se crea el constructor para inicializar cada uno de los atributos

    public Libro(String titulo, String autor, int isbn, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponible = true; // Aqui se modifica la disponibilidad true o false para probar funcionamiento del metodo
    }

//3. Aqui se implementan los metodos getter y setter para llamar los atributos

// Metodo getter titulo
    public String getTitulo() {
        return titulo;
    }

// Metodo setter titulo
    public void setTitulo() {
        this.titulo = titulo;
    }

// Metodo getter autor
    public String getAutor() {
        return autor;
    }

// Metodo setter autor
    public void setAutor() {
        this.autor = autor;
    }

// Metodo getter isbn
    public int getIsbn() {
        return isbn;
    }

// Metodo setter isbn
    public void setIsbn() {
        this.isbn = isbn;
    }

// Metodo getter disponible
    public boolean isDisponible() {
        return disponible;
    }

// Metodo setter disponible con control interno de disponibilidad
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

//4. Metodo para mostrar información del libro
    public void mostrarInformacion() {
        System.out.println("Título del Libro: " + titulo);
        System.out.println("Autor del Libro: " + autor);
        System.out.println("ISBN Interno: " + isbn);
        System.out.println("Disponibilidad del libro: " + (disponible ? "Sí" : "No"));
    }

//5. Se crea el metodo prestar
    public void prestarLibro() {
        if (disponible) {
            setDisponible(false);
            System.out.println("Libro prestado con exito: " + titulo);
        } else {
            System.out.println("El libro no está disponible para prestar");
        }
    }

    public void prestar() {
    }

//6. Se crea el metodo devolver
    public void devolverLibro() {
    setDisponible(true);
    System.out.println("Libro devuelto con exito: " + titulo);
    }
}
