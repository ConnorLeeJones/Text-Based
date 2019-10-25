package com.connor.demo.models;

import com.connor.demo.game.creatures.Creature;

import javax.persistence.*;

@Entity
public class Player extends Creature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long player_id;



    public Player(){
        super();
    }

    public Player(String name){
        super(name);
    }

    public Long getPlayerId() {
        return player_id;
    }

    public void setPlayerId(Long player_id) {
        this.player_id = player_id;
    }
}
