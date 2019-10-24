package com.connor.demo.game.creatures.monsters;

import com.connor.demo.game.utilities.Dice;
import com.connor.demo.game.creatures.Stats;
import com.connor.demo.game.creatures.Player;

import java.util.ArrayList;

public class MonsterFactory {

    private Dice dice = new Dice(100);
    private ArrayList<Player> players;

    public MonsterFactory(ArrayList<Player> players){
        this.players = players;
    }


    public Monster create(){
        int roll = dice.roll();
        int level = 0;
        for (Player player : players){
            level += player.getStats().get(Stats.LEVEL);
        }
        level /= players.size();
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
