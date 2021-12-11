package com.informatorio.ApiRest.service;

import java.util.List;

import com.informatorio.ApiRest.entity.Votes;
import com.informatorio.ApiRest.repository.VotesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotesService {
    
    @Autowired
    VotesRepository votesRepository;

    public Votes votar(Votes voto){
        return votesRepository.save(voto);
    }

    public List<Votes> votosUser(Long userId){
        return votesRepository.getByUserId(userId);
    }
}
