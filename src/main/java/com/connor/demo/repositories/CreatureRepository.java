package com.connor.demo.repositories;

import com.connor.demo.models.Creature;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatureRepository extends CrudRepository<Creature, Long> {
}
