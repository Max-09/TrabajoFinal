package com.informatorio.ApiRest.controller;

import com.informatorio.ApiRest.entity.Votes;
import com.informatorio.ApiRest.repository.VotesRepository;
import com.informatorio.ApiRest.service.VotesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/votes")
public class VotesController {

    @Autowired
    VotesService votesService;
    @Autowired
    VotesRepository votesRepository;

    @PostMapping
    public Votes voto(@RequestBody Votes voto){
        return this.votesService.votar(voto);
    }

    @GetMapping (value = "/votosuser/{email}")
    public ResponseEntity<?> votosPorUsuario(@PathVariable("email") String email){
        return new ResponseEntity<>(votesRepository.getByEmail(email), HttpStatus.OK);
    }
}
