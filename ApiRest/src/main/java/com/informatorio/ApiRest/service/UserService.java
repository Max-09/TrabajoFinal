package com.informatorio.ApiRest.service;

import java.util.ArrayList;
import java.util.Optional;

import com.informatorio.ApiRest.entity.User;
import com.informatorio.ApiRest.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    public ArrayList<User> obtenerUsuarios(){
        return (ArrayList<User>) userRepository.findAll();
    } 

    public Optional<User> obtenerPorId(Long id){
        return userRepository.findById(id);
    }

    public User guardarUsuario(User usuario){
        return userRepository.save(usuario);
    }

    public boolean eliminarUsuario(Long id) {
        try{
            userRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


}