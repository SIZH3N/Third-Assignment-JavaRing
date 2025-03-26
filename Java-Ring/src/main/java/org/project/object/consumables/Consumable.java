package org.project.object.consumables;

import org.project.entity.Entity;
import org.project.object.Object;

// TODO: UPDATE IMPLEMENTATION
public abstract class Consumable implements Object {


    public void use(Entity target) {}
    /*
    TODO: ADD OTHER REQUIRED AND BONUS METHODS
    */

    @Override
    public String toString() {
        return "consumable";
    }

    public int getRemainings(){System.out.println("wrong consumable object call"); return 0;}
    public void resetRemainings(){}
}
