package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.weapons.*;

import java.util.ArrayList;
import java.util.Random;

// TODO: UPDATE IMPLEMENTATION
public abstract class Enemy implements Entity{
    Weapon weapon;
    private int hp;
    private int mp;

    private int maxHP;
    private int maxMP;

    public Enemy(int hp, int mp, Weapon weapon) {
        this.maxHP = hp;
        this.maxMP = mp;
        this.hp = maxHP;
        this.mp = maxMP;

        this.weapon = weapon;
    }

    // TODO: (BONUS) UPDATE THE FORMULA OF TAKING DAMAGE
    @Override
    public void takeDamage(int damage) {
        hp -= damage;
    }

    public void attack(Entity target) {

        if (this.mp - weapon.getManaCost() < 0) {
            System.out.println(toString() + " ran out of mana ");
        } else {
            target.takeDamage(weapon.getDamage());
            this.mp-= weapon.getManaCost();
            System.out.println(toString() + " damaged " + target.toString()  + " remaining health "+ target.getHp()) ;
        }

    }

    @Override
    public void attack(Entity target, ArrayList<Enemy> targets) {    }

    public int getHp() {
        if (hp >= 0)
            return hp;
        return 0;
    }

    public int getHp(boolean isdead) {
            return hp;

    }
    public int getMp() {
        return mp;
    }

    public Weapon getWeapon() {
        return weapon;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void defend(){
        // TODO: (BONUS) IMPLEMENT A DEFENSE METHOD FOR SHIELDS


    }
    public void heal(int health){
        hp += health;
        if (hp > maxHP) {
            hp = maxHP;
        }
    }

    public void fillMana(int mana){
        mp += mana;
        if (mp > maxMP) {
            mp = maxMP;
        }
    }

    public int getMaxHP(){return maxHP;}

    public int getMaxMP(){return maxMP;}


    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public String toString() {
        return "Enemy default";
    }

    protected static Weapon randomweapon(int damage , int manaCost) {
        Random r = new Random();
        int weaponsNumber = 4;
        int random = r.nextInt(weaponsNumber);
        switch (random) {
            case 0:
                return  new Mele(damage, manaCost);
            case 1:
                return  new Dager(damage, manaCost);
            case 2:
                return  new Sword(damage, manaCost);
            case 3:
                return  new Wand(damage, manaCost);
            default:
                return null;
        }
    }

}
