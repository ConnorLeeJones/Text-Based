package com.connor.demo.controllers;

import com.connor.demo.models.*;
import com.connor.demo.repositories.PlayerRepository;
import com.connor.demo.services.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value ="/battles")
@CrossOrigin
public class BattleController {

    private BattleService service;

    @Autowired
    public BattleController(BattleService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<Iterable<BattleModel>> getBattleModels() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<BattleModel> createBattleModel(@RequestBody Collection<Player> players) {
//        try {
//            return new ResponseEntity<>(service.create(players), HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//    }

    @PutMapping
    public ResponseEntity<BattleModel> battleAttack(@RequestBody AttackDTO attackDTO) {

        return new ResponseEntity<>(service.dealDamage(attackDTO), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BattleModel> createBattleModel(@RequestBody PlayerDTO playerDTO) {

        return new ResponseEntity<>(service.create(playerDTO.getGameId()), HttpStatus.CREATED);
    }
//        catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
    //}


//        catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
    //}

}


