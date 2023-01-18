package com.portfolio.gastonAlonso.interfazServices;

import com.portfolio.gastonAlonso.model.Proyecto;

import java.util.List;

public interface IProyectoService {
    public List<Proyecto> verProyecto();

    public void crearProyecto(Proyecto proyecto);

    public void borrarProyecto(Long id);

    public Proyecto buscarProyecto(Long id);

    public Proyecto editarProyecto(Proyecto proyecto);
}
