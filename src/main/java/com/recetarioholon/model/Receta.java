package com.recetarioholon.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="receta")
public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recetaId;
    
    @Column(name = "titulo")
    private String titulo;

    @Column(name = "subtitulo")
    private String subtitulo;

    @Column(name="pasos")
    private String pasos;

    @ManyToMany
    @JoinTable(
        name="ingrediente",
        joinColumns =  @JoinColumn(name="id"),
        inverseJoinColumns = @JoinColumn(name="recetaId")
    )
    private List<Ingrediente> ingredientes;

    public Receta(){
        super();
    }
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getPasos() {
        return pasos;
    }

    public void setPasos(String pasos) {
        this.pasos = pasos;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }


    public Integer getRecetaId() {
        return recetaId;
    }


    public void setRecetaId(Integer recetaId) {
        this.recetaId = recetaId;
    }

    
}