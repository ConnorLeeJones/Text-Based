package com.connor.demo.creatures.monsters;

import com.connor.demo.creatures.Creature;
import com.connor.demo.creatures.Stats;

import java.util.HashMap;

public class Monster extends Creature {


    public Monster() {}

    public Monster(HashMap<Stats, Integer> stats, String name) {
        super(stats, name);
    }

    public Monster(String name) {
        super(name);
    }
}
