package com.connor.demo.game.creatures.monsters;

import com.connor.demo.models.Monster;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorValue("Bear")
public class Bear extends Monster {

    public Bear(String name, Integer level) {
        super(name, level);
    }

    public Bear() {
        super();
    }
}
