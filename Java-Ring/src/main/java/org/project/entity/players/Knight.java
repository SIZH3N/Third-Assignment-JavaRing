package org.project.entity.players;

import org.project.entity.Entity;
import org.project.entity.enemies.Enemy;
import org.project.object.armors.Armor;
import org.project.object.armors.KnightArmor;
import org.project.object.weapons.Sword;
import org.project.object.weapons.Weapon;

import java.util.ArrayList;

// TODO: UPDATE IMPLEMENTATION
public class Knight extends Player {
//    private int hp = 40;
//    private int mp = 20;
    private int manaRegeneration=3;
//    private Weapon playerWeapon = new Sword(10, 7);
//    private Armor playerArmor = new KnightArmor(4, 3);

    public Knight(String name) {
        super(name, 40 , 20, new Sword(10, 7), new KnightArmor(4, 3));
    }

    @Override
    public void attack(Entity target , ArrayList<Enemy> targets) {
        super.attack(target, targets);
        super.fillMana(manaRegeneration);
        if (3 == weapon.getAbilityCharge()) {
            weapon.uniqueAbility(targets);
            weapon.setAbilityCharge(0);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "(Knight)";
    }

    // TODO: DESIGN KNIGHT'S WEAPON AND ARMOR AND IMPLEMENT THE CONSTRUCTOR
}
