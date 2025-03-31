package org.project.object.consumables;

import org.project.entity.Entity;

public class Manapotion extends Consumable {

    private int remaining = 2;

    @Override
    public void use(Entity target) {
        if (remaining > 0) {
            remaining--;
            target.fillMana(target.getMaxMP() / 3);
        } else {
            System.out.println("« no more mana potion!! »");
        }

    }
    @Override
    public int getRemainings() { return remaining; }
    @Override
    public void resetRemainings() { this.remaining = 2; }

    @Override
    public String toString() {
        return "mana potion";
    }
}
