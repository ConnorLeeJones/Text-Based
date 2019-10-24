package com.connor.demo.models.dice;

import com.connor.demo.game.utilities.Dice;
import org.junit.Assert;
import org.junit.Test;


public class DiceTest {

    private Dice dice = new Dice(6);

    @Test
    public void diceTest1(){
        boolean success = true;
        for (int i = 0; i < 100; i++){
            int roll = dice.roll();
            if (roll < 1 || roll > 6){
                success = false;
                break;
            }
            System.out.println(roll);
        }
        Assert.assertTrue(success);
    }


    
}
