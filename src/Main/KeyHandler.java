package Main;

import Classes.Archer;
import Classes.Wizard;
import Classes.Warrior;
import Classes.Character;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.security.Key;
import java.util.Timer;
import java.util.TimerTask;

public class KeyHandler implements KeyListener {
    GamePanel gp;
    Graphics2D g2;
    int line;

    String name = " ";
    String race = " ";
    String _class = " ";
    String level = " ";
    String health = " ";
    String name2 = " ";
    String race2 = " ";
    String _class2 = " ";
    String level2 = " ";
    String health2 = " ";
    int activeField = 0;
    boolean[] activeFieldArray = {true, true, true, true, true,
                                true, true, true, true, true};
    boolean nameField, nameField2;
    boolean raceField, raceField2;
    boolean _classField, _classField2;
    boolean levelField, levelField2;
    boolean healthField, healthField2;

    Font rexila_rg, zerovelo, zig_____;
    boolean player1turn = true, player2turn;
    boolean description = true, attributes;

    String archerBow = "";
    String warriorWeapon = "";
    String wizardSpell = "";

    String archerBow2 = "";
    String warriorWeapon2 = "";
    String wizardSpell2 = "";
    KeyHandler(GamePanel gp){
        this.gp = gp;
        line = gp.tileSize * 6 + 125;
        nameField = activeFieldArray[0];
        raceField = activeFieldArray[1];
        _classField = activeFieldArray[2];
        levelField = activeFieldArray[3];
        healthField = activeFieldArray[4];
        nameField2 = activeFieldArray[5];
        raceField2= activeFieldArray[6];
        _classField2 = activeFieldArray[7];
        levelField2 = activeFieldArray[8];
        healthField2 = activeFieldArray[9];
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(gp.ui.startScreenState == 1 ) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                activeFieldArray[activeField] = false;

                nameField = activeFieldArray[0];
                raceField = activeFieldArray[1];
                _classField = activeFieldArray[2];
                levelField = activeFieldArray[3];
                healthField = activeFieldArray[4];
                nameField2 = activeFieldArray[5];
                raceField2= activeFieldArray[6];
                _classField2 = activeFieldArray[7];
                levelField2 = activeFieldArray[8];
                healthField2 = activeFieldArray[9];

                if(activeField < 13) {
                    activeField++;
                }
                line+=25;
            }

            if(activeField == 5){
                player1turn = false;
                player2turn = true;
                line = gp.tileSize * 6 + 125;
            }

            else if(activeField == 10){
                player1turn = true;
                player2turn = false;
                description = false;
                attributes = true;
                if(_class.indexOf("archer") != -1 && attributes){
                    gp.player1 = new Archer(gp, gp.mouseHandler,-1, race.strip());
                    gp.player1.setName(name);
                    gp.player1.setHealth(Integer.parseInt(health.strip()));
                    gp.player1.MAX_HEALTH = gp.player1.getHealth();
                    gp.player1.setLevel(Integer.parseInt(level.strip()));
                    gp.player1.setHealth(Integer.parseInt(health.strip()));
                    if(e.getKeyCode() == KeyEvent.VK_1) {
                        gp.player1.setCrossbow("gun");
                        player1turn = false;
                        player2turn = true;
                        activeField++;
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_2) {
                        gp.player1.setCrossbow("bazooka");
                        player1turn = false;
                        player2turn = true;
                        activeField++;
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_3) {
                        gp.player1.setCrossbow("slingshot");
                        player1turn = false;
                        player2turn = true;
                        activeField++;
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_4) {
                        gp.player1.setCrossbow("crossbow");
                        player1turn = false;
                        player2turn = true;
                        activeField++;
                    }
                } else if(_class.indexOf("wizard") != -1 && attributes){
                    gp.player1 = new Wizard(gp, gp.mouseHandler,-1, race.strip());
                    gp.player1.setName(name);
                    gp.player1.setHealth(Integer.parseInt(health.strip()));
                    gp.player1.MAX_HEALTH = gp.player1.getHealth();
                    gp.player1.setLevel(Integer.parseInt(level.strip()));
                    gp.player1.setHealth(Integer.parseInt(health.strip()));
                    if(e.getKeyCode() == KeyEvent.VK_1) {
                        gp.player1.addSpells("plasma bolt");
                        player1turn = false;
                        player2turn = true;
                        activeField++;
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_2) {
                        gp.player1.addSpells("electrocute");
                        player1turn = false;
                        player2turn = true;
                        activeField++;
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_3) {
                        gp.player1.addSpells("plasma rain");
                        player1turn = false;
                        player2turn = true;
                        activeField++;
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_4) {
                        gp.player1.addSpells("super charge");
                        player1turn = false;
                        player2turn = true;
                        activeField++;
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_5) {
                        gp.player1.addSpells("assimilation");
                        player1turn = false;
                        player2turn = true;
                        activeField++;
                    }
                } else if(_class.indexOf("warrior") != -1 && attributes){
                    gp.player1 = new Warrior(gp, gp.mouseHandler,-1, race.strip());
                    gp.player1.setName(name);
                    gp.player1.setHealth(Integer.parseInt(health.strip()));
                    gp.player1.MAX_HEALTH = gp.player1.getHealth();
                    gp.player1.setLevel(Integer.parseInt(level.strip()));
                    gp.player1.setHealth(Integer.parseInt(health.strip()));
                    if(e.getKeyCode() == KeyEvent.VK_1) {
                        player1turn = false;
                        player2turn = true;
                        gp.player1.setWeapon("sword");
                        activeField++;
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_2) {
                        player1turn = false;
                        player2turn = true;
                        gp.player1.setWeapon("axe");
                        activeField++;
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_3) {
                        player1turn = false;
                        player2turn = true;
                        gp.player1.setWeapon("pitch fork");
                        activeField++;
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_4) {
                        player1turn = false;
                        player2turn = true;
                        gp.player1.setWeapon("club");
                        activeField++;
                    }
                }
            }

