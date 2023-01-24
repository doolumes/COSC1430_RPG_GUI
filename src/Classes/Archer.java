package Classes;

import Main.MouseHandler;
import Main.GamePanel;
import Weapons.Crossbow;
import Main.ImageFlip;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


import java.util.Timer;
import java.util.TimerTask;

public class Archer extends Character{
    GamePanel gp;
    MouseHandler mouseHandler;
    public String direction;

    private int energy;
    private final Crossbow crossbow;

    public Archer(GamePanel gp, MouseHandler mouseHandler, int startingPosition, String race)
    { // default constructor

        this.gp = gp;
        this.mouseHandler = mouseHandler;
        this.startingPosition = startingPosition;
        this.energy = 1000;
        setRace(race);

        setDefaultValues();
        setIdleAnimation();

        crossbow = new Crossbow();
        this.energy = 0;
        setCharacterClass("Archer");

    }

    public Archer(String chosenCrossBow, int energy)
    { // initializer constructor
        crossbow = new Crossbow(chosenCrossBow);
        this.energy = energy;
        setCharacterClass("Archer");
    }

    public void setCrossbow(String chosenCrossBow)
    { // changes crossbow
        crossbow.setCrossBow(chosenCrossBow);
    }

    public void setEnergy(int energy)
    { // sets energy
        this.energy = energy;
    }

    public void attack(Character otherPlayer, int i)
    { // attack method for archer and deducts energy, for each crossbow, there is an ammo check to see if ammo is needed
        double crossbowDamage = crossbow.getDamage();
        if (crossbow.getName() == "Medic Ray")
        { // medic ray heals for 15
            if (!crossbow.setAmmo())
                System.out.println("Need more ammo!");
            else
            {
                otherPlayer.setHealth((otherPlayer.getHealth() - crossbowDamage <= 0) ? 0 : otherPlayer.getHealth() - crossbowDamage);
                setHealth(getHealth() + 25);
                energy -= crossbow.getCost();
                System.out.println("+15 Health Points!" );
                System.out.println("Attack successful!");
            }
        }
        else if (crossbow.getName() == "Void Slinger")
        { // void slinger can crit
            if (!crossbow.setAmmo())
                System.out.println("Need more ammo!");
            else
            {
                if (crossbowDamage == 100)
                {

                    File file = new File("C:\\Users\\diono\\IdeaProjects\\demo\\src\\main\\java\\com\\example\\demo\\criticalstrike.txt");
                    Scanner scan;
                    try{
                        scan = new Scanner(file);

                        while (scan.hasNextLine())
                        {
                            System.out.println(scan.nextLine());
                        }
                    } catch(FileNotFoundException e){
                        System.out.println("No art");
                    }
                }
                otherPlayer.setHealth((otherPlayer.getHealth() - crossbowDamage <= 0) ? 0 : otherPlayer.getHealth() - crossbowDamage);
                energy -= crossbow.getCost();
                System.out.println("\nAttack successful! ");
            }
        }

        else if (crossbow.getName() == "Ballistic Cannon")
        { // this crossbow has a damage mulitplier of 50% (75)
            if (!crossbow.setAmmo())
                System.out.println("Need more ammo!");
            else
            {
                otherPlayer.setHealth(otherPlayer.getHealth() - crossbowDamage);
                energy -= crossbow.getCost();
                System.out.println("\nAttack successful! ");
            }
        }

        else if (crossbow.getName() == "String Cross Bow")
        { // default useless crossbow
            if (!crossbow.setAmmo())
                System.out.println("Need more ammo!");
            else
            {
                otherPlayer.setHealth(otherPlayer.getHealth() - crossbowDamage);
                energy -= crossbow.getCost();
                System.out.println("\nAttack successful! ");
            }
        }
    }
    public void reload(){//adds max 2 ammo
        if(crossbow.ammo + 2 >= 10){
            crossbow.ammo = 10;
            System.out.println("Max Ammo");
        }else{
            crossbow.ammo +=2;
        }
    }
    public Crossbow getCrossBow() { return this.crossbow; } // returns crossbow object
    public int getEnergy() { return energy; }

    public void setDefaultValues(){
        if(startingPosition == -1)
            x = 50;

        else if(startingPosition == 0)
            x = -100;
        else{
            x = 500;
        }
        y = 150;
    }

