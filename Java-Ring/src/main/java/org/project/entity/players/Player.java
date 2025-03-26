package org.project.entity.players;

import org.project.entity.Entity;
import org.project.entity.enemies.Enemy;
import org.project.object.armors.Armor;
import org.project.object.consumables.Consumable;
import org.project.object.consumables.Flask;
import org.project.object.consumables.Healingpotion;
import org.project.object.consumables.Manapotion;
import org.project.object.weapons.Weapon;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Scanner;

// TODO: UPDATE IMPLEMENTATION
public abstract class Player implements Entity {
    protected String name;

    Weapon weapon;
    Armor armor;
    Consumable consumable;

    private int hp;
    private int maxHP;
    private int mp;
    private int maxMP;
    private ArrayList<Consumable> consumables;

    public Player(String name, int hp, int mp, Weapon weapon, Armor armor) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.maxHP = hp;
        this.maxMP = mp;

        this.weapon = weapon;
        this.armor = armor;


        //player potions
        consumables = new ArrayList<>();
        consumables.add(new Healingpotion());
        consumables.add(new Manapotion());
        consumables.add(new Flask());

    }

    public void useConsumable() {
        Scanner scanner = new Scanner(System.in);
        int action = 0;
        do {
            System.out.println("\n -Select the potion's index: " +
                    "\n 1-Healing potion: gives you 1/5 of your Max Hp. remaining potions: " + consumables.get(2).getRemainings() +
                    "\n 2-Mana potion: gives you 1/3 of your Max Mana. remaining potions: " + consumables.get(1).getRemainings() +
                    "\n 3-Flask: gives you 1/10 of your Max HP. remaining flasks: " + consumables.get(0).getRemainings());
            action = scanner.nextInt();
            if(action >= 1 && action <= 3){
                consumables.get(action-1).use(this);
            } else {
                System.out.println("invalid action!");
            }

        } while (!(action >= 1 && action <= 3));
    }

    public void resetConsumables() {
        for (Consumable consumable : consumables) {
            consumable.resetRemainings();
        }
    }


    @Override
    public void attack(Entity target, ArrayList<Enemy> targets) {
        if (this.mp - weapon.getManaCost() < 0) {
            System.out.println(toString() + " ran out of mana ");
        } else {
            target.takeDamage(weapon.getDamage());
            this.mp -= weapon.getManaCost();
            System.out.println(toString() + " damaged " + target.toString() + " remaining health " + target.getHp());
            weapon.addAbilityCharge();
        }
    }

    @Override
    public void defend() {
        armor.defend();
        // TODO: (BONUS) IMPLEMENT A DEFENSE METHOD FOR SHIELDS
    }


    // TODO: (BONUS) UPDATE THE FORMULA OF TAKING DAMAGE
    @Override
    public void takeDamage(int damage) {
        if (damage - armor.getDefense() > 0)
            hp -= damage - armor.getDefense();
    }

    @Override
    public void heal(int health) {
        hp += health;
        if (hp >= maxHP) {
            hp = maxHP;
        }
    }

    @Override
    public void fillMana(int mana) {
        mp += mana;
        if (mp > maxMP) {
            mp = maxMP;
        }
    }


    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public int getMaxHP() {
        return maxHP;
    }

    public int getMp() {
        return mp;
    }

    @Override
    public int getMaxMP() {
        return maxMP;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void repairArmor() {
        armor.repair();
        System.out.println("\n" + armor.toString());
    }

    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
