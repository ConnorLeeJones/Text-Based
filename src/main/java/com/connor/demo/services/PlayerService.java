package com.connor.demo.services;

import com.connor.demo.models.Player;
import com.connor.demo.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {


    private PlayerRepository repository;


    @Autowired
    public PlayerService(PlayerRepository repository){
        this.repository = repository;
    }

    public Iterable<Player> findAll(){
        return repository.findAll();
    }


    public Player create(String name){
        Player player = new Player(name);
        return repository.save(player);
    }

}
