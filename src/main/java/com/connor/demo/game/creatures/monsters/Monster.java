package com.connor.demo.game.creatures.monsters;

import com.connor.demo.game.creatures.StatCreator;
import com.connor.demo.game.creatures.Stats;
import com.connor.demo.models.Creature;

import java.util.HashMap;

public class Monster extends Creature {


    public Monster() {}

    public Monster(String name, Integer level) {
        super(name, level);
    }

    public Monster(String name) {
        super(name);
    }

    private HashMap<Stats, Integer> initStats(Integer level){
        return StatCreator.newMonsterStats(level);
    }

}
