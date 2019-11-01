package com.connor.demo.game.creatures.monsters;

import com.connor.demo.models.Monster;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
//@DiscriminatorValue("Wolf")
public class Wolf extends Monster {


    public Wolf(String name, Integer level) {
        super(name, level);
    }


}
