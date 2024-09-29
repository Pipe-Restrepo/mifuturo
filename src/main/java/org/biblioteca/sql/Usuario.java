package org.biblioteca.sql;

//1.Se crea la clase extendida llamada Usuario

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Usuario extends Persona {

    //2. Estas lineas controlan los libros prestados por un usuario y su limite establecido
    private int cantidadLibrosPrestados = 0;
    private final int LIMITE_PRESTAMOS = 2;

    public Usuario(String nombre, String apellido, int codigoUsuario) {
        super(nombre, apellido);
        this.codigoUsuario = codigoUsuario;
    }

    //3. Aqui se llama mediante una anotación la información del Usuario incluyendo un código personal
    @Override
    public void mostrarDatos() {
        System.out.println("Nombre y Apellido: " + nombre + " " + apellido);
        System.out.println("Código de Usuario: " + codigoUsuario);
    }

    @Override
    public void agregarUsuario(Libro libro) {

    }

    //4. Se crea el metodo libros prestados
    public int getLibrosPrestados() {
        return cantidadLibrosPrestados;
    }

    //5. Se crea el metodo para incrementar prestamos y validar la cantidad limite
    public void incrementarPrestamos() {
        cantidadLibrosPrestados++;
    }

    //6. Se crea el metodo para decrementar prestamos y validar la cantidad limite
    public void decrementarPrestamos() {
        if (cantidadLibrosPrestados > 0) {
            cantidadLibrosPrestados--;
        }
    }

    //7. Se llama el metodo de limite de prestamos de un usuario
    public int getLimitePrestamo() {
        return LIMITE_PRESTAMOS;
    }

    public String getNombre() {
        return nombre;
    }


   //8. CRUD de usuarios

    public void agregarUsuarios(Usuario usuario) throws SQLException {
        String query = "insert into Usuario (id, prestamos) values (6, 11)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, Usuario.getid());
            stmt.setString(2, Usuario.getPrestamos());

            stmt.executeUpdate();
        }
    }

    public void actualizarUsuarios(Usuario usuario) throws SQLException {
        String query = "update from Usuario where (id, prestamos) values (2, 10)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, Usuario.getid());
            stmt.setString(2, Usuario.getPrestamos());

            stmt.executeUpdate();
        }
    }

    public void eliminarUsuarios(Usuario usuario) throws SQLException {
        String query = "update from Usuario where (id, prestamos) values (5, 9)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, Usuario.getid());
            stmt.setString(2, Usuario.getPrestamos());

            stmt.executeUpdate();
        }
    }

    private static String getPrestamos() {
        return "Usuario agregado";
    }

    static String getid() {
        return "Prestamo Registrado";
    }
}
