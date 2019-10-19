package com.connor.demo.creatures;

import com.connor.demo.creatures.stats.Stats;

import java.util.Comparator;

public class CreatureComparator implements Comparator<Creature> {
    public CreatureComparator() {}

    @Override
    public int compare(Creature creature1, Creature creature2) {
        return creature2.getStat(Stats.SPEED).compareTo(creature1.getStat(Stats.SPEED));
    }
}
