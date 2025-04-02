package com.example.practica.dto;

public class EstudianteDTO {
    private String nombre;
    private int edad;
    private String email;  

    public EstudianteDTO() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {  
        return email;
    }

    public void setEmail(String email) {  
        this.email = email;
    }
}
