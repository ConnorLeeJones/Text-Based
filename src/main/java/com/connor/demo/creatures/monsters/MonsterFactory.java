package com.connor.demo.creatures.monsters;

import com.connor.demo.creatures.Player;
import com.connor.demo.creatures.monsters.types.Bear;
import com.connor.demo.creatures.monsters.types.Goblin;
import com.connor.demo.creatures.monsters.types.Hobgoblin;
import com.connor.demo.creatures.monsters.types.Wolf;
import com.connor.demo.creatures.stats.Stats;
import dice.Dice;

public class MonsterFactory {

    private Dice dice = new Dice(100);
    private Player player;

    public MonsterFactory(Player player){
        this.player = player;
    }


    private Monster create(){
        int roll = dice.roll();
        int level = player.getStats().get(Stats.LEVEL);
        if (roll <= 25) {
            return new Goblin("Gobo", level);
        } else if (roll <= 50) {
            return new Wolf("Wolf", level);
        } else if (roll <= 75) {
            return new Bear("Bear", level);
        } else {
            return new Hobgoblin("Hobgoblin", level);
        }
    }


}
