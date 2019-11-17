package com.connor.demo.controllers;

import com.connor.demo.models.Monster;
import com.connor.demo.models.Player;
import com.connor.demo.repositories.MonsterRepository;
import com.connor.demo.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;

@RestController
@RequestMapping(value ="/monsters")
@CrossOrigin
public class MonsterController {

    private MonsterRepository monsterRepository;

    @Autowired
    public MonsterController(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }


    @GetMapping
    public ResponseEntity<Iterable<Monster>> getPlayers() {
        return new ResponseEntity<>(monsterRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{gameFk}")
    public ResponseEntity<Iterable<Monster>> getPlayersByFk(@PathVariable Long gameFk) {
        return new ResponseEntity<>(monsterRepository.findAllByBattleFk(gameFk), HttpStatus.OK);
    }


    @Transactional
    @DeleteMapping("/{gameFk}")
    public ResponseEntity<Long> clearMonsters(@PathVariable Long gameFk) {
        Long result = monsterRepository.deleteAllByBattleFk(gameFk);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
