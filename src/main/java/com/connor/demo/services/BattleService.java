package com.connor.demo.services;

import com.connor.demo.game.creatures.Stats;
import com.connor.demo.game.utilities.Dice;
import com.connor.demo.models.*;
import com.connor.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class BattleService {

    private BattleRepository repository;
    private UserRepository userRepository;
    private PlayerRepository playerRepository;
    private MonsterRepository monsterRepository;
    private CreatureRepository creatureRepository;


    @Autowired
    public BattleService(BattleRepository repository, UserRepository userRepository, PlayerRepository playerRepository, MonsterRepository monsterRepository, CreatureRepository creatureRepository){
        this.repository = repository;
        this.userRepository = userRepository;
        this.playerRepository = playerRepository;
        this.monsterRepository = monsterRepository;
        this.creatureRepository = creatureRepository;
    }


    public Iterable<BattleModel> findAll(){
        return repository.findAll();
    }

    public BattleModel findBattleById(Long id){
        return repository.findById(id).get();
    }



    @Transactional
    public BattleModel create(Long userId){
        //User user = userRepository.findUserByUserId(userId);
        //System.out.println(userId);
        //ArrayList<Player> players = (ArrayList<Player>) playerRepository.findAllByGameFk(userId);
        //System.out.println(players);
        System.out.println(userId);


        monsterRepository.deleteAllByBattleFk(userId);
        //System.out.println(playerRepository.findAllByGameFk(userId));
        BattleModel battleModel;
        Iterable<Player> players = playerRepository.findAllByGameFk(userId);
        System.out.println(players);

        if (!repository.findById(userId).isPresent()) {
            battleModel = Optional.of(new BattleModel(players, userId)).get();
            for(Monster monster : battleModel.getMonsters()){
                System.out.println(monster);
                monster.setBattleFk(userId);
                this.monsterRepository.save(monster);
            }
        } else {
            battleModel = repository.findById(userId).get();
            battleModel.setMonsters(BattleModel.makeMonsters(battleModel.getPlayers()));
            for(Monster monster : battleModel.getMonsters()){
                System.out.println(monster);
                monster.setBattleFk(userId);
                this.monsterRepository.save(monster);
            }
        }
        //System.out.println(battleModel.getMonsters());
//        System.out.println(battleModel.getCreatures());
      ArrayList<Creature> creatures = new ArrayList<>();
        creatures.addAll(battleModel.getMonsters());
        creatures.addAll(battleModel.getPlayers());
        battleModel.setCreatures(creatures);
        System.out.println("XXXXX");
        System.out.println(battleModel.getPlayers());
        System.out.println("XXXXX_OOOOOOOOOOOADDASDASDASDASDA");
        System.out.println(battleModel.getCreatures());
        System.out.println("XXXXX");


//        for(Monster monster : battleModel.getMonsters()){
//            System.out.println(monster);
//            monster.setGameFk(userId);
//            this.monsterRepository.save(monster);
//        }
        //battleModel.setMonsters((ArrayList<Monster>) monsterRepository.findAllByGameFk(userId));
        System.out.println(battleModel.getMonsters());
        return repository.save(battleModel);
    }


    public BattleModel dealDamage(AttackDTO attackDTO) {
//        Optional<Player> player = Optional.of(playerRepository.findById(attackDTO.getPlayerId()).get());
//        Optional<Monster> monster = monsterRepository.findById(attackDTO.getMonsterId());
        BattleModel battleModel = repository.findById(attackDTO.getBattleId()).orElse(null);
        switch (attackDTO.getChoice()) {
            case "Attack":
                battleModel = attack(attackDTO);
                break;
            default:
                break;
        }
        return repository.save(battleModel);
    }


    public BattleModel attack(AttackDTO attackDTO){
        Creature attacker = creatureRepository.findById(attackDTO.getAttackerId()).orElse(null);
        Creature opponent = creatureRepository.findById(attackDTO.getOpponentId()).orElse(null);

        Dice d10 = new Dice(10);
        int damage = 0;
        if (d10.roll() >= 2) {
            damage -= d10.roll() + attacker.getStat(Stats.STRENGTH);
            System.out.println(attacker.getName() + " dealt " + damage * -1 + " damage to " + opponent.getName() + ".");
        } else {
            System.out.println("Miss!");
        }
        opponent.alterStat(Stats.HP, damage);
//        creatureRepository.save(attacker);
//        creatureRepository.save(opponent);
        return finishAttack(attackDTO);
    }


    public BattleModel finishAttack(AttackDTO attackDTO){
        BattleModel battleModel = repository.findById(attackDTO.getBattleId()).orElse(null);
        ArrayList<Monster> mons = new ArrayList<>();
        for (Monster monster : battleModel.getMonsters()){
            if (monster.getStat(Stats.HP) <= 0){
                creatureRepository.delete(monster);
            } else {
                mons.add(monster);
            }
        }
        for (Player player : battleModel.getPlayers()){
            if (player.getStat(Stats.HP) <= 0){
                player.setStat(Stats.HP, 0);
            }
        }
        battleModel.setMonsters(mons);

        return repository.save(battleModel);
    }







}
