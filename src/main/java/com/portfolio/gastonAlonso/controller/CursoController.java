package com.portfolio.gastonAlonso.controller;

import java.sql.Date;
import java.util.List;

import com.portfolio.gastonAlonso.dto.CursoDto;
import com.portfolio.gastonAlonso.dto.Mensaje;
import com.portfolio.gastonAlonso.interfazServices.ICursoService;
import com.portfolio.gastonAlonso.model.Curso;
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
@RequestMapping("/api/curso")
@CrossOrigin(origins = {"https://web-lga.web.app","http://localhost:4200"})
public class CursoController {

    @Autowired
    private ICursoService cursoService;

    @GetMapping("/lista")
    public ResponseEntity<List<Curso>> verCurso() {
        List<Curso> cursos = cursoService.verCurso();
        return new ResponseEntity(cursos, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody CursoDto cursoDto) {
        if (StringUtils.isBlank(cursoDto.getInstituto())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Curso curso = new Curso(
               cursoDto.getInstituto(),
                (Date) cursoDto.getInicio(),
                (Date) cursoDto.getFin(),
                cursoDto.getTitulo());
        cursoService.crearCurso(curso);
        return new ResponseEntity(new Mensaje("Curso creado"), HttpStatus.CREATED);
    }

    @PutMapping("/editar")
    public ResponseEntity<?> editarCurso(@RequestBody Curso curso) {
        cursoService.editarCurso(curso);
        return new ResponseEntity(new Mensaje("Curso editado"), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Curso> buscarCurso(@PathVariable Long id) {
        if (cursoService.buscarCurso(id) == null) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(cursoService.buscarCurso(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void borrarCurso(@PathVariable Long id){
        cursoService.borrarCurso(id);
    }


}
