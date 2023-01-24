package Main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageFlip {

    public static BufferedImage flip(FileInputStream input){
        BufferedImage returnedImage = null;
//        Color c=new Color(1f,0f,0f,.5f );
//        c.getRGB();
            try{
                BufferedImage image = ImageIO.read(input);
                long count = 0;
                int width = image.getWidth();
                int height = image.getHeight();
                BufferedImage flipped = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
                for(int y = 0; y < height; y++){
                    for(int x = 0; x < width; x++){
                        if(image.getRGB(x,y) == 16777215 || image.getRGB(x,y) == 0) {
                            continue;
                            //flipped.setRGB(width - 1 - x, y, new Color(0, 0, 139, 1).getRGB());
                        }
                        else
                            flipped.setRGB(width-1-x, y, image.getRGB(x,y));
                        count++;
                    }
                }//16777215
                returnedImage =  flipped;
            }catch(IOException e){
                e.printStackTrace();
            }
        return returnedImage;
    }
}
