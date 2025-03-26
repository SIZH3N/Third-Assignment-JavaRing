package org.project.object.weapons;

import org.project.entity.Entity;
import org.project.entity.enemies.Enemy;
import org.project.object.Object;
import org.project.object.consumables.Consumable;

import java.util.ArrayList;

// TODO: UPDATE IMPLEMENTATION
public abstract class Weapon implements Object {
    private int damage;
    private int manaCost;
    private int abilityCharge;
    /*
    TODO: ADD OTHER REQUIRED AND BONUS ATTRIBUTES
    */

    public Weapon(int damage, int manaCost) {
        this.damage = damage;
        this.manaCost = manaCost;
    }

    @Override
    public void use(Entity target) {
        target.takeDamage(damage);
    }

    public int getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    /*
    TODO: ADD OTHER REQUIRED AND BONUS METHODS
    */

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }


    // these three methods for unique ability
    public void addAbilityCharge() {
        this.abilityCharge++;
    }

    public void setAbilityCharge(int abilityCharge) {
        this.abilityCharge = abilityCharge;
    }

    public int getAbilityCharge() {
        return abilityCharge;
    }

    public void uniqueAbility(ArrayList<Enemy> targets) {
    }
}

