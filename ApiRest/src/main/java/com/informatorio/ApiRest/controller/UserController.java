package com.informatorio.ApiRest.controller;

import java.util.ArrayList;
import java.util.Optional;

import com.informatorio.ApiRest.entity.User;
import com.informatorio.ApiRest.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    UserService userService;

    @GetMapping
    public ArrayList<User> obtenerUsuarios(){
        return userService.obtenerUsuarios();
    }

    @PostMapping()
    public User guardarUsuario(@RequestBody User usuario){
        return this.userService.guardarUsuario(usuario);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.userService.eliminarUsuario(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }

    @GetMapping( path = "/{id}")
    public Optional<User> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.userService.obtenerPorId(id);
    }
}
