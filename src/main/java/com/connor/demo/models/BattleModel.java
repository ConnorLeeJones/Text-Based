package com.connor.demo.models;

import com.connor.demo.game.utilities.Dice;
import com.connor.demo.game.creatures.CreatureComparator;
import com.connor.demo.game.creatures.monsters.MonsterFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BattleModel {

    @Id
    private Long battleId;
    @OneToMany(targetEntity=Creature.class)
    @JoinColumn(name = "gameFk")
    private List<Player> players;
    @OneToMany(targetEntity=Creature.class)
    @JoinColumn(name = "gameFk")
    private List<Monster> monsters;
    @OneToMany(targetEntity=Creature.class)
    @JoinColumn(name = "gameFk")
    private List<Creature> creatures;
    //private Dice d10 = new Dice(10);
    //private static final long serialVersionUID = -7377522010549726139L;


    public BattleModel(){}

    public BattleModel(Iterable<Player> players, Long userId){
        this.players = (ArrayList<Player>) players;
        this.monsters = makeMonsters();
        this.battleId = userId;
        setUpCreatures();
    }

    public BattleModel(User user){
        this.players = (ArrayList<Player>) user.getUserProfile().getGame().getPlayers();
        this.monsters = makeMonsters();
        this.battleId = user.getUserId();
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



    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }

    public List<Creature> getCreatures() {
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
