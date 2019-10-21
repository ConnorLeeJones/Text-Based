package com.connor.demo.models.spells.spellList;

import com.connor.demo.models.spells.Element;
import com.connor.demo.models.spells.Spell;

public class Fireball extends Spell implements Castable {


    public Fireball() {
        super(Element.FIRE, 10);
    }


    @Override
    public void cast() {

    }
}
