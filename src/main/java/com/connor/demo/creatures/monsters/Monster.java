package com.connor.demo.creatures.monsters;

import com.connor.demo.creatures.Creature;
import com.connor.demo.creatures.stats.StatCreator;
import com.connor.demo.creatures.stats.Stats;

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
