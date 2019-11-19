package com.connor.demo.services;

import com.connor.demo.models.Player;
import com.connor.demo.models.PlayerDTO;
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

    public Player findOne(Long id){
        return repository.findById(id).orElse(null);
    }


    public Player update(Player player){
        Player ogPlayer = repository.findById(player.getCreature_id()).orElse(null);
        assert ogPlayer != null;
        ogPlayer.setStats(player.getStats());
        return repository.save(ogPlayer);
    }

    public Iterable<Player> findByGameFk(Long game_fk){
        return repository.findAllByGameFk(game_fk);
    }


    public Player create(PlayerDTO playerDTO){
        Player player = new Player(playerDTO.getName());
        player.setGameFk(playerDTO.getGameId());
        return repository.save(player);
    }

}
