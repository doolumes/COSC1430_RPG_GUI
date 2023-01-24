package Weapons;
import java.lang.Math;

public class Crossbow {
    private static double DAMAGE = 50;
    public int ammo;
    private String name;
    private int cost;
    public Crossbow()
    { // default crossbow is string crossbow
        name = "String Cross Bow";
        cost = 0;
        this.ammo = 10;
    }
    public Crossbow(String crossBowName) { // initializer constructor

        if (crossBowName.toLowerCase() .equals( "gun")) {
            this.name = "Medic Ray"; // With each attack you gain 15 health
            this.cost = 50;
        } else if (crossBowName.toLowerCase() .equals ("bazooka")) {
            this.name = "Ballistic Cannon"; // Damage multiplier of 50%
            this.cost = 35;
        } else if (crossBowName.toLowerCase().equals( "slingshot")) {
            this.name = "Void Slinger"; // 50% chance to double strike
            this.cost = 60;
        } else if (crossBowName.toLowerCase().equals( "crossbow")) {
            this.name = "String Cross Bow";
            this.cost = 0;
        }
        this.ammo = 10;
    }
    public String getName() { return name; } // returns name

    public double getDamage()
    { // returns specific DAMAGE based on which crossbow you have
        if (getName() == "Ballistic Cannon")
        {
            return DAMAGE * 1.5;
        }

        else if (getName() == "Void Slinger")
        { // void slinger has a 50% change to 100% more DAMAGE
            double []array = {DAMAGE, DAMAGE * 2};
            return array[(int)(Math.random() * 2)];
        }

        return DAMAGE;
    }
    public int getCost() { return cost; } // returns energy cost of crossbow
    public int getAmmo() { return ammo; } // returns current ammo
    public void setCrossBow(String crossBowName)
    { // changes crossbow
        if (crossBowName == "gun")
        {
            this.name = "Medic Ray";
            this.cost = 50;
        }

        else if (crossBowName == "bazooka")
        {
            this.name = "Ballistic Cannon";
            this.cost = 35;
        }

        else if (crossBowName == "slingshot")
        {
            this.name = "Void Slinger";
            this.cost = 60;
        }

        else if (crossBowName == "crossbow")
        {
            this.name = "String Cross Bow";
            this.cost = 0;
        }
    }

    public boolean setAmmo()
    { // takes away ammo when player attacks
        boolean shoot;
        if (ammo > 0)
        {
            ammo -= 1;
            shoot = true;
        }
        else
        {
            shoot = false;
        }
        return shoot;
    }
}
