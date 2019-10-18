package com.connor.demo.creatures;

import java.util.HashMap;

public abstract class Creature {

    private String name;
    private HashMap<String, Integer> stats;
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

    private static HashMap<String, Integer> initStats(){
        HashMap<String, Integer> newStats = new HashMap<>();
        newStats.put("Strength", 10);
        newStats.put("Defense", 10);
        newStats.put("Mana", 10);
        newStats.put("Speed", 10);
        newStats.put("Stealth", 10);
        newStats.put("Accuracy", 10);

        newStats.put("HP", 100);
        newStats.put("MP", 100);
        newStats.put("XP", 0);
        newStats.put("MaxHP", 100);
        newStats.put("MaxMP", 100);
        newStats.put("MaxXP", 100);
        newStats.put("Level", 1);
        return newStats;
    }

    private static HashMap<String, Integer> initInventory(){
        HashMap<String, Integer> newInventory = new HashMap<>();
        newInventory.put("Gold", 10);
        return newInventory;
    }


    protected void IncreaseStat(String stat, Integer value){
        this.stats.merge(stat, value, Integer::sum);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Integer> getStats() {
        return stats;
    }

    public void setStats(HashMap<String, Integer> stats) {
        this.stats = stats;
    }

    public HashMap<String, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(HashMap<String, Integer> inventory) {
        this.inventory = inventory;
    }
}
