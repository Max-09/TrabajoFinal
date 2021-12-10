package com.informatorio.ApiRest.repository;

import com.informatorio.ApiRest.entity.Tags;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tags, Long>{
   
}
