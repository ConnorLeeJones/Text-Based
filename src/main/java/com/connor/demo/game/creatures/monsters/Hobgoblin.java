package com.connor.demo.game.creatures.monsters;

import com.connor.demo.models.Monster;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorValue("Hobgoblin")
public class Hobgoblin extends Monster  implements Serializable {

    public Hobgoblin(String name, Integer level) {
        super(name, level);
    }

}
