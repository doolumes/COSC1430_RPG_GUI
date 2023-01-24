package Classes;

import Main.ImageFlip;
import Main.MouseHandler;
import Main.GamePanel;
import Weapons.Weapon;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Warrior extends Character {
    static final private double DAMAGE_REDUCTION = .35;
    static final private double HEALTH_MULTPLIER = 1.5;
    GamePanel gp;
    MouseHandler mouseHandler;
    public String direction;

    private int stamina;
    private Weapon weapon;
    public Warrior(GamePanel gp, MouseHandler mouseHandler, int startingPosition, String race) {
        System.out.println(startingPosition);
        // event handling test delete later
        this.gp = gp;
        this.mouseHandler = mouseHandler;
        this.startingPosition = startingPosition;
        this.stamina = 1000;
        setRace(race);

        setDefaultValues();
        //getDeathAnimation();
        setIdleAnimation();
        // default constructor sets weapon to a club
        stamina = 0;
        weapon = new Weapon("club");
        setCharacterClass("Warrior");
    }
    public Warrior(String chosenWeapon, int stamina)
    { // initializer constructor sets weapon to weapon of user choice
        this.stamina = stamina;
        weapon = new Weapon(chosenWeapon);
        setCharacterClass("Warrior");
    }

    public void setWeapon(String chosenWeapon)
    { // changes weapon
        weapon.setWeapon(chosenWeapon);
    }

    public void setStamina(int stamina)
    { // sets stamina
        this.stamina = stamina;
    }

    public void attack(Character otherPlayer, int num)
    { // attacks and deducts stamina

        otherPlayer.setHealth((otherPlayer.getHealth() - weapon.getDamage() <= 0) ? 0 : otherPlayer.getHealth() - weapon.getDamage());
        stamina -= weapon.getCost();
        System.out.println("\nAttack successful! ");
    }

    public Weapon getWeapon() { return weapon; } // returns weapon object
    public  int getStamina() { return stamina; }  // returns stamina

    //event handling

    public void setDefaultValues(){
        if(startingPosition == -1) {
            x = 50;
        }else if(startingPosition == 0) {
            x = -100;
        }else{
            x = 500;
        }
        y=150;
    }

    public void setIdleAnimation(){
        try {
            if(getRace().strip().equals("human")) {
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile000.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile001.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile002.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile003.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile000.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile001.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile002.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile003.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile000.png"));
                    t13= ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile001.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile002.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile000.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile001.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile002.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile003.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile000.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile001.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile002.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile003.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile000.png"));
                    t13= ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile001.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\idle\\tile002.png"));
                }
            } else if(getRace().strip().equals("yordle")){
                //9 frames
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile000.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile001.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile002.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile003.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile004.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile000.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile001.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile002.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile003.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\idle\\tile004.png"));
                }
            } else if (getRace().strip().equals("animal")){
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile000.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile001.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile002.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile003.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile004.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile000.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile001.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile002.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile003.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\idle\\tile004.png"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setAttackAnimation(){
        try {
            if(getRace().strip().equals("human")) {
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile000.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile000.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile000.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile000.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile000.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile000.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile000.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile000.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile000.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile000.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile000.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile000.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile000.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile000.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile000.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile000.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile000.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile000.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile000.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\attack\\tile000.png"));
                }
            } else if(getRace().strip().equals("yordle")){
                //9 frames
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile000.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile000.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile000.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile000.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile000.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile000.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile000.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile000.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile000.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\attack\\tile000.png"));
                }
            } else if (getRace().strip().equals("animal")){
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile000.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile000.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile000.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile000.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile000.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile000.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile000.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile000.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile000.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\attack\\tile000.png"));
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
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile000.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile000.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile000.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile000.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile000.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile000.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile000.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile000.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile000.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile000.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile000.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile000.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile000.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile000.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\run\\tile000.png"));
                }
            } else if(getRace().strip().equals("yordle")){
                //9 frames
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile000.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile000.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile000.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile000.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile000.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile000.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile000.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile000.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile000.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\run\\tile000.png"));
                }
            } else if (getRace().strip().equals("animal")){
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile000.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile000.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile000.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile000.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile000.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile000.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile000.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile000.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile000.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\run\\tile000.png"));
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
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile000.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile000.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile000.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile000.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile000.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile000.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile000.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile000.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile000.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile000.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile000.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile000.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile000.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile000.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile000.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile000.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile000.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile000.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile000.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile000.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile000.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile000.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile000.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile000.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\hurt\\tile000.png"));
                }
            } else if(getRace().strip().equals("yordle")){
                //9 frames
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile000.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile000.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile000.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile000.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile000.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile000.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile000.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile000.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile000.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\hurt\\tile000.png"));
                }
            } else if (getRace().strip().equals("animal")){
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile000.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile000.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile000.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile000.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile000.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile000.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile000.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile000.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile000.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\hurt\\tile000.png"));
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
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile005.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile005.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile005.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile005.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile005.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile005.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile005.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile005.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile005.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile005.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile005.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile005.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile005.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile005.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile005.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile005.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Warrior\\die\\tile005.png"));
                }
            } else if(getRace().strip().equals("yordle")){
                //9 frames
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile009.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile009.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile009.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile009.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile009.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile009.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile009.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile009.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile009.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Warrior\\die\\tile009.png"));
                }
            } else if (getRace().strip().equals("animal")){
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile009.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile009.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile009.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile009.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile009.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile009.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile009.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile009.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile009.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Warrior\\die\\tile009.png"));
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
        }, 1500);
    }

    public void draw(Graphics2D g2, int location){

        //Abilities Section

        switch(startingPosition){
            case -1:
                try {
                    g2.drawImage(ImageIO.read(new FileInputStream("src-images\\abilities\\Warrior\\active14.png")), 0, gp.screenHeight-75,  50, 50, null);
                    g2.drawImage(ImageIO.read(new FileInputStream("src-images\\abilities\\Warrior\\75px-FieldMedic.png")), 55, gp.screenHeight-75,  50, 50, null);
                    g2.drawImage(ImageIO.read(new FileInputStream("src-images\\abilities\\Warrior\\active3.png")), 110, gp.screenHeight-75,  50, 50, null);
                    g2.drawImage(ImageIO.read(new FileInputStream("src-images\\abilities\\Warrior\\axe.png")), 165, gp.screenHeight-75,  50, 50, null);
                    g2.drawImage(ImageIO.read(new FileInputStream("src-images\\abilities\\Warrior\\fork.png")), 220, gp.screenHeight-75,  50, 50, null);
                    g2.drawImage(ImageIO.read(new FileInputStream("src-images\\abilities\\Warrior\\active1.png")), 275, gp.screenHeight-75,  50, 50, null);
                }catch(Exception e){
                    e.printStackTrace();
                }
                break;

            case 1:
                try {
                    g2.drawImage(ImageIO.read(new FileInputStream("src-images\\abilities\\Warrior\\active14.png")), 0+450, gp.screenHeight-75,  50, 50, null);
                    g2.drawImage(ImageIO.read(new FileInputStream("src-images\\abilities\\Warrior\\75px-FieldMedic.png")), 55+450, gp.screenHeight-75,  50, 50, null);
                    g2.drawImage(ImageIO.read(new FileInputStream("src-images\\abilities\\Warrior\\active3.png")), 110+450, gp.screenHeight-75,  50, 50, null);
                    g2.drawImage(ImageIO.read(new FileInputStream("src-images\\abilities\\Warrior\\axe.png")), 165+450, gp.screenHeight-75,  50, 50, null);
                    g2.drawImage(ImageIO.read(new FileInputStream("src-images\\abilities\\Warrior\\fork.png")), 220+450, gp.screenHeight-75,  50, 50, null);
                    g2.drawImage(ImageIO.read(new FileInputStream("src-images\\abilities\\Warrior\\active1.png")), 275+450, gp.screenHeight-75,  50, 50, null);
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
            g2.drawString(getName(), x,y+50);
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
            g2.fillRect( x,y, (int) (HEALTH_BAR_WIDTH * (getHealth() / MAX_HEALTH)), HEALTH_BAR_HEIGHT);
//            g2.setColor(Color.yellow);
//            g2.fillRect(x, y+HEALTH_BAR_HEIGHT, (int) (HEALTH_BAR_WIDTH * (getStamina() / MAX_ENERGY)), 4);
        }
    }

    public  boolean addSpells(String spell){
        return true;
    }
    public  void setCrossbow(String crossbow){
        return;
    }
}
