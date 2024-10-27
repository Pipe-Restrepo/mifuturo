package org.biblioteca.sql;

// Se importan caracteristicas para la conexión a la BD Mysql

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// Se define la clase y los datos para la conexión a la bd

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca_db";
    private static final String USER = "root";
    private static final String PASSWORD = "PipeRpo1708";


//   // Probar la conexión a la base de datos

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Conexión a la base de datos exitosa.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return null;
    }
}