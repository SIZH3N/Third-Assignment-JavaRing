package org.project.object.armors;

import org.project.entity.Entity;

// TODO: UPDATE IMPLEMENTATION
public class KnightArmor extends Armor {
   public KnightArmor(int durability, int defense) {
       super(durability, defense);
   }

    @Override
    public void use(Entity target) {
         // todo: use armor means not to attack and just defence after that you gain more mana
    }

    @Override
    public String toString() {
        return "Knight armor "+super.toString();
    }

    // TODO: DESIGN ARMOR'S ATTRIBUTES IMPLEMENT THE CONSTRUCTOR
}