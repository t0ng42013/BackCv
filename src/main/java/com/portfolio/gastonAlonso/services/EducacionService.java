package com.portfolio.gastonAlonso.services;

import java.util.List;
import com.portfolio.gastonAlonso.interfazServices.IEducacionService;
import com.portfolio.gastonAlonso.model.Educacion;
import com.portfolio.gastonAlonso.repository.EducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class EducacionService implements IEducacionService {

    @Autowired
    public EducacionRepository educacionRepository;

    @Override
    public List<Educacion> verEducacion() {
        return educacionRepository.findAll();
    }

    @Override
    public void crearEducacion(Educacion edu) {
            educacionRepository.save(edu);
    }

    @Override
    public void borrarEducacion(Long id) {
        educacionRepository.deleteById(id);
    }

    @Override
    public Educacion buscarEducacion(Long id) {
        return educacionRepository.findById(id).orElse(null);
    }

    @Override
    public Educacion editarEducacion(Educacion edu) {
        Educacion educacion = educacionRepository.findById(edu.getId()).orElse(null);
        educacion.setInstituto(edu.getInstituto());
        educacion.setInicio(edu.getInicio());
        educacion.setFin(edu.getFin());
        educacion.setTitulo(edu.getTitulo());

        return educacionRepository.save(educacion);
    }
}
