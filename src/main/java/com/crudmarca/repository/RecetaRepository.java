package com.crudmarca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudmarca.model.Receta;

public interface RecetaRepository extends JpaRepository<Receta,Integer> {
    List<Receta> findAll();
}
