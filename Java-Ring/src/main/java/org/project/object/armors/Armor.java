package org.project.object.armors;

import org.project.entity.Entity;
import org.project.object.Object;

// TODO: UPDATE IMPLEMENTATION
public abstract class Armor implements Object {
    private int defense;
    private int maxDefense;
    private int durability;
    private int maxDurability;
    private  boolean isDefencing = false;

    private boolean isBroke;

    public Armor(int defense, int durability) {
        this.defense = defense;
        this.durability = durability;

        this.maxDurability = durability;
        this.maxDefense = defense;
    }

    public void defend(){
        isDefencing = true;
        defense *= 2;
    }

    public void setISdefencing(boolean isDefencing){
        this.isDefencing = isDefencing;
        if (!isDefencing){
            defense = maxDefense;
        }

    }

    public void checkBreak() {
        if (durability <= 0) {
            isBroke = true;
            defense = 0;
        }
    }

    // TODO: (BONUS) UPDATE THE REPAIR METHOD
    public void repair() {
        isBroke = false;
        defense = maxDefense;
        durability = maxDurability;
    }

    public int getDefense() {

        if (!isDefencing) {
            durability -= 1;
            checkBreak();
        }
        return defense;
    }

    public int getDurability() {
        return durability;
    }

    public boolean isBroke() {
        return isBroke;
    }

    public String toString() {
        return "-Durability: " + maxDurability + "  -Defense: " + maxDefense;
    }


}