    public void setIdleAnimation(){
        try {
            if(getRace().strip().equals("human")) {
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile000.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile001.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile002.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile003.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile004.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile005.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile006.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile000.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile000.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile001.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile002.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile003.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile004.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile005.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile006.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\idle\\tile000.png"));
                }
            } else if (getRace().strip().equals("yordle")){
                //9 frames
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile000.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile001.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile002.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile003.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile004.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile000.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile001.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile002.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile003.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\idle\\tile004.png"));
                }
            } else if (getRace().strip().equals("animal")){
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile000.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile001.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile002.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile003.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile004.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile005.png"));

                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile000.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile001.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile002.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile003.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile004.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\idle\\tile005.png"));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void setAttackAnimation(){
        spriteNum = 1;
        try {
            if(getRace().strip().equals("human")) {
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile010.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile011.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile012.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile013.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile014.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile010.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile011.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile012.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile013.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\attack\\tile014.png"));
                }
            } else if (getRace().strip().equals("yordle")){
                //9 frames
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile000.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile000.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile000.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile000.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile000.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile000.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile000.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile000.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile000.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\attack\\tile000.png"));
                }
            } else if (getRace().strip().equals("animal")){
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile010.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile011.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile012.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile013.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile014.png"));

                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile010.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile011.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile012.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile013.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\attack\\tile014.png"));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void setRunAnimation(){
        try {
            if(getRace().strip().equals("human")) {
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile000.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile000.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile000.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile000.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile000.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile000.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile000.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile000.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile000.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile000.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile000.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile000.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile000.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile000.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile000.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile000.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile000.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\run\\tile000.png"));
                }
            } else if (getRace().strip().equals("yordle")){
                //9 frames
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile000.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile000.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile000.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile000.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile000.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile000.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile000.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile000.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile000.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\run\\tile000.png"));
                }
            } else if (getRace().strip().equals("animal")){
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile010.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile011.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile000.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile000.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile000.png"));

                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile010.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile011.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile000.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile000.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\run\\tile000.png"));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void setHurtAnimation(){
        try {
            if(getRace().strip().equals("human")) {
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile000.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile000.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile000.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile000.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile000.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile000.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile000.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile000.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile000.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile000.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile000.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile000.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile000.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile000.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile000.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile000.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile000.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile000.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile000.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile000.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile000.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile000.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile000.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile000.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile000.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\hurt\\tile000.png"));
                }
            } else if (getRace().strip().equals("yordle")){
                //9 frames
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile000.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile000.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile000.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile000.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile000.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile000.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile000.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile000.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile000.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\hurt\\tile000.png"));
                }
            } else if (getRace().strip().equals("animal")){
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile010.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile011.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile012.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile013.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile014.png"));

                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile010.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile011.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile012.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile013.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\hurt\\tile014.png"));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setDeathAnimation(){
        try {
            if(getRace().strip().equals("human")) {
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile004.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile004.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile004.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile004.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile004.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile004.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile004.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile004.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile004.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile004.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile004.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile004.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile004.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile004.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile004.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile004.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile004.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile004.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile004.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Archer\\die\\tile004.png"));
                }
            } else if (getRace().strip().equals("yordle")){
                //9 frames
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile009.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile009.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile009.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile009.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile009.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile009.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile009.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile009.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile009.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Archer\\die\\tile009.png"));
                }
            } else if (getRace().strip().equals("animal")){
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile010.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile011.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile012.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile013.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile014.png"));

                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile010.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile011.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile012.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile013.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Archer\\die\\tile014.png"));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        Timer t = new Timer();
        t.schedule( new TimerTask() {
            @Override
            public void run() {
                 gp.gameState = gp.endState;
            }
        }, 2000);
    }

    public void getAbilityImages(){

    }

