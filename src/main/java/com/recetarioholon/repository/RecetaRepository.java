package com.recetarioholon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recetarioholon.model.Receta;

public interface RecetaRepository extends JpaRepository<Receta,Integer> {
    List<Receta> findAll();
}
