package com.portfolio.gastonAlonso.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDto {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    private String domicilio;

    private String titulo;

    private String sobreMi;

    private  String url;

}
