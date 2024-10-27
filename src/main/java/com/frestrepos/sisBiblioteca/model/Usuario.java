package com.frestrepos.sisBiblioteca.model;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Usuario extends Persona{
    @OneToMany(mappedBy = "usuario")
    private List<Prestamo> prestamos;

    public Usuario() {}

    public Usuario(String nombre, String apellido, String email, List<Prestamo> prestamos) {
        super(nombre, apellido, email);
        this.prestamos = prestamos;
    }

    // Getters y Setters

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "prestamos=" + prestamos +
                "} " + super.toString();
    }
}
