package com.portfolio.gastonAlonso.controller;
import java.util.List;

import com.portfolio.gastonAlonso.dto.BannerDto;
import com.portfolio.gastonAlonso.dto.Mensaje;

import com.portfolio.gastonAlonso.interfazServices.IBannerService;
import com.portfolio.gastonAlonso.model.Banner;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/banner")
@CrossOrigin(origins = {"https://lga-portfolio.web.app/api","http://localhost:4200"})

public class BannerController {

    @Autowired
    private IBannerService bannerService;

    @GetMapping("/lista")
    public ResponseEntity<List<Banner>> verBanner() {
        List<Banner> banners = bannerService.verBanner();
        return new ResponseEntity(banners, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> crear(@RequestBody BannerDto bannerDto) {
        if (StringUtils.isBlank(bannerDto.getNombreUrl())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Banner banner = new Banner(
                bannerDto.getNombreUrl());
        bannerService.crearBanner(banner);
        return new ResponseEntity(new Mensaje("Banner creado"), HttpStatus.CREATED);
    }

    @PutMapping("/editar")
    public ResponseEntity<?> editarBanner(@RequestBody Banner banner) {
        bannerService.editarBanner(banner);
        return new ResponseEntity(new Mensaje("Banner editado"), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Banner> buscarBanner(@PathVariable Long id) {
        if (bannerService.buscarBanner(id) == null) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(bannerService.buscarBanner(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void borrarBanner(@PathVariable Long id){
        bannerService.borrarBanner(id);
    }

}
