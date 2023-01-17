package com.portfolio.gastonAlonso.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter

public class Mensaje implements Serializable {
    private String mensaje;

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
