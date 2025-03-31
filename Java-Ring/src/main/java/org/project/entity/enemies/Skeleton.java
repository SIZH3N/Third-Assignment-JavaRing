package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.entity.players.Knight;
import org.project.object.armors.Armor;
import org.project.object.weapons.Dager;
import org.project.object.weapons.Weapon;

// TODO: UPDATE IMPLEMENTATION
public class Skeleton extends Enemy {

    private boolean notDeadYet = true;
    private int manaRegeneration = 2;

    public Skeleton() {
//        int hp = 20;
//        int mp = 7;
//        Weapon weapon =new (bow , spire , hand)
//        Weapon weapon = null;
        super(20, 10, new Dager(2, 5));

    }

    @Override
    public String toString() {
        return "Skeleton";
    }

    @Override
    public void attack(Entity target) {
        super.attack(target);
        super.fillMana(manaRegeneration);
    }

    @Override
    public boolean isAlive() {
        if (!super.isAlive() && notDeadYet) {
             notDeadYet = false;
             super.heal(10 - getHp(true));
             super.fillMana(manaRegeneration * 2);

             System.out.println(" -"+toString() + " came back from death. remaining health " + super.getHp());

             return true;
        }
return super.isAlive();
    }

    // TODO: DESIGN ENEMY'S WEAPON AND ARMOR AND IMPLEMENT THE CONSTRUCTOR
}
