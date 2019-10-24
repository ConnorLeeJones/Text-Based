package com.connor.demo.game.battle;

import com.connor.demo.game.utilities.Dice;
import com.connor.demo.game.creatures.Creature;
import com.connor.demo.game.creatures.CreatureComparator;
import com.connor.demo.game.creatures.Player;
import com.connor.demo.game.creatures.Stats;
import com.connor.demo.game.creatures.monsters.Monster;
import com.connor.demo.game.creatures.monsters.MonsterFactory;

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
        printCreatures();
        //while (!checkWin() && !checkLose()){
            for (int i = 0; i < creatures.size(); i++) {
                i -= checkAllCreaturesHp();
                Creature creature = creatures.get(i);
                //printCreatures();


                if (checkWin() || checkLose()) {
                    break;
                } else if (creature instanceof Player){
                    printCreatures();
                    playerTurn(creature);
                } else {
                    monsterTurn(creature);
                }
//                checkAllCreaturesHp();
//                if (checkWin() || checkLose()) break;
//                printCreatures();
                if (i == creatures.size() - 1){
                    i = 0;
                }
            }
        //}




    }




    private void dealDamage(Creature currentCreature, Creature opponent){
//        int damage = 0;
//        if (currentCreature.getStat(Stats.ACCURACY) + d10.roll() > opponent.getStat(Stats.DEFENSE)) {
//            damage -= d10.roll() + currentCreature.getStat(Stats.STRENGTH) - opponent.getStat(Stats.DEFENSE);
//        }
//        opponent.alterStat(Stats.HP, damage);

        int damage = 0;
        if (d10.roll() >= 2) {
            damage -= d10.roll() + currentCreature.getStat(Stats.STRENGTH);
            System.out.println(currentCreature.getName() + " dealt " + damage * -1 + " damage to " + opponent.getName() + ".");
        } else {
            System.out.println("Miss!");
        }
        opponent.alterStat(Stats.HP, damage);
    }





    private boolean checkWin(){
        int totalMonsterHealth = 0;
        for (Monster monster : monsters){
            totalMonsterHealth += monster.getStat(Stats.HP);
        }
        //System.out.println("Total Monster Health:" + totalMonsterHealth);
        return totalMonsterHealth <= 0;
    }

    private boolean checkLose(){
        int totalPlayerHealth = 0;
        for (Player player : players){
            totalPlayerHealth += player.getStat(Stats.HP);
        }
        //System.out.println("Total Player Health:" + totalPlayerHealth);
        return totalPlayerHealth <= 0;
    }

    private void playerTurn(Creature player){
        if (checkCreatureHp(player)){
            dealDamage(player, monsters.get(0));
        } else {
            System.out.println(player.getName() + " died.");
        }
    }

    private void monsterTurn(Creature monster){
        if (checkCreatureHp(monster)){
            dealDamage(monster, players.get(0));
        } else {
            System.out.println(monster.getName() + " died.");
        }
    }

    private boolean checkCreatureHp(Creature creature){
        return creature.getStat(Stats.HP) > 0;
    }

    private int checkAllCreaturesHp(){
        //ArrayList<Creature> deadCreatures = new ArrayList<>();
        ArrayList<Creature> deadPlayers = new ArrayList<>();
        ArrayList<Creature> deadMonsters = new ArrayList<>();
        for (Creature creature : creatures){
            if (creature.getStat(Stats.HP) <= 0){
                if (creature instanceof Player) {
                    deadPlayers.add(creature);
                } else {
                    deadMonsters.add(creature);
                }
                System.out.println(creature.getName() + " died.");
            }
        }
        creatures.removeAll(deadPlayers);
        creatures.removeAll(deadMonsters);
        players.removeAll(deadPlayers);
        monsters.removeAll(deadMonsters);
        //System.out.println(deadMonsters);
        //System.out.println(deadPlayers);
        return deadPlayers.size() + deadMonsters.size();
    }



    private void setUpCreatures() {
        this.creatures = new ArrayList<>();
        creatures.addAll(this.players);
        creatures.addAll(this.monsters);
        creatures.sort(new CreatureComparator());
    }


    private ArrayList<Monster> makeMonsters(){
        Dice dice = new Dice(players.size() * 2);
        int numberOfMonsters = dice.roll();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < numberOfMonsters; i++) {
            monsters.add(this.monsterFactory.create());
        }
        return monsters;
    }


    private void printCreatures(){
        String bars = String.format("%50s", "").replace(' ', '=');
        System.out.println("\n" + "Party" + "\n" + bars);
        for (Player player : this.players){
            System.out.printf("%-15s", player.getName());
            System.out.printf("%-20s", "HP: " + player.getStat(Stats.HP) + "/" + player.getStat(Stats.MAX_HP));
            System.out.printf("%-15s", "MP: " +  player.getStat(Stats.MP) + "/" + player.getStat(Stats.MAX_MP));
            System.out.println();
            //System.out.println("\n" + bars.replace("=", "-"));
        }
        System.out.println(bars + "\n\n" + "Enemies" + "\n" + bars);

        for (Monster monster : this.monsters){
            System.out.printf("%-15s", monster.getName());
            System.out.printf("%-20s", "HP: " + monster.getStat(Stats.HP) + "/" + monster.getStat(Stats.MAX_HP));
            System.out.printf("%-15s", "MP: " +  monster.getStat(Stats.MP) + "/" + monster.getStat(Stats.MAX_MP));
            System.out.println();
            //System.out.println("\n" + bars.replace("=", "-"));
        }
        System.out.println(bars);
    }




}
