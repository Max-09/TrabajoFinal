package com.informatorio.ApiRest.repository;

import java.util.List;

import com.informatorio.ApiRest.entity.Votes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotesRepository extends JpaRepository<Votes, Long>{

    List<Votes> getByUserId(Long userId);
    
}
