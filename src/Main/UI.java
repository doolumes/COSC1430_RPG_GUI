package Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.concurrent.ExecutionException;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font rexila_rg, zerovelo, zig_____;
    public boolean messageOn = false;
    public String message = "";
    public int startScreenState = 0; //0: the first screen, 1: second screen

    public UI(GamePanel gp){
        this.gp = gp;
        try{
            InputStream is = getClass().getResourceAsStream("rexlia rg.otf");
            rexila_rg = Font.createFont(Font.TRUETYPE_FONT, is);
            is = getClass().getResourceAsStream("zerovelo.ttf");
            zerovelo = Font.createFont(Font.TRUETYPE_FONT, is);
            is = getClass().getResourceAsStream("zig_____.ttf");
            zig_____ = Font.createFont(Font.TRUETYPE_FONT, is);
        }catch(FontFormatException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        this.g2 = g2;

        g2.setFont(zig_____);
        g2.setColor(Color.white);

        //TITLE STATE
        if(gp.gameState == gp.startState){
            drawStartScreen();
        }
        //PLAY STATE
        if(gp.gameState == gp.playState){
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 16F));
            if(gp.keyHandler.player1turn){
                g2.drawString("Player 1 turn: ", 0, 100+350);
                g2.drawString("Press A to attack ", 0, 120+350);
            }

            else if(gp.keyHandler.player2turn){
                g2.drawString("Player 2 turn: ", gp.screenWidth - 250,100+350);
                g2.drawString("Press D to attack", gp.screenWidth - 250,120+350);
            }
        }
        //END STATE
        if(gp.gameState == gp.endState){
            drawEndScreen();
        }
    }
    public void drawPlayScreen(){

    }

    public void drawStartScreen( ){
        //GRADIENT
//        GradientPaint blackToGray = new GradientPaint(50, 50, Color.BLACK,
//                300, 100, Color.LIGHT_GRAY);
        if(startScreenState == 0){
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60F));
            g2.setColor(Color.black);

            //TITLE NAME
            g2.fillRect(0,0, gp.screenWidth, gp.screenHeight);
            String text = "COSC 1430 RPG";
            int x = getXforCenteredText(text);
            int y = gp.tileSize * 6;

            //SHADOW
            g2.setColor(Color.gray);
            g2.drawString(text, x+5, y+5);
            //MAIN COLOR
            g2.setColor(Color.white);
            g2.drawString(text,x,y);

            //START SCREEN MODEL AKA MAGES UNITE
            x = gp.screenWidth/4;
            y += gp.tileSize * 2;
            //g2.drawImage(gp.wizard.t0,(int)(x *-0.55),(int)(y *-1.60),gp.tileSize*60, gp.tileSize*60,null);
            gp.MAIN_CHARACTER.draw(g2,0);
            gp.MAIN_CHARACTER.update();

            //MENU
            g2.setColor(Color.gray);
            g2.fillRect(gp.screenWidth/4+10,gp.screenHeight/2+10+176, (gp.screenWidth/2), (int)(gp.screenHeight/7));
            g2.setColor(Color.white);
            g2.fillRect(gp.screenWidth/4,gp.screenHeight/2+175, (gp.screenWidth/2), (int)(gp.screenHeight/7));

            g2.setColor(Color.red);
            g2.fillRect(gp.screenWidth/4+25,gp.screenHeight/2+175+5, (gp.screenWidth/2-50), (int)(gp.screenHeight/7-25));

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));
            text = "PLAY";
            x = getXforCenteredText(text);
            y += gp.tileSize * 24+5;

            g2.setColor(Color.white);
            g2.drawString(text,x,y);
//        if(commandNumber == 0){
//            g2.drawString(">", x-gp.tileSize*4, y);
//        }
            //gray (white) red white
//        text = "QUIT";
//        x = getXforCenteredText(text);
//        y += gp.tileSize * 4;
//        g2.drawString(text,x,y);
        }
        else if(startScreenState == 1){
            //CLASS SELECTION SCREEN
            g2.setColor(Color.black);

            //TITLE NAME
            g2.fillRect(0,0, gp.screenWidth, gp.screenHeight);
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));

            String text = "SELECT YOUR CLASS";
            int x = getXforCenteredText(text);
            int y = gp.tileSize * 6;

            //SHADOW
            g2.setColor(Color.black);
            g2.drawString(text, x+5, y+5);
            //MAIN COLOR
            g2.setColor(Color.white);
            g2.drawString(text,x,y);

