package Weapons;

public class Weapon{
    private String name;
    private int damage;
    private int cost;

    public Weapon(){
        name = "Club of Disgrace";
        damage = 15;
        cost = 10;
    }

    public Weapon(String weaponName){
        if (weaponName == "sword")
        {
            this.name = "Sword of the Divine";
            this.damage = 27;
            this.cost = 20;
        }

        else if (weaponName == "axe")
        {
            this.name = "Axe of Terror";
            this.damage = 22;
            this.cost = 12;
        }

        else if (weaponName == "pitch fork")
        {
            this.name = "Pitch Fork of Death";
            this.damage = 35;
            this.cost = 50;
        }

        else if (weaponName == "club")
        {
            this.name = "Club of Disgrace";
            this.damage = 15;
            this.cost = 10;
        }
    }
    String getName() { return name; }  // returns weapon name
    public int getDamage() { return damage; } // returns weapon damage
    public int getCost() { return cost; }     // returns weapon cost

    public void setWeapon(String weaponName) { // ability to change weapons so this function is needed
        if (weaponName == "sword") {
            this.name = "Sword of the Divine";
            this.damage = 27;
            this.cost = 20;
        } else if (weaponName == "axe") {
            this.name = "Axe of Terror";
            this.damage = 22;
            this.cost = 12;
        } else if (weaponName == "pitch fork") {
            this.name = "Pitch Fork of Death";
            this.damage = 35;
            this.cost = 50;
        } else if (weaponName == "club") {
            this.name = "Club of Disgrace";
            this.damage = 15;
            this.cost = 10;
        }
    }

}
