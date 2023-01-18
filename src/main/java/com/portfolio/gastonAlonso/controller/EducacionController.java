package com.portfolio.gastonAlonso.controller;

import java.sql.Date;
import java.util.List;

import com.portfolio.gastonAlonso.dto.EducacionDto;
import com.portfolio.gastonAlonso.dto.Mensaje;
import com.portfolio.gastonAlonso.interfazServices.IEducacionService;
import com.portfolio.gastonAlonso.model.Curso;
import com.portfolio.gastonAlonso.model.Educacion;
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
@RequestMapping("/api/educacion")
@CrossOrigin(origins = {"https://web-lga.web.app","http://localhost:4200"})

public class EducacionController {

    @Autowired
    private IEducacionService educacionService;

    @GetMapping("/list")
    public ResponseEntity<List<Educacion>> verEducacion() {
        List<Educacion> educacions = educacionService.verEducacion();
        return new ResponseEntity(educacions, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody EducacionDto educacionDto) {
        if (StringUtils.isBlank(educacionDto.getInstituto())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = new Educacion(
                educacionDto.getInstituto(),
                (Date) educacionDto.getInicio(),
                (Date) educacionDto.getFin(),
                educacionDto.getTitulo());
        educacionService.crearEducacion(educacion);
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.CREATED);
    }

    @PutMapping("/editar")
    public ResponseEntity<?> editarEducacion(@RequestBody Educacion educacion) {
        educacionService.editarEducacion(educacion);
        return new ResponseEntity(new Mensaje("Educacion editada"), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Curso> buscarEducacion(@PathVariable Long id) {
        if (educacionService.buscarEducacion(id) == null) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(educacionService.buscarEducacion(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void borrarEducacion(@PathVariable Long id){
        educacionService.borrarEducacion(id);
    }

}
