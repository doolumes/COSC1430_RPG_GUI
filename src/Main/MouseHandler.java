package Main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {

    GamePanel gp;
    boolean player1turn, player2turn;

    MouseHandler(GamePanel gp){
        this.gp = gp;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

        if(gp.ui.startScreenState == 0){
            if((e.getX() >= 192 && e.getX() <= 586)
                    && (e.getY() >= 460 && e.getY() <= 555)
                    && (gp.gameState == gp.startState)) {
                gp.ui.startScreenState ++;
            }
        }

        else if(gp.ui.startScreenState == 1){

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
