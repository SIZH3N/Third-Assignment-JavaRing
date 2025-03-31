package org.project.entity;

import org.project.entity.enemies.Enemy;

import java.util.ArrayList;

public interface Entity {
    void attack(Entity target , ArrayList<Enemy> targets);

    void defend();

    void heal(int health);

    void fillMana(int mana);

    void takeDamage(int damage);

    int getMaxHP();

    int getMaxMP();

    int getHp();

    int getMp();

    /*
    TODO: ADD OTHER REQUIRED AND BONUS METHODS
    */
}
