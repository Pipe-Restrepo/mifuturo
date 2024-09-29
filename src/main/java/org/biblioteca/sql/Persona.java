package org.biblioteca.sql;

//1. Se crea la clase abstracta y se asignan atributos solicitados y dos adicionales como plus al funcionamiento

public abstract class Persona {
    protected String nombre;
    protected String apellido;
    protected int codigoUsuario;
    protected int idBibliotecario;

    //2. Se crea constructor para dar inicio a los atributos de la clase

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoUsuario = codigoUsuario;
        this.idBibliotecario = idBibliotecario;
    }

    //3. Esta linea define el metodo abstracto llamado mostrarDatos()

    public abstract void mostrarDatos();

    public abstract void agregarUsuario(Libro libro);
}
