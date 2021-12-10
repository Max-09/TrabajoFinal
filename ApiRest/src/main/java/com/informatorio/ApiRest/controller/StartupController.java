package com.informatorio.ApiRest.controller;

import java.util.ArrayList;

import com.informatorio.ApiRest.entity.Startup;
import com.informatorio.ApiRest.repository.StartupRepository;
import com.informatorio.ApiRest.repository.TagRepository;
import com.informatorio.ApiRest.service.StartupService;
import com.informatorio.ApiRest.service.TagService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/startup")
public class StartupController {

    @Autowired
    StartupService startupService;
    @Autowired
    TagService tagService;
    @Autowired
    StartupRepository startupRepository;
    @Autowired
    TagRepository tagRepository;

    @GetMapping
    public ArrayList<Startup> obtenerStartup(){
        return startupService.obtenerStartup();
    }

    @PostMapping
    public Startup guardarStartup(@RequestBody Startup startup){
        return this.startupService.guardarStartup(startup);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.startupService.eliminarStartup(id);
        if (ok){
            return "Se eliminó la startup con id " + id;
        }else{
            return "No pudo eliminar la startup con id" + id;
        }
    }

    @PutMapping("/{id}")
    public Startup actualizarUser(@PathVariable Long id, @RequestBody Startup startup){
        return this.startupService.actualizarStartup(id, startup);
    }
    @GetMapping (value = "/tag/{tag}")
    public ResponseEntity<?> buscarPorTag(@PathVariable("tag") String tag){
        return new ResponseEntity<>(startupRepository.findByTag(tag), HttpStatus.OK);
    }

    @GetMapping (value = "/online/{publicado}")
    public ResponseEntity<?> buscarPorOnline(@PathVariable("publicado") Boolean o){
        return new ResponseEntity<>(startupRepository.findByPublicado(o), HttpStatus.OK);
    }
    
}
