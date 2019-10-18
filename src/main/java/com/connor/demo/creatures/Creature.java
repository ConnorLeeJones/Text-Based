package com.connor.demo.creatures;

import java.util.HashMap;

public abstract class Creature {

    private String name;
    private HashMap<Stats, Integer> stats;
    private HashMap<String, Integer> inventory;

    public Creature(){
        this.name = "NPC";
        this.stats = initStats();
        this.inventory = initInventory();
    }

    public Creature(String name){
        this.name = name;
        this.stats = initStats();
        this.inventory = initInventory();
    }

    private static HashMap<Stats, Integer> initStats(){
        HashMap<Stats, Integer> newStats = new HashMap<>();
        newStats.put(Stats.STRENGTH, 10);
        newStats.put(Stats.DEFENSE, 10);
        newStats.put(Stats.MANA, 10);
        newStats.put(Stats.SPEED, 10);
        newStats.put(Stats.ACCURACY, 10);

        newStats.put(Stats.HP, 100);
        newStats.put(Stats.MP, 100);
        newStats.put(Stats.XP, 0);
        newStats.put(Stats.MAX_HP, 100);
        newStats.put(Stats.MAX_MP, 100);
        newStats.put(Stats.MAX_XP, 100);
        newStats.put(Stats.LEVEL, 1);
        return newStats;
    }

    private static HashMap<String, Integer> initInventory(){
        HashMap<String, Integer> newInventory = new HashMap<>();
        newInventory.put("Gold", 10);
        return newInventory;
    }


    protected void increaseStat(Stats stat, Integer value){
        this.stats.merge(stat, value, Integer::sum);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Stats, Integer> getStats() {
        return stats;
    }

    public void setStats(HashMap<Stats, Integer> stats) {
        this.stats = stats;
    }

    public HashMap<String, Integer> getInventory() {
        return inventory;
    }

    public Integer getStat(Stats stat){
        return this.stats.get(stat);
    }

    public void setInventory(HashMap<String, Integer> inventory) {
        this.inventory = inventory;
    }
}
