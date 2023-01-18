package com.portfolio.gastonAlonso.controller;
import java.util.List;
import com.portfolio.gastonAlonso.dto.Mensaje;
import com.portfolio.gastonAlonso.dto.ProyectoDto;
import com.portfolio.gastonAlonso.interfazServices.IProyectoService;
import com.portfolio.gastonAlonso.model.Curso;
import com.portfolio.gastonAlonso.model.Educacion;
import com.portfolio.gastonAlonso.model.Proyecto;
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
@RequestMapping("/api/proyecto")
@CrossOrigin(origins = {"https://web-lga.web.app","http://localhost:4200"})

public class ProyectoController {

    @Autowired
    private IProyectoService proyectoService;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> verProyecto() {
        List<Proyecto> proyectos = proyectoService.verProyecto();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody ProyectoDto proyectoDto) {
        if (StringUtils.isBlank(proyectoDto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto = new Proyecto(
                proyectoDto.getNombre(),
                proyectoDto.getDescripcion(),
                proyectoDto.getImgUrl(),
               proyectoDto.getVariableI());
        proyectoService.crearProyecto(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.CREATED);
    }

    @PutMapping("/editar")
    public ResponseEntity<?> editarProyecto(@RequestBody Proyecto proyecto) {
        proyectoService.editarProyecto(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto editado"), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Curso> buscarProyecto(@PathVariable Long id) {
        if (proyectoService.buscarProyecto(id) == null) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(proyectoService.buscarProyecto(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void borrarProyecto(@PathVariable Long id){
        proyectoService.borrarProyecto(id);
    }
}
