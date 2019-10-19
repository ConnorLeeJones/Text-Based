package com.connor.demo.creatures;

import com.connor.demo.creatures.stats.Stats;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    private Player player = new Player("Connor");

    @Test
    public void nameTest(){
        Assert.assertEquals("Connor", player.getName());
    }

    @Test
    public void strengthTest(){
        Integer expected = 10;
        Integer actual = player.getStat(Stats.STRENGTH);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void defenseTest(){
        Integer expected = 10;
        Integer actual = player.getStat(Stats.DEFENSE);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void manaTest(){
        Integer expected = 10;
        Integer actual = player.getStat(Stats.MANA);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void speedTest(){
        Integer expected = 10;
        Integer actual = player.getStat(Stats.SPEED);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void accuracyTest(){
        Integer expected = 10;
        Integer actual = player.getStat(Stats.ACCURACY);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hpTest(){
        Integer expected = 100;
        Integer actual = player.getStat(Stats.HP);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void mpTest(){
        Integer expected = 100;
        Integer actual = player.getStat(Stats.MP);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void xpTest(){
        Integer expected = 0;
        Integer actual = player.getStat(Stats.XP);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void maxHpTest(){
        Integer expected = 100;
        Integer actual = player.getStat(Stats.MAX_HP);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void maxMpTest(){
        Integer expected = 100;
        Integer actual = player.getStat(Stats.MAX_MP);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void maxXpTest(){
        Integer expected = 100;
        Integer actual = player.getStat(Stats.MAX_XP);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void levelTest(){
        Integer expected = 1;
        Integer actual = player.getStat(Stats.LEVEL);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void increaseStatTest(){
        Player player2 = new Player("Test");
        player2.increaseStat(Stats.LEVEL, 1);

        Integer expected = 2;
        Integer actual = player2.getStat(Stats.LEVEL);

        Assert.assertEquals(expected, actual);
    }




}
