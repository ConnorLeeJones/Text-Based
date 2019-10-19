package com.connor.demo.battle;

import com.connor.demo.creatures.Creature;
import com.connor.demo.creatures.CreatureComparator;
import com.connor.demo.creatures.monsters.Monster;
import com.connor.demo.creatures.Player;
import com.connor.demo.creatures.monsters.MonsterFactory;
import com.connor.demo.creatures.stats.Stats;
import dice.Dice;

import java.util.ArrayList;

public class Battle {

    private ArrayList<Player> players;
    private ArrayList<Monster> monsters;
    private MonsterFactory monsterFactory;
    private ArrayList<Creature> creatures;
    private Dice d10 = new Dice(10);
    private Dice d100 = new Dice(100);

    public Battle(){}

    public Battle(ArrayList<Player> players){
        this.players = players;
        this.monsterFactory = new MonsterFactory(players);
        this.monsters = makeMonsters();
        setUpCreatures();
        start();
    }



    public void start(){
        //printCreatures();
        while (checkWin() && checkLose()){
            for (int i = 0; i < creatures.size(); i++) {
                printCreatures();
                Creature creature = creatures.get(i);
                if (creature instanceof Player){
                    playerTurn(creature);
                } else {
                    monsterTurn(creature);
                }
                if (i == creatures.size() - 1){
                    i = 0;
                }
            }
        }
    }




    private void dealDamage(Creature currentCreature, Creature opponent){
        int damage = 0;
        if (currentCreature.getStat(Stats.ACCURACY) + d10.roll() > opponent.getStat(Stats.DEFENSE)) {
            damage -= d10.roll() + currentCreature.getStat(Stats.STRENGTH) - opponent.getStat(Stats.DEFENSE);
        }
        opponent.alterStat(Stats.HP, -10);
    }





    private boolean checkWin(){
        int totalMonsterHealth = 0;
        for (Monster monster : monsters){
            totalMonsterHealth += monster.getStat(Stats.HP);
        }
        return totalMonsterHealth > 0;
    }

    private boolean checkLose(){
        int totalPlayerHealth = 0;
        for (Player player : players){
            totalPlayerHealth += player.getStat(Stats.HP);
        }
        return totalPlayerHealth > 0;
    }

    private void playerTurn(Creature player){
        if (checkCreatureHp(player)){
            dealDamage(player, monsters.get(0));
        } else {
            creatures.remove(player);
            System.out.println(player.getName() + " died.");
        }
    }

    private void monsterTurn(Creature monster){
        if (checkCreatureHp(monster)){
            dealDamage(monster, players.get(0));
        } else {
            creatures.remove(monster);
            System.out.println(monster.getName() + " died.");
        }

    }

    private boolean checkCreatureHp(Creature creature){
        return creature.getStat(Stats.HP) > 0;
    }


    private void setUpCreatures() {
        this.creatures = new ArrayList<>();
        creatures.addAll(this.players);
        creatures.addAll(this.monsters);
        creatures.sort(new CreatureComparator());
    }


    private ArrayList<Monster> makeMonsters(){
        Dice dice = new Dice(players.size());
        int numberOfMonsters = dice.roll();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < numberOfMonsters; i++) {
            monsters.add(this.monsterFactory.create());
        }
        return monsters;
    }


    private void printCreatures(){
        for (Creature creature : this.creatures){
            System.out.println(creature.getName() + "   HP: " + creature.getStat(Stats.HP));
        }
    }




}
