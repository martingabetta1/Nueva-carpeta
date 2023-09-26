package com.crudmarca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.crudmarca.model.UnidadMedida;

//@Repository
public interface UnidadMedidaRepository extends JpaRepository<UnidadMedida,Integer> {
    List<UnidadMedida> findAll();   
}
