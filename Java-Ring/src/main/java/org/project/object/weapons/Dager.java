package org.project.object.weapons;

import org.project.entity.enemies.Enemy;

import java.util.ArrayList;

public class Dager extends Weapon {

    private String playerName = null;


    public Dager(int damage, int manaCost) {
        super(damage, manaCost);
    }

    public void uniqueAbility(ArrayList<Enemy> targets) {
        // if the abilitycharger goes more than 3 the unique ability starts
        int id = 0, maxHp = 0;

        for (int i = 0; i < targets.size(); i++) {
            if (targets.get(i).getHp() > maxHp) {
                maxHp = targets.get(i).getHp();
                id = i;
            }
        }

        targets.get(id).takeDamage(maxHp / 2);
        System.out.println("___"+targets.get(id).toString()+ " is down to their last sliver of health as "+playerName+" unleashes a brutal finisher!   remaining health: " + targets.get(id).getHp());


    }


    public void getPlayerName(String playerName) {
        this.playerName = playerName;
    }


}
