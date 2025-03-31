package org.project.object.armors;

import org.project.entity.Entity;

public class AssassinArmor extends Armor{
    public AssassinArmor(int defence ,int durability) {
        super(defence,durability);
    }

    @Override
    public void use(Entity target) {
        //todo : when defence mode is for wizard he is immune to any damage but it decrease the damage strike
    }

    @Override
    public String toString() {
        return "Assassin armor "+super.toString();
    }
}