    public void draw(Graphics2D g2, int location){
        //Abilities Section

        switch(startingPosition){
            case -1:
                try {
                    g2.drawImage(ImageIO.read(new FileInputStream("src-images\\abilities\\Archer\\Nature\\Nature_6.png")), 0, gp.screenHeight-75,  50, 50, null);
                    g2.drawImage(ImageIO.read(new FileInputStream("src-images\\abilities\\Archer\\Fire\\Fire_14.png")), 55, gp.screenHeight-75,  50, 50, null);
                    g2.drawImage(ImageIO.read(new FileInputStream("src-images\\abilities\\Archer\\Dark\\Dark_12.png")), 110, gp.screenHeight-75,  50, 50, null);
                    g2.drawImage(ImageIO.read(new FileInputStream("src-images\\abilities\\Archer\\Dark\\Dark_9.png")), 165, gp.screenHeight-75,  50, 50, null);
                }catch(Exception e){
                    e.printStackTrace();
                }
                break;

            case 1:
                try {
                    g2.drawImage(ImageIO.read(new FileInputStream("src-images\\abilities\\Archer\\Nature\\Nature_6.png")), 0+500, gp.screenHeight-75,  50, 50, null);
                    g2.drawImage(ImageIO.read(new FileInputStream("src-images\\abilities\\Archer\\Fire\\Fire_14.png")), 55+500, gp.screenHeight-75,  50, 50, null);
                    g2.drawImage(ImageIO.read(new FileInputStream("src-images\\abilities\\Archer\\Dark\\Dark_12.png")), 110+500, gp.screenHeight-75,  50, 50, null);
                    g2.drawImage(ImageIO.read(new FileInputStream("src-images\\abilities\\Archer\\Dark\\Dark_9.png")), 165+500, gp.screenHeight-75,  50, 50, null);
                }catch(Exception e){
                    e.printStackTrace();
                }
                break;
        }

        //Abilities Section end
        BufferedImage image = null;
        if(spriteNum == 1)
            image = t0;
        if(spriteNum == 2)
            image = t1;
        if(spriteNum == 3)
            image = t2;
        if(spriteNum == 4)
            image = t3;
        if(spriteNum == 5)
            image = t4;
        if(spriteNum == 6)
            image = t5;
        if(spriteNum == 7)
            image = t6;
        if(spriteNum == 8)
            image = t7;
        if(spriteNum == 9)
            image = t8;
        if(spriteNum == 10)
            image = t9;
        if(spriteNum == 11)
            image = t10;
        if(spriteNum == 12)
            image = t11;
        if(spriteNum == 13)
            image = t12;
        if(spriteNum == 14)
            image = t13;
        if(spriteNum == 15)
            image = t14;
        if(location == 0) {
            g2.drawImage(image, x, y, gp.tileSize * 17, gp.tileSize * 17, null);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 16F));
            g2.setColor(Color.white);
            g2.drawString(getName(), x,y+100);

            g2.setColor(Color.red);
            if(startingPosition == -1){
                g2.drawString("Class: " + getCharacterClass(), 25, 25);
                g2.drawString("Race: " + getRace(), 25, 50);
                g2.drawString("Level: " + getLevel(), 25, 75);
                g2.drawString("Health: " + getHealth(), 25, 100);
            }else{
                g2.drawString("Class: " + getCharacterClass(), gp.screenWidth - 150, 25);
                g2.drawString("Race: " + getRace(), gp.screenWidth - 150, 50);
                g2.drawString("Level: " + getLevel(), gp.screenWidth - 150, 75);
                g2.drawString("Health: " + getHealth(), gp.screenWidth - 150, 100);
            }
            if(getHealth() < MAX_HEALTH/2)
                g2.setColor(Color.red);
            else
                g2.setColor(Color.green);
            g2.fillRect( x,y+50, (int) (HEALTH_BAR_WIDTH * (getHealth() / MAX_HEALTH)), HEALTH_BAR_HEIGHT);
//            g2.setColor(Color.orange);
//            g2.fillRect(x, y+HEALTH_BAR_HEIGHT+50 , (int) (HEALTH_BAR_WIDTH * (getEnergy() / MAX_ENERGY)), 400);
        }
    }
    public void setWeapon(String sword){
        return;
    }
    public boolean addSpells(String spell){
        return true ;
    }
}
