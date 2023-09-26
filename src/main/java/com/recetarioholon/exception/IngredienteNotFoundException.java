package com.recetarioholon.exception;

public class IngredienteNotFoundException extends RuntimeException {
    public IngredienteNotFoundException(Integer id){
        super("No se encontró ingrediente "+id);
    }
} 
