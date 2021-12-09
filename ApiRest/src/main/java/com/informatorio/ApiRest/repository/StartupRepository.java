package com.informatorio.ApiRest.repository;

import com.informatorio.ApiRest.entity.Startup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StartupRepository extends JpaRepository<Startup, Long>{
    
}
