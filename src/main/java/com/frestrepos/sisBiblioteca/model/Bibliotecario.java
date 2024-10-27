package com.frestrepos.sisBiblioteca.model;


import jakarta.persistence.Entity;

@Entity
public class Bibliotecario extends Persona{
    private String numerodeEmpleado;
    private String turno;

    public Bibliotecario() {}

    public Bibliotecario(String nombre, String apellido, String email, String numeroEmpleado, String turno) {
        super(nombre, apellido, email);
        this.numerodeEmpleado = numeroEmpleado;
        this.turno = turno;
    }

    // Getters y Setters

    public String getNumeroEmpleado() {
        String numeroEmpleado = "";
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Bibliotecario{" +
                "numeroEmpleado='" + numeroEmpleado + '\'' +
                ", turno='" + turno + '\'' +
                "} " + super.toString();
    }
}
