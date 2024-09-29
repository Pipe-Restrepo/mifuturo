package org.biblioteca.sql;

//1. Se importan librerias para crear y almacenar lista de libros

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Se crea el objeto llamado Usuario, llamando la clase extendida
        Usuario usuario = new Usuario("Tobias", "Arango", 10);
        Usuario usuario1 = new Usuario("Nino", "Bravo", 11);

        // Se imprimen datos del usuario
        System.out.println("Información del Usuario:");
        usuario.mostrarDatos();

        System.out.println("-----------Check Point-------------");

        // Se crea un objeto llamado Bibliotecario
        Bibliotecario bibliotecario = new Bibliotecario("Carmelo", "Santana", 1025024023);

        // Mostrar datos del bibliotecario
        System.out.println("Información del Bibliotecario:");
        bibliotecario.mostrarDatos();

        System.out.println("-----------Check Point-------------");

        // Se crean instancias de libros para verificar llamado del metodo
        Libro libroI = new Libro("El Principito", "Antoine de Saint-Exupéry", 97897998, false);
        Libro libroII = new Libro("Crimen y castigo", "Fiódor Dostoyevski", 97897999, false);
        Libro libroIII = new Libro("Un mundo feliz", "Aldous Huxley", 97897997, false);
        Libro libroIV = new Libro("Odisea", "Homero", 97897996, false);

        //Se crea lista de libros de la biblioteca
        List<Libro> listaLibros = new ArrayList<>();
        listaLibros.add(libroI);
        listaLibros.add(libroII);
        listaLibros.add(libroIII);
        listaLibros.add(libroIV);

        // Estas lineas simulan préstamos de usuarios y muestra limite de prestamos
        bibliotecario.prestarLibro(libroI, usuario);
        bibliotecario.prestarLibro(libroII, usuario);
        bibliotecario.prestarLibro(libroIII, usuario1);
        bibliotecario.prestarLibro(libroIV, usuario1);

        System.out.println("-----------Check Point-------------");

        // Estas lineas simulan devolución de libros
        bibliotecario.devolverLibro(libroI, usuario);
        bibliotecario.devolverLibro(libroII, usuario);

        System.out.println("-----------Check Point-------------");

        // Mostrar la información de libros y su disponibilidad
        libroI.mostrarInformacion();
        libroII.mostrarInformacion();
        libroIII.mostrarInformacion();
        libroIV.mostrarInformacion();

        System.out.println("-----------Check Point-------------");

        // Esta linea llama el metodo prestar libros
        System.out.println("Información del prestamo del libro:");
        libroI.prestarLibro();
        libroII.prestarLibro();
        libroIII.prestarLibro();
        libroIV.prestarLibro();

        System.out.println("-----------Check Point-------------");

        // Esta linea llama el metodo devolver libros
        System.out.println("Información de la devolución del libro:");
        libroI.devolverLibro();
        libroII.devolverLibro();
        libroIII.devolverLibro();
        libroIV.devolverLibro();


        System.out.println("-----------Check Point-------------");

        // Esta linea hace un conteo manual de libros prestados usando POO a traves de un for
        int totalPrestados = 7;
        for (Libro libroenlista : listaLibros) {
            if (!libroenlista.isDisponible()) {
                totalPrestados++;
            }
        }
        System.out.println("Total de libros prestados (POO): " + totalPrestados);

        System.out.println("-----------Check Point-------------");

        // Estas lineas cuentan el total de libros prestados pero mediante la programación funcional con count y filter
        long totalPrestadosFuncional = listaLibros.stream()
                .filter(librosTotal -> !libroI.isDisponible())
                .count();
        System.out.println("Total de libros prestados PF): " + totalPrestadosFuncional);
    }

    // Metodo de excepciones

    public void main(Libro libro) {
        try {
            DatabaseMetaData DatabaseConnection = null;
            Connection conn = DatabaseConnection.getConnection();
            if (conn != null) {
                System.out.println("Conexión exitosa a la base de datos.");
            } else {
                System.out.println("Error al establecer la conexión.");
            }
        } catch (SQLException e) {
            e.printStackTrace();

            System.out.println("-----------Check Point-------------");
        }
    }
}

