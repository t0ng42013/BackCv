package com.portfolio.gastonAlonso.interfazServices;

import com.portfolio.gastonAlonso.model.Educacion;

import java.util.List;

public interface IEducacionService {
    public List<Educacion> verEducacion();

    public void crearEducacion(Educacion edu);

    public void borrarEducacion(Long id);

    public Educacion buscarEducacion(Long id);

    public Educacion editarEducacion(Educacion edu);
}
