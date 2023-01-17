package com.portfolio.gastonAlonso.interfazServices;

import com.portfolio.gastonAlonso.model.Persona;

import java.util.List;

public interface IPersonaService {

    public List<Persona> verPersonas();
    public void crearPersona(Persona per);
    public void borrarPersona(Long id);
    public Persona buscarPersona(Long id);
    public Persona editarPersona(Persona per);
}
