package Weapons;

public class Spells {
    private String name;
    private int damage;
    private int cost;
    public Spells(String spell)
    { // if statements to set stats for each weapon passed in parameter list
        if (spell.equals( "plasma bolt"))
        { //
            this.name = "Plasma Bolt";
            this.damage = 100;
            this.cost = 50;
        }

        else if (spell.equals( "electrocute"))
        {
            this.name = "Electrocute";
            this.damage = 125;
            this.cost = 175;
        }

        else if (spell.equals( "plasma rain"))
        {
            this.name = "Plasma Rain";
            this.damage = 125;
            this.cost = 75;
        }

        else if (spell.equals( "super charge"))
        { //%200 weapon damage multiplier
            this.name = "Super Charge";
            this.damage = 275;
            this.cost = 325;
        }
        else if (spell.equals( "assimilation"))
        { // returns 50% of damage as mana
            this.name = "Assimilation";
            this.damage = 45;
            this.cost = 0;
        }
    }

    public String getName() { return name; }  // returns spell name
    public int getDamage() { return damage; } // returns spell damage
    public int getCost() { return cost; }     // returns spell cost

}