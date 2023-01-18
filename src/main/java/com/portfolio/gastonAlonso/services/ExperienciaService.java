package com.portfolio.gastonAlonso.services;
import java.util.List;

import com.portfolio.gastonAlonso.interfazServices.IExperienciaService;
import com.portfolio.gastonAlonso.model.Experiencia;
import com.portfolio.gastonAlonso.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ExperienciaService implements IExperienciaService {
    @Autowired
    public ExperienciaRepository  experienciaRepository;

    @Override
    public List<Experiencia> verExperiencia() {
        return experienciaRepository.findAll();
    }

    @Override
    public void crearExperiencia(Experiencia exp) {
            experienciaRepository.save(exp);
    }

    @Override
    public void borrarExperiencia(Long id) {
            experienciaRepository.deleteById(id);
    }

    @Override
    public Experiencia buscarExperiencia(Long id) {
        return experienciaRepository.findById(id).orElse(null);
    }

    @Override
    public Experiencia editarExperiencia(Experiencia exp) {
        Experiencia experiencia = experienciaRepository.findById(exp.getId()).orElse(null);
        experiencia.setNombre(exp.getNombre());
        experiencia.setInicio(exp.getInicio());
        experiencia.setFin(exp.getFin());
        experiencia.setTrabajo(true);
        experiencia.setTarea1(exp.getTarea1());
        experiencia.setTarea2(exp.getTarea2());
        experiencia.setTarea3(exp.getTarea3());
        experiencia.setTarea4(exp.getTarea4());
        return experienciaRepository.save(experiencia);
    }
}
