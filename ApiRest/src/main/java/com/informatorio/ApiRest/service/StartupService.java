package com.informatorio.ApiRest.service;

import java.util.ArrayList;
import java.util.Optional;

import com.informatorio.ApiRest.entity.Startup;
import com.informatorio.ApiRest.repository.StartupRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StartupService {
    
    @Autowired
    StartupRepository startupRepository;

    public ArrayList<Startup> obtenerStartup(){
        return (ArrayList<Startup>) startupRepository.findAll();
    } 

    public Optional<Startup> obtenerPorId(Long id){
        return startupRepository.findById(id);
    }

    public Startup guardarStartup(Startup Startup){
        return startupRepository.save(Startup);
    }

    public boolean eliminarStartup(Long id) {
        try{
            startupRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
    public Startup actualizarStartup(Long startupId, Startup startupNew){
        Startup startupOld = startupRepository.getById(startupId);
        startupOld.setContenido(startupNew.getContenido());
        startupOld.setDescripcion(startupNew.getDescripcion());
        startupOld.setObjetivo(startupNew.getObjetivo());
        startupOld.setPublicado(startupNew.isPublicado());
        return startupRepository.save(startupOld);
    }
}