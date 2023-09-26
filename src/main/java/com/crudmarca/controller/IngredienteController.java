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
import com.crudmarca.model.Ingrediente;
import com.crudmarca.model.UnidadMedida;
import com.crudmarca.repository.UnidadMedidaRepository;

@RestController
@RequestMapping("/ingrediente")
public class IngredienteController {


    @Autowired
    private IngredienteRepository ingredienteRepository;


    // Obtener todos
    @GetMapping
    public List<Ingrediente> listarIngredientes() {
        return ingredienteRepository.findAll();
    }
    

    // Nuevo
    @PostMapping // http://localhost:8080/ingrediente
    public Ingrediente newIngrediente(@RequestBody Ingrediente newiIngrediente){
        return ingredienteRepository.save(newiIngrediente);
    }

    //Obtener uno
    @GetMapping("/{id}")
    public ingrediente one(@PathVariable Integer id){
        return ingredienteRepository.findById(id)
      .orElseThrow(() -> new UMNotFoundException(id));
    }

    // Editar o crear
    @PutMapping("/{id}")
    public ingrediente edit(@RequestBody ingrediente newiIngrediente, @PathVariable Integer id){
        return ingredienteRepository.findById(id)
        .map(unidad -> {
          unidad.setNombre(newUnidadMedida.getNombre());
          return ingredienteRepository.save(unidad);
        })
        .orElseGet(() -> {
          newIngrediente.setId(id);
          return ingredienteRepository.save(newIngrediente);
        });
    }


    // Eliminar
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        ingredienteRepository.deleteById(id);
    }
}
