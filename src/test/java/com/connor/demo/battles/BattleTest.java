package com.connor.demo.battles;

import com.connor.demo.battle.Battle;
import com.connor.demo.creatures.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class BattleTest {

    private ArrayList<Player> players;
    private Battle battle;

    @Before
    public void setUp(){
        players = new ArrayList<>();
        Player connor = new Player("Connor");
        Player test = new Player("Test");
        players.add(connor);
        players.add(test);
        battle = new Battle(players);
    }

    @Test
    public void testBattle(){
        battle.start();
    }
}
