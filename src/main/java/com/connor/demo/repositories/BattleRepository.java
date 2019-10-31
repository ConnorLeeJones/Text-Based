package com.connor.demo.repositories;

import com.connor.demo.models.BattleModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BattleRepository extends CrudRepository<BattleModel, Long> {

}
