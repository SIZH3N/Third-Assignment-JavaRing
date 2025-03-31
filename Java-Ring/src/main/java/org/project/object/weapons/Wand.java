package org.project.object.weapons;

import org.project.entity.enemies.Enemy;

import java.util.ArrayList;

public class Wand extends Weapon{
    public Wand( int damage,  int manaCost) {
        super(damage,manaCost);
    }

    @Override
    public void uniqueAbility(ArrayList<Enemy> targets) {
        for ( Enemy e : targets) {
            e.fillMana(-(e.getMp() / 2));
            System.out.println("___"+e.toString() + "'s mana is reduced to " + e.getMp() + " by the wizard's wand.");
        }
    }
}
