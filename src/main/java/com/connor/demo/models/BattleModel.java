package com.connor.demo.models;

import com.connor.demo.game.utilities.Dice;
import com.connor.demo.game.creatures.CreatureComparator;
import com.connor.demo.game.creatures.monsters.MonsterFactory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class BattleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long battleId;
    private ArrayList<Player> players;
    private ArrayList<Monster> monsters;
    private ArrayList<Creature> creatures;
    //private Dice d10 = new Dice(10);

    public BattleModel(){}

    public BattleModel(Iterable<Player> players){
        this.players = (ArrayList<Player>) players;
        this.monsters = makeMonsters();
        setUpCreatures();
    }

    public BattleModel(User user){
        this.players = (ArrayList<Player>) user.getUserProfile().getGame().getPlayers();
        this.monsters = makeMonsters();
        setUpCreatures();
    }


    private void setUpCreatures() {
        this.creatures = new ArrayList<>();
        creatures.addAll(this.players);
        creatures.addAll(this.monsters);
        creatures.sort(new CreatureComparator());
    }


    private ArrayList<Monster> makeMonsters(){
        MonsterFactory monsterFactory = new MonsterFactory(this.players);
        Dice dice = new Dice(players.size() * 2);
        int numberOfMonsters = dice.roll();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < numberOfMonsters; i++) {
            monsters.add(monsterFactory.create());
        }
        return monsters;
    }



    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }

    public ArrayList<Creature> getCreatures() {
        return creatures;
    }

    public void setCreatures(ArrayList<Creature> creatures) {
        this.creatures = creatures;
    }


    public Long getBattleId() {
        return battleId;
    }

    public void setBattleId(Long battleId) {
        this.battleId = battleId;
    }
}
