package com.connor.demo.services;

import com.connor.demo.models.BattleModel;
import com.connor.demo.models.Player;
import com.connor.demo.models.User;
import com.connor.demo.repositories.BattleRepository;
import com.connor.demo.repositories.PlayerRepository;
import com.connor.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class BattleService {

    private BattleRepository repository;
    private UserRepository userRepository;
    private PlayerRepository playerRepository;


    @Autowired
    public BattleService(BattleRepository repository, UserRepository userRepository, PlayerRepository playerRepository){
        this.repository = repository;
        this.userRepository = userRepository;
        this.playerRepository = playerRepository;
    }


    public Iterable<BattleModel> findAll(){
        return repository.findAll();
    }

    public BattleModel findBattleById(Long id){
        return repository.findById(id).get();
    }

    public BattleModel create(Long userId){
        User user = userRepository.findUserByUserId(userId);
        System.out.println(userId);
        ArrayList<Player> players = (ArrayList<Player>) playerRepository.findAllByGameFk(userId);
        System.out.println(players);
        BattleModel battleModel = new BattleModel(playerRepository.findAllByGameFk(userId), userId);
        return repository.save(battleModel);
    }



}
