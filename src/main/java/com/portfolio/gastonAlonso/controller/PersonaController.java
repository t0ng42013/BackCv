package com.portfolio.gastonAlonso.controller;


import com.portfolio.gastonAlonso.dto.Mensaje;
import com.portfolio.gastonAlonso.dto.PersonaDto;
import com.portfolio.gastonAlonso.interfazServices.IPersonaService;
import com.portfolio.gastonAlonso.model.Persona;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persona")
@CrossOrigin(origins = {"https://lga-portfolio.web.app/api","http://localhost:4200"})
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> verPersonas() {
        List<Persona> personas = personaService.verPersonas();
        return new ResponseEntity(personas, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> crear(@RequestBody PersonaDto personaDto) {
        if (StringUtils.isBlank(personaDto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = new Persona(
                personaDto.getNombre(),
                personaDto.getApellido(),
                personaDto.getTitulo(),
                personaDto.getSobreMi(),
                personaDto.getDomicilio(),
                personaDto.getUrl());
        personaService.crearPersona(persona);
        return new ResponseEntity(new Mensaje("Persona creada"), HttpStatus.CREATED);
    }

    @PutMapping("/editar")
    public ResponseEntity<?> editarPersona(@RequestBody Persona persona) {
        personaService.editarPersona(persona);
        return new ResponseEntity(new Mensaje("Persona editada"), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Persona> buscarPersona(@PathVariable Long id) {
        if (personaService.buscarPersona(id) == null) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(personaService.buscarPersona(id), HttpStatus.OK);
    }

      @DeleteMapping("/delete/{id}")
      public void borrarPersona(@PathVariable Long id){
           personaService.borrarPersona(id);
        }

}



