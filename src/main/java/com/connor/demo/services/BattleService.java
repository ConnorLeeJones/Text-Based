package com.connor.demo.services;

import com.connor.demo.game.creatures.Stats;
import com.connor.demo.game.utilities.Dice;
import com.connor.demo.models.*;
import com.connor.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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




    public BattleModel create(Long userId){
        //User user = userRepository.findUserByUserId(userId);
        //System.out.println(userId);
        //ArrayList<Player> players = (ArrayList<Player>) playerRepository.findAllByGameFk(userId);
        //System.out.println(players);
        System.out.println(playerRepository.findAllByGameFk(userId));
        BattleModel battleModel;
        if (!repository.findById(userId).isPresent()) {
            battleModel = Optional.of(new BattleModel(playerRepository.findAllByGameFk(userId), userId)).get();
        } else {
            battleModel = repository.findById(userId).get();
        }
        System.out.println(battleModel.getMonsters());
        System.out.println(battleModel.getCreatures());
//        ArrayList<Creature> creatures = new ArrayList<>();
//        creatures.addAll()
        for(Monster monster : battleModel.getMonsters()){
            this.monsterRepository.save(monster);
        }
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


    public  BattleModel attack(AttackDTO attackDTO){
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
        creatureRepository.save(attacker);
        creatureRepository.save(opponent);
        return repository.findById(attackDTO.getBattleId()).orElse(null);
    }







}
