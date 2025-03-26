package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.weapons.Fire;

public class Dragon extends Enemy{

    private boolean attacked = false;
    private int manaRegeneration = 5;

    public Dragon() {
        super(40,20,new Fire(12,16));
    }

    @Override
    public String toString() {
        return "Dragon";
    }

    @Override
    public void attack(Entity target) {
        if (attacked) {
            System.out.println(target.toString() + " is  burning. " + "available health " + target.getHp());
            target.takeDamage(super.weapon.getDamage() / 4);
            attacked = false;
        }
        int mpBoforeAttack = getMp();
        super.attack(target);
        if (mpBoforeAttack != getMp())
            attacked = true;
        super.fillMana(manaRegeneration);
    }


}
