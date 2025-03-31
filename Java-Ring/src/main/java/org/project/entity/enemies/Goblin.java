package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.weapons.Dager;
import org.project.object.weapons.Mele;
import org.project.object.weapons.Weapon;

import javax.print.attribute.standard.PrinterMakeAndModel;

public class Goblin extends Enemy{

    int manaRegeneration = 3;

    public Goblin() {
//        super(10,5, new Mele(1,1));
        super(10,7, new Dager(2,6));
    }

    @Override
    public String toString() {
        return "Goblin";
    }

    @Override
    public void attack(Entity target) {
        super.attack(target);
        super.fillMana(manaRegeneration);
    }
}
