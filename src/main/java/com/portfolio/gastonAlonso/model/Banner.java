package com.portfolio.gastonAlonso.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Banner {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    @Size(max = 100, message = "no cumple la longitud")
    private String nombreUrl;


    public Banner() {
    }

    public Banner(Long id, String nombreUrl) {
        this.id = id;
        this.nombreUrl = nombreUrl;
    }
}
