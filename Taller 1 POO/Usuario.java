package com.biblioteca.modelos;

//1.Se crea la clase extendida llamada Usuario

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
    public int getLimitePrestamo () {
        return LIMITE_PRESTAMOS;
    }
    public String getNombre() {
        return nombre;
    }
}
