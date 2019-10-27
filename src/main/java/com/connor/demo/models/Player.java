package com.connor.demo.models;

import javax.persistence.*;

@Entity
public class Player extends Creature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long creature_id;


    private Long game_fk;



    public Player(){
        super();
    }

    public Player(String name){
        super(name);
    }

    public Long getCreature_id() {
        return creature_id;
    }

    public void setCreature_id(Long creature_id) {
        this.creature_id = creature_id;
    }

    public Long getGame_fk() {
        return game_fk;
    }

    public void setGame_fk(Long game_fk) {
        this.game_fk = game_fk;
    }

}
