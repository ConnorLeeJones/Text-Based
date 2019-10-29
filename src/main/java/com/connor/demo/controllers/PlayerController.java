package com.connor.demo.controllers;

import com.connor.demo.models.Player;
import com.connor.demo.models.User;
import com.connor.demo.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/players")
@CrossOrigin
public class PlayerController {

    private PlayerService service;

    @Autowired
    public PlayerController(PlayerService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<Iterable<Player>> getPlayers() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player, @RequestBody User user) {
        try {
            return new ResponseEntity<>(service.create(player.getName(), user.getUserProfile().getGame()), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
