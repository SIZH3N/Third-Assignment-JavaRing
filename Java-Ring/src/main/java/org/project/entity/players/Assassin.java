package org.project.entity.players;

import org.project.entity.Entity;
import org.project.entity.enemies.Enemy;
import org.project.object.armors.AssassinArmor;
import org.project.object.weapons.Dager;

import java.util.ArrayList;

public class Assassin extends Player {

    private int manaRegeneration = 1;
    private final int damageIncrease = 4;
    private int damagebuff = 0;


    public Assassin(String name) {
        super(name, 30, 20, new Dager(3, 3), new AssassinArmor(3, 5));
    }

    @Override
    public void attack(Entity target, ArrayList<Enemy> targets) {
        super.weapon.setDamage(this.damageIncrease + super.weapon.getDamage());

        super.attack(target, targets);

        super.fillMana(manaRegeneration);
        damagebuff += damageIncrease;

        if (3 == weapon.getAbilityCharge()) {
            if (weapon instanceof Dager) {
                Dager weap = (Dager) weapon;
                weap.getPlayerName(toString());

                weap.uniqueAbility(targets);
                weapon.setAbilityCharge(0);
            }
        }
    }

    @Override
    public String toString() {
        return  super.toString() + "(Assassin)";
    }
}
