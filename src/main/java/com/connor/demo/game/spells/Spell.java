package com.connor.demo.game.spells;

import com.connor.demo.game.creatures.Stats;
import com.connor.demo.models.Creature;

import java.util.ArrayList;

public abstract class Spell {

    private Element element;
    private int cost;

    public Spell(){}

    public Spell(Element element, int cost){
        this.element = element;
        this.cost = cost;
    }



    public void cast(Creature caster, ArrayList<Creature> targets){
        if (caster.getStat(Stats.MP) - cost >= 0){
            caster.alterStat(Stats.MP, 0 - cost);
        } else {
            System.out.println(caster.getName() + " does not have enough Mana.");
        }
    }


    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
