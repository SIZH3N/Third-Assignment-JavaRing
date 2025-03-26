package org.project.entity.players;

import org.project.entity.Entity;
import org.project.entity.enemies.Enemy;
import org.project.object.armors.WizardArmor;
import org.project.object.weapons.Wand;

import java.util.ArrayList;

public class Wizard extends Player{

    private int manaRegeneration = 5;
    private int healthRegeneration = 5;

    public Wizard(String name) {
        super(name,20,40,new Wand(7,7),new WizardArmor(2,7));
    }

    @Override
    public void attack(Entity target, ArrayList<Enemy> targets) {
        super.attack(target, targets);
        super.fillMana(manaRegeneration);
        super.heal(healthRegeneration);
        if (3 == weapon.getAbilityCharge()) {
            weapon.uniqueAbility(targets);
            weapon.setAbilityCharge(0);
        }
    }

    @Override
    public String toString() {
        return   super.toString() + "(Wizard)";
    }
}
