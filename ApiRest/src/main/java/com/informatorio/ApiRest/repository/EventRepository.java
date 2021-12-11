package com.informatorio.ApiRest.repository;

import com.informatorio.ApiRest.entity.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{
    
}
