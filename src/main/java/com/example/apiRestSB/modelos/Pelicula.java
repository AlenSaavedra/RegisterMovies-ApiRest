package com.example.apiRestSB.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pelicula {
    //Autogenera el id de las tablas
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //Atributos
    Long id;
    
    String titulo;
    String director;
    String genero;

    //Constructor 
    public Pelicula(){

    }

    public Pelicula(String titulo, String director, String genero){
        
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
}
