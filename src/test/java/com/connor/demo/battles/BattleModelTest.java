package com.connor.demo.battles;

import com.connor.demo.models.Battle;
import com.connor.demo.models.BattleModel;
import com.connor.demo.models.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class BattleModelTest {

    private ArrayList<Player> players;
    private Battle battle;

    @Before
    public void setUp(){
        players = new ArrayList<>();
        Player connor = new Player("Connor");
        Player test = new Player("Test");
        Player connor2 = new Player("Connor2");
        Player test2 = new Player("Test2");
        players.add(connor);
        players.add(test);
        players.add(connor2);
        players.add(test2);
        battle = new Battle(players);
    }

    @Test
    public void testBattle(){
        battle.start();
    }
}