//            text = "Wizard";
//            x = getXforCenteredText(text);
//            y += gp.tileSize*3;
//            g2.drawString(text,x,y);
//
//            text = "Archer";
//            x = getXforCenteredText(text);
//            y += gp.tileSize*3;
//            g2.drawString(text,x,y);
//
//            text = "Warrior";
//            x = getXforCenteredText(text);
//            y += gp.tileSize*3;
//            g2.drawString(text,x,y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 16F));
            if(gp.keyHandler.player1turn && gp.keyHandler.description) {
                g2.drawString("-Player 1- ", x, y + 75);
                g2.drawString("Name: ", x, y + 125);
                g2.drawString("Race: ", x, y + 150);
                g2.drawString("Class: ", x, y + 175);
                g2.drawString("Level: ", x, y + 200);
                g2.drawString("Health: ", x, y + 225);
            }

            gp.keyHandler.draw(g2);
            if(gp.keyHandler.player2turn && gp.keyHandler.description){
                g2.drawString("-Player 2- ",x + 350,y + 75);
                g2.drawString("Name: ",x + 350,y + 125);
                g2.drawString("Race: ",x + 350,y+150);
                g2.drawString("Class: ",x + 350,y+175);
                g2.drawString("Level: ",x + 350,y+200);
                g2.drawString("Health: ",x + 350,y+225);
            }
            if(gp.keyHandler.player1turn && gp.keyHandler.attributes) {
                g2.setFont(g2.getFont().deriveFont(Font.BOLD, 12F));
                g2.drawString("-Player 1- ", x, y + 75);
                g2.drawString("Your class: " + gp.keyHandler._class,x,y + 110);
                if(gp.keyHandler._class.indexOf("archer") != -1){
                    g2.drawString("Choose a crossbow:", x, y + 140);
                    g2.drawString("[1] Medic Ray: With each attack you gain 25 health", x, y + 160);
                    g2.drawString("[2] Ballistic Cannon: Damage multiplier of 50%", x, y + 180);
                    g2.drawString("[3] Void Slinger: Each has a 50% chance to double strike", x, y + 200);
                    g2.drawString("[4] Crossbow: Default crossbow", x, y + 220);
                }else if(gp.keyHandler._class.indexOf("wizard") != -1){
                    g2.drawString("Please select a spell to add to your scroll", x, y + 140);
                    g2.drawString("[1] Plasma Bolt:", x, y + 160);
                    g2.drawString("[2] Electrocute: ", x, y + 180);
                    g2.drawString("[3] Plasma Rain: ", x, y + 200);
                    g2.drawString("[4] Super Charge: %200 damage bonus", x, y + 220);
                    g2.drawString("[5] Assimilation: Returns 50% of damage as mana", x, y + 240);
                }else if(gp.keyHandler._class.indexOf("warrior") != -1){
                    g2.drawString("Choose a weapon:", x, y + 140);
                    g2.drawString("[1] Sword of the Divine", x, y + 160);
                    g2.drawString("[2] Axe of Terror", x, y + 180);
                    g2.drawString("[3] Pitch Fork of Death", x, y + 200);
                    g2.drawString("[4] Club of Disgrace", x, y + 220);
                }
            }

            if(gp.keyHandler.player2turn && gp.keyHandler.attributes) {
                g2.setFont(g2.getFont().deriveFont(Font.BOLD, 12F));
                g2.drawString("-Player 2- ", x, y + 75);
                g2.drawString("Your class: " + gp.keyHandler._class2,x,y + 110);
                if(gp.keyHandler._class2.indexOf("archer") != -1){
                    g2.drawString("Choose a crossbow:", x, y + 140);
                    g2.drawString("[1] Medic Ray: With each attack you gain 25 health", x, y + 160);
                    g2.drawString("[2] Ballistic Cannon: Damage multiplier of 50%", x, y + 180);
                    g2.drawString("[3] Void Slinger: Each has a 50% chance to double strike", x, y + 200);
                    g2.drawString("[4] Crossbow: Default crossbow", x, y + 220);
                }else if(gp.keyHandler._class2.indexOf("wizard") != -1){
                    g2.drawString("Please select a spell to add to your scroll", x, y + 140);
                    g2.drawString("[1] Plasma Bolt:", x, y + 160);
                    g2.drawString("[2] Electrocute: ", x, y + 180);
                    g2.drawString("[3] Plasma Rain: ", x, y + 200);
                    g2.drawString("[4] Super Charge: %200 damage bonus", x, y + 220);
                    g2.drawString("[5] Assimilation: Returns 50% of damage as mana", x, y + 240);
                }else if(gp.keyHandler._class2.indexOf("warrior") != -1){
                    g2.drawString("Choose a weapon:", x, y + 140);
                    g2.drawString("[1] Sword of the Divine", x, y + 160);
                    g2.drawString("[2] Axe of Terror", x, y + 180);
                    g2.drawString("[3] Pitch Fork of Death", x, y + 200);
                    g2.drawString("[4] Club of Disgrace", x, y + 220);
                }
            }

        }
    }

    public void drawEndScreen(){
        g2.setColor(Color.red);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 48));
        String text = "GAME OVER.";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;


        g2.drawString(text,x,y);
        gp.gameThread.interrupt();
    }

    public int getXforCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
}
