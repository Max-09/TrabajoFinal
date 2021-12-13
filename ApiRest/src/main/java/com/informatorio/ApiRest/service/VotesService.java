package com.informatorio.ApiRest.service;

import java.util.List;

import com.informatorio.ApiRest.entity.Event;
import com.informatorio.ApiRest.entity.Startup;
import com.informatorio.ApiRest.entity.Votes;
import com.informatorio.ApiRest.repository.EventRepository;
import com.informatorio.ApiRest.repository.StartupRepository;
import com.informatorio.ApiRest.repository.VotesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotesService {
    
    @Autowired
    VotesRepository votesRepository;
    @Autowired
    StartupRepository startupRepository;
    @Autowired
    EventRepository eventRepository;

    public Votes votar(Votes voto){
        Votes votoaux = voto;
        Startup startupVoto = startupRepository.getById(votoaux.getStartupId());
        Event eventVoto = eventRepository.getById(votoaux.getEventId());
        if(startupVoto.isPublicado()){
            if(eventVoto.getEstado()!="FINALIZADO"){
                startupVoto.setVotos(startupVoto.getVotos() + 1);
                startupRepository.save(startupVoto);
                return votesRepository.save(voto);
            }else{
                return votoaux;
            }
        }else{
            return votoaux;
        }
    }
    public List<Votes> votosUser(String email){
        return votesRepository.getByEmail(email);
    }
}
