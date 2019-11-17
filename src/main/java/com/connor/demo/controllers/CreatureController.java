package com.connor.demo.controllers;

import com.connor.demo.models.Creature;
import com.connor.demo.repositories.CreatureRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/creatures")
@CrossOrigin
public class CreatureController {

    private CreatureRepository creatureRepository;

    public CreatureController(CreatureRepository creatureRepository) {
        this.creatureRepository = creatureRepository;
    }

    @GetMapping
    public Iterable<Creature> findAll(){
        return creatureRepository.findAll();
    }
}
