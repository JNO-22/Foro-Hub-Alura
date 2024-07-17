package com.Api.Foro.infra.error;

public class ValidarIntegridad extends RuntimeException {
    public ValidarIntegridad(String s){
        super(s);
    }
}
