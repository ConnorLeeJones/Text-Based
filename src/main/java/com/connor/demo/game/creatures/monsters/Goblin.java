package com.connor.demo.game.creatures.monsters;

import com.connor.demo.models.Monster;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
//@DiscriminatorValue("Goblin")
public class Goblin extends Monster  {




    public Goblin(String name, Integer level) {
        super(name, level);
    }


}
