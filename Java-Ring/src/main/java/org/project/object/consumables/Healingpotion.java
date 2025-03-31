package org.project.object.consumables;

import org.project.entity.Entity;

public class Healingpotion extends Consumable{
    private int remaining=2;
    @Override
    public void use(Entity target) {
        if(remaining > 0)
        {
            remaining--;
            target.heal(target.getMaxHP()/5);
        } else {
            System.out.println("« no more potions!! »");
        }
    }

    @Override
    public int getRemainings() {
        return remaining;
    }

    @Override
    public void resetRemainings() {
        remaining = 2;
    }

    @Override
    public String toString() {
        return "Healing potion";
    }
}
