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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="Ingrediente")
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "cantidad")
    private Integer cantidad;


    @ManyToMany
    @JoinTable(
    name = "ingredientes_receta",
    joinColumns = @JoinColumn(name = "ingrediente_id"),
    inverseJoinColumns = @JoinColumn(name = "receta_id")
)
private List<Receta> recetas;

    
    @ManyToOne
    @JoinColumn(name = "unidadMedida")
    UnidadMedida unidadMedida;


    public Ingrediente() {
        super();
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }
    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
}