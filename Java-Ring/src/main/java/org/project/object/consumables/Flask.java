package org.project.object.consumables;

import org.project.entity.Entity;

// TODO: UPDATE IMPLEMENTATION
public class Flask extends Consumable {
    /*
    THIS IS AN EXAMPLE OF A CONSUMABLE DESIGN.
    */
    private int remainingFlasks = 5;


    // TODO: (BONUS) UPDATE USE METHOD
    @Override
    public void use(Entity target) {
        if (remainingFlasks > 0) {
        remainingFlasks--;
        target.heal(target.getMaxHP() / 10);
    } else {
            System.out.println("« no more flasks!! »");
        }
    }
    @Override
    public int getRemainings() {return remainingFlasks; }
    @Override
    public void resetRemainings() {remainingFlasks = 5; }

    @Override
    public String toString() {
        return "flask";
    }
}
