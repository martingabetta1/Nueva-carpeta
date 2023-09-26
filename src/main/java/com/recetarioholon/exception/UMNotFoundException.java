package com.recetarioholon.exception;

public class UMNotFoundException extends RuntimeException {
    public UMNotFoundException(Integer id){
        super("No se encontró unidad "+id);
    }
}