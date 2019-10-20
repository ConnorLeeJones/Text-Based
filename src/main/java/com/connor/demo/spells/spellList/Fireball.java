package com.connor.demo.spells.spellList;

import com.connor.demo.creatures.Creature;
import com.connor.demo.creatures.stats.Stats;
import com.connor.demo.spells.Element;
import com.connor.demo.spells.Spell;

import java.util.ArrayList;

public class Fireball extends Spell implements Castable {


    public Fireball() {
        super(Element.FIRE, 10);
    }


    @Override
    public void cast() {

    }
}