            else if(activeField == 11){
                if(_class2.indexOf("archer") != -1 && attributes){
                    gp.player2 = new Archer(gp, gp.mouseHandler, 1, race2.strip());
                    gp.player2.setName(name2);
                    gp.player2.setHealth(Integer.parseInt(health2.strip()));
                    gp.player2.MAX_HEALTH = gp.player2.getHealth();
                    gp.player2.setLevel(Integer.parseInt(level2.strip()));
                    gp.player2.setHealth(Integer.parseInt(health2.strip()));
                    if(e.getKeyCode() == KeyEvent.VK_1) {
                        player1turn = true;
                        player2turn = false;
                        gp.player2.setCrossbow("gun");
                        activeField++;
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_2) {
                        player1turn = true;
                        player2turn = false;
                        gp.player2.setCrossbow("bazooka");
                        activeField++;
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_3) {
                        player1turn = true;
                        player2turn = false;
                        gp.player2.setCrossbow("slingshot");
                        activeField++;
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_4) {
                        player1turn = true;
                        player2turn = false;
                        gp.player2.setCrossbow("crossbow");
                        activeField++;
                    }
                } else if(_class2.indexOf("wizard") != -1 && attributes){
                    gp.player2 = new Wizard(gp, gp.mouseHandler,1, race2.strip());
                    gp.player2.setName(name2);
                    gp.player2.setHealth(Integer.parseInt(health2.strip()));
                    gp.player2.MAX_HEALTH = gp.player2.getHealth();
                    gp.player2.setLevel(Integer.parseInt(level2.strip()));
                    gp.player2.setHealth(Integer.parseInt(health2.strip()));
                    if(e.getKeyCode() == KeyEvent.VK_1) {
                        player1turn = true;
                        player2turn = false;
                        gp.player2.addSpells("plasma bolt");
                        activeField++;
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_2) {
                        player1turn = true;
                        player2turn = false;
                        gp.player2.addSpells("electrocute");
                        activeField++;
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_3) {
                        player1turn = true;
                        player2turn = false;
                        gp.player2.addSpells("plasma rain");
                        activeField++;
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_4) {
                        player1turn = true;
                        player2turn = false;
                        gp.player2.addSpells("super charge");
                        activeField++;
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_5) {
                        player1turn = true;
                        player2turn = false;
                        gp.player2.addSpells("assimilation");
                        activeField++;
                    }
                } else if(_class2.indexOf("warrior") != -1 && attributes){
                    gp.player2 = new Warrior(gp, gp.mouseHandler,1, race2.strip());
                    gp.player2.setName(name2);
                    gp.player2.setHealth(Integer.parseInt(health2.strip()));
                    gp.player2.MAX_HEALTH = gp.player2.getHealth();
                    gp.player2.setLevel(Integer.parseInt(level2.strip()));
                    gp.player2.setHealth(Integer.parseInt(health2.strip()));
                    if(e.getKeyCode() == KeyEvent.VK_1) {
                        player1turn = true;
                        player2turn = false;
                        gp.player2.setWeapon("sword");
                        activeField++;
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_2) {
                        player1turn = true;
                        player2turn = false;
                        gp.player2.setWeapon("axe");
                        activeField++;
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_3) {
                        player1turn = true;
                        player2turn = false;
                        gp.player2.setWeapon("pitch fork");
                        activeField++;
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_4) {
                        player1turn = true;
                        player2turn = false;
                        gp.player2.setWeapon("club");
                        activeField++;
                    }
                }

                gp.gameState = gp.playState;
                gp.ui.startScreenState++;
            }

