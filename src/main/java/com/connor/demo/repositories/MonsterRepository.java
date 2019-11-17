package com.connor.demo.repositories;

import com.connor.demo.models.Game;
import com.connor.demo.models.Monster;
import com.connor.demo.models.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonsterRepository extends CrudRepository<Monster, Long> {

    //Iterable<Monster> finAllByBa
    Iterable<Monster> findAllByBattleFk(Long userId);

    Long deleteAllByBattleFk(Long userId);
}