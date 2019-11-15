package com.connor.demo.game.creatures.monsters;

import com.connor.demo.game.utilities.Dice;
import com.connor.demo.game.creatures.Stats;
import com.connor.demo.models.Monster;
import com.connor.demo.models.Player;
import com.connor.demo.repositories.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MonsterFactory {

    private Dice dice = new Dice(100);
    private List<Player> players;
    private MonsterRepository monsterRepository;

    public MonsterFactory(List<Player> players){
        this.players = players;
    }


    public Monster create(){
        int roll = dice.roll();
        int level = 0;
        for (Player player : players){
            level += player.getStats().get(Stats.LEVEL);
        }
        level /= players.size();
        //level = 5;
        if (roll <= 25) {
            //return monsterRepository.save(new Goblin("Gobo", level));
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
