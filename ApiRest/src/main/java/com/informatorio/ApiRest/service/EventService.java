package com.informatorio.ApiRest.service;

import java.util.List;

import com.informatorio.ApiRest.entity.Event;
import com.informatorio.ApiRest.entity.Startup;
import com.informatorio.ApiRest.repository.EventRepository;
import com.informatorio.ApiRest.repository.StartupRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    StartupRepository startupRepository;

    public Event obtenerEvent(Event event){
        return eventRepository.save(event);
    }

    public boolean eliminarEvent(Long id) {
        try{
            eventRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public Event actualizarEvent(Long userId, Event eventNew){
        Event userOld = eventRepository.getById(userId);
        userOld.setName(eventNew.getName());
        userOld.setActivo(eventNew.getActivo());
        return eventRepository.save(userOld);
    }

    public List<Startup> startup(Long eventId){
        Event aux = eventRepository.getById(eventId);
        return aux.getStartup();
    }
}
