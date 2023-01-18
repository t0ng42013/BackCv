package com.portfolio.gastonAlonso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 50, message = "no cumple la longitud")
    private String nombre;

    @Lob
    @Size(max = 5000, message = "no cumple la longitud")
    private String descripcion;

    @Size(max = 100, message = "no cumple la longitud")
    private String imgUrl;
    @Min(0)
    @Max(15)
    private int variableI;

    public Proyecto() {
    }

    public Proyecto(String nombre, String descripcion, String imgUrl, int variableI) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imgUrl = imgUrl;
        this.variableI = variableI;
    }
}
