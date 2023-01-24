package Classes;

import Main.ImageFlip;
import Main.MouseHandler;
import Main.GamePanel;
import Weapons.Spells;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Wizard extends Character {
    GamePanel gp;
    MouseHandler mouseHandler;


    private static int MAX_SPELLS = 5;
    private int mana;
    private int numSpells;
    private Spells[] spells;
    public Wizard(GamePanel gp, MouseHandler mouseHandler, int startingPosition, String race) {
        // event handling test delete later
        this.gp = gp;
        this.mouseHandler = mouseHandler;
        this.startingPosition = startingPosition;

        setRace(race);
        this.mana = 1000;
        setDefaultValues();
        setIdleAnimation();

        mana = 0;
        numSpells = 0;
        spells = new Spells[MAX_SPELLS];
        for (int i = 0; i < spells.length; i++)
            spells[i] = null;
        setCharacterClass("wizard");
    }

    public Wizard(int mana, String spell) { // sets mana and spell
        this.mana = mana;
        numSpells = 1;
        for (int i = 0; i < MAX_SPELLS; i++) // checks if index i is empty for spell to be added
            spells[i] = null;
        setCharacterClass("Wizard");
    }

    public int getMana() {
        return mana;
    }

    public int getNumSpells() {
        return numSpells;
    } // returns number of spells in list

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void attack(Character otherPlayer, int i) {                                               // attacks and deducts mana
        if (spells[i].getName() == "Assimilation") // this spells adds 15 mana so there must be an "if" check
            mana += 15;
        else {
            mana -= spells[i].getCost();
            otherPlayer.setHealth((otherPlayer.getHealth() - spells[i].getDamage() <= 0) ? 0 : otherPlayer.getHealth() - spells[i].getDamage());
            System.out.println("\nAttack successful! ");
        }
    }

    public boolean addSpells(String spell) { // adds a spell to list
        boolean added = false;
        if (numSpells == MAX_SPELLS) {
            System.out.println("There are no more spells to be added, you're on your own summoner! Good luck!");
            return false;
        }

        for (int i = 0; i < MAX_SPELLS; i++) {
            if (spells[i] != null) {
                if (iequals(spells[i].getName(), spell)) {
                    System.out.println("*WARNING* that spell has already been added, choose another one");
                    added = false;
                    break;
                }
            } else if (spells[i] == null) {
                spells[i] = new Spells(spell);
                added = true;
                numSpells++;
                break;
            }
        }

        return added;
    }

    public Spells getSpells(int i) { // returns spell at index i
        return spells[i];
    }

    public int getMaxSpells() {
        return MAX_SPELLS;
    } // returns max spells which is 5


    public void setWeapon(String sword){}
    public void setCrossbow(String crossbow){}
    public void setDefaultValues(){
        if(startingPosition == -1) {
            x = -350;
            y = -200;
        }else if(startingPosition == 0) {
            x = -100;
            y = -200;
        }else{
            x = 150;
            y= -200;
        }
    }

    public void setIdleAnimation(){
        try {
            if(getRace().strip().equals("human")) {
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile000.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile001.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile002.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile003.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile004.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile005.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile006.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile000.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile001.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile002.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile003.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile004.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile005.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\idle\\tile006.png"));
                }
            } else if(getRace().strip().equals("yordle")){
                //9 frames
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile000.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile001.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile002.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile003.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile004.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile000.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile001.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile002.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile003.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\idle\\tile004.png"));
                }
            } else if(getRace().strip().equals("animal")){
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile010.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile011.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile000.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile001.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile002.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile010.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile011.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile000.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile001.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\idle\\tile002.png"));
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
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile000.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile000.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile000.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile000.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile000.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile000.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile000.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile000.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile000.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile000.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile000.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile000.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile000.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\attack\\tile000.png"));
                }
            } else if(getRace().strip().equals("yordle")){
                //9 frames
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile000.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile000.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile000.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile000.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile000.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile000.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile000.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile000.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile000.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\attack\\tile000.png"));
                }
            } else if(getRace().strip().equals("animal")){
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile010.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile011.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile000.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile000.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile000.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile010.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile011.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile000.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile000.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\attack\\tile000.png"));
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
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile000.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile001.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile002.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile003.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile004.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile005.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile006.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile000.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile001.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile002.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile003.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile004.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile005.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile006.png"));
                }
            } else if(getRace().strip().equals("yordle")){
                //9 frames
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile000.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile000.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile000.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile000.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile000.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile000.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile000.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile000.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile000.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\run\\tile000.png"));
                }
            } else if(getRace().strip().equals("animal")){
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile010.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile011.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile000.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile000.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile000.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile010.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile011.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile000.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile000.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\run\\tile000.png"));
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
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile000.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile000.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile000.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile000.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile000.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile000.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile000.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile000.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\run\\tile000.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile000.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile000.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile000.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile000.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile000.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile000.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile000.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile000.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile000.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile000.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile000.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile000.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile000.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile000.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\hurt\\tile000.png"));
                }
            } else if(getRace().strip().equals("yordle")){
                //9 frames
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile000.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile000.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile000.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile000.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile000.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile000.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile000.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile000.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile000.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\hurt\\tile000.png"));
                }
            } else if(getRace().strip().equals("animal")){
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile010.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile011.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile000.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile000.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile000.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile010.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile011.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile000.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile000.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\hurt\\tile000.png"));
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
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile006.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile006.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile006.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile006.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile006.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile006.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile006.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile006.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile006.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile006.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile006.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile006.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile006.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile006.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile006.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Human\\Human-Wizard\\die\\tile006.png"));
                }
            } else if(getRace().strip().equals("yordle")){
                //9 frames
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile009.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile009.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile009.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile009.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile009.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile009.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile009.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile009.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile009.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Yordle\\Yordle-Wizard\\die\\tile009.png"));
                }
            } else if(getRace().strip().equals("animal")){
                if (startingPosition == 1) {
                    t0 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile000.png"));
                    t1 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile001.png"));
                    t2 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile002.png"));
                    t3 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile003.png"));
                    t4 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile004.png"));
                    t5 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile005.png"));
                    t6 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile006.png"));
                    t7 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile007.png"));
                    t8 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile008.png"));
                    t9 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile009.png"));
                    t10 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile010.png"));
                    t11 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile011.png"));
                    t12 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile012.png"));
                    t13 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile013.png"));
                    t14 = ImageFlip.flip(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile014.png"));
                } else {
                    t0 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile000.png"));
                    t1 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile001.png"));
                    t2 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile002.png"));
                    t3 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile003.png"));
                    t4 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile004.png"));
                    t5 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile005.png"));
                    t6 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile006.png"));
                    t7 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile007.png"));
                    t8 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile008.png"));
                    t9 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile009.png"));
                    t10 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile010.png"));
                    t11 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile011.png"));
                    t12 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile012.png"));
                    t13 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile013.png"));
                    t14 = ImageIO.read(new FileInputStream("src-images\\Animal\\Animal-Wizard\\die\\tile014.png"));
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
            g2.drawImage(image, x, y, gp.tileSize * 60, gp.tileSize * 60, null);
            if(startingPosition != 0) {
                g2.setFont(g2.getFont().deriveFont(Font.BOLD, 16F));
                g2.setColor(Color.white);
                g2.drawString(getName(), x+400, y + 400);
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
                g2.fillRect( x+400,y+350, (int) (HEALTH_BAR_WIDTH * (getHealth() / MAX_HEALTH)), HEALTH_BAR_HEIGHT);
//                g2.setColor(Color.blue);
//                g2.fillRect(x, y+HEALTH_BAR_HEIGHT + 350, (int) (HEALTH_BAR_WIDTH * (getMana() / MAX_ENERGY)), 4);
            }
        }
        //Abilities Section

        switch(startingPosition){
            case -1:
                try {
                    g2.drawImage(ImageIO.read(new FileInputStream("src-images\\abilities\\Wizard\\5.png")), 0, gp.screenHeight-75,  50, 50, null);
                    g2.drawImage(ImageIO.read(new FileInputStream("src-images\\abilities\\Wizard\\30.png")), 55, gp.screenHeight-75,  50, 50, null);
                    g2.drawImage(ImageIO.read(new FileInputStream("src-images\\abilities\\Wizard\\10.png")), 110, gp.screenHeight-75,  50, 50, null);
                    g2.drawImage(ImageIO.read(new FileInputStream("src-images\\abilities\\Wizard\\34.png")), 165, gp.screenHeight-75,  50, 50, null);
                }catch(Exception e){
                    e.printStackTrace();
                }
                break;

            case 1:
                try {
                    g2.drawImage(ImageIO.read(new FileInputStream("src-images\\abilities\\Wizard\\5.png")), 0+500, gp.screenHeight-75,  50, 50, null);
                    g2.drawImage(ImageIO.read(new FileInputStream("src-images\\abilities\\Wizard\\30.png")), 55+500, gp.screenHeight-75,  50, 50, null);
                    g2.drawImage(ImageIO.read(new FileInputStream("src-images\\abilities\\Wizard\\10.png")), 110+500, gp.screenHeight-75,  50, 50, null);
                    g2.drawImage(ImageIO.read(new FileInputStream("src-images\\abilities\\Wizard\\34.png")), 165+500, gp.screenHeight-75,  50, 50, null);
                }catch(Exception e){
                    e.printStackTrace();
                }
                break;
        }

        //Abilities Section end
    }
}
