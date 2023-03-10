package com.portfolio.gastonAlonso.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class SkillDto implements Serializable {

    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;
}