            if(nameField){
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    name = name.substring(0, name.length());
                } else {
                    name += e.getKeyChar();
                }
            } else if(raceField){
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    race = race.substring(0, race.length());
                } else {
                    race += e.getKeyChar();
                }
            } else if(_classField){
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    _class = _class.substring(0, _class.length());
                } else {
                    _class += e.getKeyChar();
                }
            } else if(levelField){
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    level = level.substring(0, level.length());
                } else {
                    level += e.getKeyChar();
                }
            } else if(healthField){
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    health = health.substring(0, health.length());
                } else {
                    health += e.getKeyChar();
                }
            } else if(nameField2){
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    name2 = name2.substring(0, name2.length());
                } else {
                    name2 += e.getKeyChar();
                }
            } else if(raceField2){
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    race2 = race2.substring(0, race2.length());
                } else {
                    race2 += e.getKeyChar();
                }
            } else if(_classField2){
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    _class2 = _class2.substring(0, _class2.length());
                } else {
                    _class2 += e.getKeyChar();
                }
            } else if(levelField2){
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    level2 = level2.substring(0, level2.length());
                } else {
                    level2 += e.getKeyChar();
                }
            } else if(healthField2){
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    health2 = health2.substring(0, health2.length());
                } else {
                    health2 += e.getKeyChar();
                }
            }
        }

        //play state
        if(gp.gameState == gp.playState){
            Timer timer = new Timer();
            if(e.getKeyCode() == KeyEvent.VK_A){
                gp.player1.setAttackAnimation();
                //attack
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        gp.player1.setIdleAnimation();
                        gp.player1.attack(gp.player2,0);
                        gp.player2.setHurtAnimation();

                        Timer timer2 = new Timer();
                        timer2.schedule(new TimerTask(){
                            @Override
                            public void run(){
                                gp.player2.setIdleAnimation();
                            }
                        }, 1000);

                        player2turn = true;
                        player1turn = false;
                    }
                }, 2500);
                //back to normal
//                timer.schedule(new TimerTask(){
//                    @Override
//                    public void run(){
//                        System.out.println("back to idel");
//                        gp.player2.setIdleAnimation();
//                    }
//                }, 1000);
            }

            if(e.getKeyCode() == KeyEvent.VK_D){
                gp.player2.setAttackAnimation();
                //attack
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        gp.player2.setIdleAnimation();
                        gp.player2.attack(gp.player1,0);
                        gp.player1.setHurtAnimation();

                        Timer timer2 = new Timer();
                        timer2.schedule(new TimerTask(){
                            @Override
                            public void run(){
                                gp.player1.setIdleAnimation();
                            }
                        }, 1000);

                        player2turn = false;
                        player1turn = true;
                    }
                }, 3500);
                //back to normal
//                timer.schedule(new TimerTask(){
//                    @Override
//                    public void run(){
//                        System.out.println("back to idel");
//                        gp.player2.setIdleAnimation();
//                    }
//                }, 1000);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    void draw(Graphics2D g2){
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 16F));
        if(gp.ui.startScreenState == 1 ) {
            //name
            if(nameField) {
                g2.drawString(name, 120, line);
            }
            else if(raceField) {
                g2.drawString(race, 120 + 10, line);
            }
            else if(_classField) {
                g2.drawString(_class, 120 + 10, line);
            }
            else if(levelField){
                g2.drawString(level, 120 + 20, line);
            }
            else if(healthField) {
                g2.drawString(health, 120 + 40, line);
            }
            else if(nameField2) {
                g2.drawString(name2, 120+350, line);
            }
            else if(raceField2) {
                g2.drawString(race2, 120+350 + 10, line);
            }
            else if(_classField2) {
                g2.drawString(_class2, 120 + 350 + 10, line);
            }
            else if(levelField2){
                g2.drawString(level2, 120 + 350 + 20, line);
            }
            else if(healthField2) {
                g2.drawString(health2, 120 + 350 + 40, line);
            }

        }
    }
//    public char getChar(char c){
//        return c;
//    }
}
