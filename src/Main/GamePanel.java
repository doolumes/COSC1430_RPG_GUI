package Main;
import javax.swing.*;
import java.awt.*;

import Classes.Archer;
import Classes.Warrior;
import Classes.Wizard;
import Classes.Character;
public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16; //16X16 TILE SIZE
    final int scale = 1;
    public final int tileSize = originalTileSize * scale; //48X48 TILES
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    public final int screenWidth = 768;//768 PX
    public final int screenHeight = 576;//576 PX
    int FPS = 60;
    BackgroundManager backgroundManager = new BackgroundManager(this);
    MouseHandler mouseHandler = new MouseHandler(this);
    KeyHandler keyHandler = new KeyHandler(this);
    Sound sound = new Sound();
    public UI ui = new UI(this);
    Thread gameThread;
    JTextField textField = new JTextField();
    //JGradientButton jGradientButton = new JGradientButton("START");
    //LOading char
    Wizard MAIN_CHARACTER = new Wizard(this, mouseHandler, 0, "human");

    Character player2;
    Character player1;
    //DEFAULT POSITION


    //GAME STATE
    public int gameState;
    public final int startState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int endState = 3;

    //STATS
    private boolean running, mustRender;
    private final double updateRate = 1.0d / 60.0d;
    private long nextStatTime;
    private int fps, ups;

    GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.addMouseListener(mouseHandler);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
        //CREATE CHARACTER
//        if(keyHandler.name.indexOf("wizard") != -1)
//            wizardp1 = new Wizard(this, mouseHandler);
//        else if(keyHandler.name.indexOf("warrior") != -1)
//            archerp1 = new Archer(this, mouseHandler);
//        else if(keyHandler.name.indexOf("warrior") != -1)
//            warriorp1 = new Warrior(this, mouseHandler);
//
//        if(keyHandler.name2.indexOf("wizard") != -1)
//            wizardp2 = new Wizard(this, mouseHandler);
//        else if(keyHandler.name2.indexOf("warrior") != -1)
//            archerp2 = new Archer(this, mouseHandler);
//        else if(keyHandler.name2.indexOf("warrior") != -1)
//            warriorp2 = new Warrior(this, mouseHandler);
    }


    public void setupGame(){
        playMusic();
        gameState = startState;
    }
    public void startGameThread() {
        //

        //
        gameThread = new Thread(this);
        gameThread.start();
    }

    //@Override
    //sleep game loop
//    public void run() {
//        double drawInterval = 1000000000/FPS; //drawing screen 60 times per second
//        double nextDrawTime = System.nanoTime() + drawInterval;
//        while (gameThread != null) {
//
//            //1. UPDATE(movement)
//            update();
//            //2. DRAW(animations)
//            repaint();
//            printStats();
//
//            try{
//                double remainingTime = nextDrawTime - System.nanoTime();
//                remainingTime = remainingTime/1000000;
//
//                if(remainingTime < 0)
//                    remainingTime = 0;
//
//                Thread.sleep((long) remainingTime);
//
//                nextDrawTime +=drawInterval;
//
//            } catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        }
//    }
//
    private void printStats() {
        if (System.currentTimeMillis() > nextStatTime) {
            System.out.println(String.format("FPS: %d, UPS: %d", FPS, ups));
            fps = 60;
            ups = 0;
            nextStatTime = System.currentTimeMillis() + 1000;
        }
    }
    @Override
    //accumulator method
    public void run(){
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null){
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                printStats();
                delta--;
            }
        }
    }

    public void update() {

        if(gameState == playState) {
            player1.update();

            player2.update();
        }

        if(gameState == pauseState){

        }
        ups++;
    }

    public void paintComponent(Graphics g) {
        //background
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        //background
        backgroundManager.draw(g2);
        //TITLE SCREEN
        if(gameState == startState){}
        else if(gameState == playState){
            //player 1 class selection
            player1.draw(g2,0);

            //player 2 class selection
            player2.draw(g2,0);
        }


        //warrior
        //warrior.draw(g2);

        //archer
        //archer.draw(g2);

        //ui
        ui.draw(g2);

        g2.dispose();

        fps++;
    }
    public void playMusic(){
        sound.setFile();
        sound.play();
        sound.loop();
    }

    public void stopMusic(){
        sound.stop();
    }

    public void playSE(){
        sound.setFile();
        sound.play();
    }
}
