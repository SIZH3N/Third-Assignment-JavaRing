package org.project.object.armors;

import org.project.entity.Entity;

public class WizardArmor extends Armor{
    public WizardArmor(int defence ,int durability) {
        super(defence,durability);
    }

    @Override
    public void use(Entity target) {
        //todo : when defence mode is for wizard it takes more mana from the enemy to attack while also reduce their damage by 200% ratio
    }

    @Override
    public String toString() {
        return "Wizard armor "+super.toString();
    }
}
