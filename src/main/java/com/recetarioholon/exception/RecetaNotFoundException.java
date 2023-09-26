package com.recetarioholon.exception;

public class RecetaNotFoundException extends RuntimeException {
    public RecetaNotFoundException(Integer id){
        super("No se encontró receta "+id);
    }
}