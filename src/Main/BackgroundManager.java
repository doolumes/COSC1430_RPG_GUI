package Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class BackgroundManager {
    GamePanel gp;
    Background[] backgrounds;
    private int backgroundNum;

    public BackgroundManager(GamePanel gp){
        this.gp = gp;

        backgrounds = new Background[8];

        getBackgroundImage();
    }

    public void getBackgroundImage(){
        try{
            backgrounds[0] = new Background();
            backgrounds[0].image = ImageIO.read(new FileInputStream("src-images\\Backgrounds\\600px-Bg1.png"));

            backgrounds[1] = new Background();
            backgrounds[1].image = ImageIO.read(new FileInputStream("src-images\\Backgrounds\\600px-Bg2New.png"));

            backgrounds[2] = new Background();
            backgrounds[2].image = ImageIO.read(new FileInputStream("src-images\\Backgrounds\\600px-Bg3New.png"));

            backgrounds[3] = new Background();
            backgrounds[3].image = ImageIO.read(new FileInputStream("src-images\\Backgrounds\\600px-Bg4.png"));

            backgrounds[4] = new Background();
            backgrounds[4].image = ImageIO.read(new FileInputStream("src-images\\Backgrounds\\600px-Bg5.png"));

            backgrounds[5] = new Background();
            backgrounds[5].image = ImageIO.read(new FileInputStream("src-images\\Backgrounds\\600px-Bg6.png"));

            backgrounds[6] = new Background();
            backgrounds[6].image = ImageIO.read(new FileInputStream("src-images\\Backgrounds\\600px-Bg7New.png"));

            backgrounds[7] = new Background();
            backgrounds[7].image = ImageIO.read(new FileInputStream("src-images\\Backgrounds\\600px-DreadWarBg2.png"));
            backgroundNum = (int)(Math.random() * backgrounds.length);
        }catch(IOException e){
           e.printStackTrace();
        }


    }
    public void draw(Graphics2D g2){
        g2.drawImage(backgrounds[backgroundNum].image,0,0,gp.screenWidth, gp.screenHeight, null);
    }
}
