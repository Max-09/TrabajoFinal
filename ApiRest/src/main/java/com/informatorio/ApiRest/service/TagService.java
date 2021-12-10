package com.informatorio.ApiRest.service;

import com.informatorio.ApiRest.repository.TagRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {
    
    @Autowired
    TagRepository tagRepository;

   
}
