package com.connor.demo.battle;

import com.connor.demo.creatures.monsters.Monster;
import com.connor.demo.creatures.Player;

import java.util.ArrayList;
import java.util.List;

public class Battle {

    private List<Player> players;
    private List<Monster> monsters;

    public Battle(){}

    public Battle(ArrayList<Player> players, ArrayList<Monster> monsters){
        this.players = players;
        this.monsters = monsters;
    }

    public static void start(){


    }



}
