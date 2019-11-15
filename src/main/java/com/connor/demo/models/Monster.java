package com.connor.demo.models;

import com.connor.demo.game.creatures.StatCreator;
import com.connor.demo.game.creatures.Stats;
import com.connor.demo.models.Creature;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Monster")
public class Monster extends Creature {


//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long monster_id;


    public Monster() { super(); }

    public Monster(String name, Integer level) {
        super(name, level);
    }

    public Monster(String name) {
        super(name);
    }

    private HashMap<Stats, Integer> initStats(Integer level){
        return StatCreator.newMonsterStats(level);
    }

//    public Long getMonster_id() {
//        return monster_id;
//    }
//
//    public void setMonster_id(Long monster_id) {
//        this.monster_id = monster_id;
//    }
}
