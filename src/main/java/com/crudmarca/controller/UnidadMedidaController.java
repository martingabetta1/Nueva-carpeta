package com.crudmarca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudmarca.exception.UMNotFoundException;
import com.crudmarca.model.UnidadMedida;
import com.crudmarca.repository.UnidadMedidaRepository;

@RestController
@RequestMapping("/unidadmedida")
public class UnidadMedidaController {


    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;


    // Obtener todos
    @GetMapping
    public List<UnidadMedida> listarUnidadMedidas() {
        return unidadMedidaRepository.findAll();
    }
    

    // Nuevo
    @PostMapping // http://localhost:8080/unidadmedida
    public UnidadMedida newUnidadMedida(@RequestBody UnidadMedida newuUnidadMedida){
        return unidadMedidaRepository.save(newuUnidadMedida);
    }

    //Obtener uno
    @GetMapping("/{id}")
    public UnidadMedida one(@PathVariable Integer id){
        return unidadMedidaRepository.findById(id)
      .orElseThrow(() -> new UMNotFoundException(id));
    }

    // Editar o crear
    @PutMapping("/{id}")
    public UnidadMedida edit(@RequestBody UnidadMedida newUnidadMedida, @PathVariable Integer id){
        return unidadMedidaRepository.findById(id)
        .map(unidad -> {
          unidad.setNombre(newUnidadMedida.getNombre());
          return unidadMedidaRepository.save(unidad);
        })
        .orElseGet(() -> {
          newUnidadMedida.setId(id);
          return unidadMedidaRepository.save(newUnidadMedida);
        });
    }


    // Eliminar
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        unidadMedidaRepository.deleteById(id);
    }
}
