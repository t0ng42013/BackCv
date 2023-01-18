package com.portfolio.gastonAlonso.model;

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

    @Size(max = 100, message = "no cumple la longitud")
    private String nombreUrl;

    public Banner() {
    }

    public Banner(String nombreUrl) {
        this.nombreUrl = nombreUrl;
    }
}
