package com.connor.demo.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Player extends Creature  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long creature_id;


    private Long gameFk;



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

    public Long getGameFk() {
        return gameFk;
    }

    public void setGameFk(Long gameFk) {
        this.gameFk = gameFk;
    }

}
