package com.connor.demo.controllers;

import com.connor.demo.models.Player;
import com.connor.demo.models.PlayerDTO;
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

    @GetMapping("/{gameFk}")
    public ResponseEntity<Iterable<Player>> getPlayersByFk(@PathVariable Long gameFk) {
        return new ResponseEntity<>(service.findByGameFk(gameFk), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findOne(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
        return new ResponseEntity<>(service.update(player), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody PlayerDTO playerDTO) {
        try {
            return new ResponseEntity<>(service.create(playerDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
