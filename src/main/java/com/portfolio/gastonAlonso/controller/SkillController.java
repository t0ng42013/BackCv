package com.portfolio.gastonAlonso.controller;
import java.util.List;

import com.portfolio.gastonAlonso.dto.Mensaje;
import com.portfolio.gastonAlonso.dto.SkillDto;
import com.portfolio.gastonAlonso.interfazServices.ISkillService;
import com.portfolio.gastonAlonso.model.Skill;
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
@RequestMapping("/api/skill")
@CrossOrigin(origins = {"https://web-lga.web.app","http://localhost:4200"})

public class SkillController {
    @Autowired
    private ISkillService skillService;

    @GetMapping("/lista")
    public ResponseEntity<List<Skill>> verSkill() {
        List<Skill> skills = skillService.verSkill();
        return new ResponseEntity(skills, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody SkillDto skillDto) {
        if (StringUtils.isBlank(skillDto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Skill skill = new Skill(
                skillDto.getNombre(),
                skillDto.getPorcentaje());
        skillService.crearSkill(skill);
        return new ResponseEntity(new Mensaje("Skill creado"), HttpStatus.CREATED);
    }

    @PutMapping("/editar")
    public ResponseEntity<?> editarSkill(@RequestBody Skill skill) {
        skillService.editaSkill(skill);
        return new ResponseEntity(new Mensaje("Skill editado"), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Skill> buscarSkill(@PathVariable Long id) {
        if (skillService.buscarSkill(id) == null) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(skillService.buscarSkill(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void borrarSkill(@PathVariable Long id){
        skillService.borrarSkill(id);
    }
}
