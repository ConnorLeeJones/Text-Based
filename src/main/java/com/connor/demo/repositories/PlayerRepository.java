package com.connor.demo.repositories;

import com.connor.demo.models.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

    Iterable<Player> findAllByGameFk(Long gameFk);
}

