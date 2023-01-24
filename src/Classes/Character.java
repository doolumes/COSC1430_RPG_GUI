package Classes;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public abstract class Character {
    //key handling, remove later
    public static double HEALTH_BAR_WIDTH = 150;
    public static int HEALTH_BAR_HEIGHT = 25;
    public static double MAX_HEALTH;
    public static double MAX_ENERGY = 1000;
    public int x,y;
    public int speed;

    public BufferedImage t0,t1,t2,t3,t4,t5,t6,t7, t8, t9, t10, t11, t12, t13, t14;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
    public int startingPosition;
    private String characterClass;
    private String name;
    private String race;
    private int level;
    private double health;
    public Character() { // default constructor
        characterClass = "none";
        name = "Summoner";
        race = "none";
        level = 1;
        health = 100;



    }

    public void setName(String name) { this.name = name; } // setters
    public void setRace(String race) { this.race = race; }
    public void setCharacterClass(String characterClass) { this.characterClass = characterClass; }
    public void setLevel(int level) { this.level = level; }
    public void setHealth(double health) { this.health = health; }

    // method is virtual so theres no implementation

    public String getName() { return name; } // getters
    public String getRace() { return race; }
    public String getCharacterClass() { return characterClass; }
    public int getLevel() { return level; }
    public double getHealth() { return health; }

    public boolean iequals(String s1, String s2)
    { // ignore caps function
        // convert s1 and s2 into lower case strings
        if (s1.toLowerCase().compareTo(s2.toLowerCase()) == 0)
            return true; // The strings are same
        return false;    // not matched
    }

    void printLore()
    { // 9 possibilities for character lore
        if (iequals(characterClass, "warrior") && iequals(race, "yordle"))
            System.out.println( "*You chose Foppy: The Keeper of the Wammer*");
        else if (iequals(characterClass, "warrior") && iequals(race, "human"))
            System.out.println( "*You chose Jaren: The Might of Bremacia*");
        else if (iequals(characterClass, "warrior") && iequals(race, "animal"))
            System.out.println("*You chose Darwick: The Uncaged Wrath of Daun*");

        else if (iequals(characterClass, "archer") && iequals(race, "yordle"))
            System.out.println("*You chose Kristana: The Yordle Runner*" );
        else if (iequals(characterClass, "archer") && iequals(race, "human"))
            System.out.println("*You chose Bayne: The Night Stunter*");
        else if (iequals(characterClass, "archer") && iequals(race, "animal"))
            System.out.println("*You chose Kwitch: The Clague Rat*");

        else if (iequals(characterClass, "wizard") && iequals(race, "yordle"))
            System.out.println("*You chose Beigar: The Winy Master of Evil*");
        else if (iequals(characterClass, "wizard") && iequals(race, "human"))
            System.out.println("*You chose Tyze: The Dune Mage*");
        else if (iequals(characterClass, "wizard") && iequals(race, "animal"))
            System.out.println("*You chose Enivia: The Pryopheonix*");
    }

    void printInfo()
    { // print name, race, class, level, health, and character lore
        System.out.println("\nName: " + getName() +
                " Race: " + getRace() +
                " Class: " + getCharacterClass() +
                " Level: " + getLevel() +
                " Health: " + getHealth() +
                " Character: ");
        printLore();
    }

    public void update() {
        if(this.getHealth() <= 0){
            this.setDeathAnimation();
        }
        spriteCounter++;
        if(spriteCounter > 10){
            if(spriteNum == 1)
                spriteNum = 2;
            else if(spriteNum == 2)
                spriteNum = 3;
            else if(spriteNum == 3)
                spriteNum = 4;
            else if(spriteNum == 4)
                spriteNum = 5;
            else if(spriteNum == 5)
                spriteNum = 6;
            else if(spriteNum == 6)
                spriteNum = 7;
            else if(spriteNum == 7)
                spriteNum = 8;
            else if(spriteNum == 8)
                spriteNum = 9;
            else if(spriteNum == 9)
                spriteNum = 10;
            else if(spriteNum == 10)
                spriteNum = 11;
            else if(spriteNum == 11)
                spriteNum = 12;
            else if(spriteNum == 12)
                spriteNum = 13;
            else if(spriteNum == 13)
                spriteNum = 14;
            else if(spriteNum == 14)
                spriteNum = 15;
            else if(spriteNum == 15)
                spriteNum = 1;

            spriteCounter = 0;
        }
    }

    public abstract void setAttackAnimation();
    public abstract void draw(Graphics2D g2, int i);
    public abstract void attack(Character otherPlayer, int i);
    public abstract void setIdleAnimation();
    public abstract void setHurtAnimation();
    public abstract void setRunAnimation();

    public abstract void setWeapon(String sword);
    public abstract boolean addSpells(String spell);
    public abstract void setCrossbow(String crossbow);
    public abstract void setDeathAnimation();
}
