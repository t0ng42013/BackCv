package com.portfolio.gastonAlonso.controller;

import java.sql.Date;
import java.util.List;
import com.portfolio.gastonAlonso.dto.ExperienciaDto;
import com.portfolio.gastonAlonso.dto.Mensaje;
import com.portfolio.gastonAlonso.model.Curso;
import com.portfolio.gastonAlonso.model.Educacion;
import com.portfolio.gastonAlonso.model.Experiencia;
import com.portfolio.gastonAlonso.services.ExperienciaService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/experiencia")
@CrossOrigin(origins = {"https://web-lga.web.app","http://localhost:4200"})

public class ExperienciaController {
    @Autowired
    private ExperienciaService experienciaService;


    @GetMapping("/list")
    public ResponseEntity<List<Experiencia>> verExperiencia() {
        List<Experiencia> experiencias = experienciaService.verExperiencia();
        return new ResponseEntity(experiencias, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody ExperienciaDto experienciaDto) {
        if (StringUtils.isBlank(experienciaDto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Experiencia experiencia = new Experiencia(
                experienciaDto.getNombre(),
                experienciaDto.isTrabajo(),
                (Date) experienciaDto.getInicio(),
                (Date) experienciaDto.getFin(),
                experienciaDto.getTarea1(),
                experienciaDto.getTarea2(),
                experienciaDto.getTarea3(),
                experienciaDto.getTarea4());
        experienciaService.crearExperiencia(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia creada"), HttpStatus.CREATED);
    }

    @PutMapping("/editar")
    public ResponseEntity<?> editarExperiencia(@RequestBody Experiencia experiencia) {
        experienciaService.editarExperiencia(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia editada"), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Curso> buscarExperiencia(@PathVariable Long id) {
        if (experienciaService.buscarExperiencia(id) == null) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(experienciaService.buscarExperiencia(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void borrarExperiencia(@PathVariable Long id){
        experienciaService.borrarExperiencia(id);
    }
}
