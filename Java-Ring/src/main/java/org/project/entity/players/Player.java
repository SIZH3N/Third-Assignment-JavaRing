package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.armors.Armor;
import org.project.object.weapons.Weapon;

//TODO: UPDATE IMPLEMENTATION
public abstract class Player implements Entity
{
    protected String name;

    private int hp;
    private int maxHP;
    private int mp;
    private int maxMP;

    Weapon weapon;
    Armor  armor;

    public Player (String name, int hp, int mp, Weapon weapon, Armor armor)
    {
        this.name = name;
        this.hp   = hp;
        this.mp   = mp;

        this.weapon = weapon;
        this.armor  = armor;
    }

    //TODO: (BONUS) UPDATE THE FORMULA OF TAKING DAMAGE
    @Override
    public void takeDamage (int damage)
    {
        hp -= damage - armor.getDefense ();
    }

    @Override
    public void heal (int health)
    {
        hp += health;
        if (hp > maxHP)
        {
            hp = maxHP;
        }
    }

    public String getName ()
    {
        return name;
    }

    public int getHp ()
    {
        return hp;
    }

    @Override
    public int getMaxHP ()
    {
        return maxHP;
    }

    public int getMp ()
    {
        return mp;
    }

    @Override
    public int getMaxMP ()
    {
        return maxMP;
    }

    public Weapon getWeapon ()
    {
        return weapon;
    }

    public Armor getArmor ()
    {
        return armor;
    }
}
