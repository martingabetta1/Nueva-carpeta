package com.recetarioholon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.recetarioholon.model.Ingrediente;

//@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente,Integer> {
    List<Ingrediente> findAll();   
}
