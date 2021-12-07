package net.killarexe.jlwin.exemple;

import net.killarexe.jlwin.file.Image;
import net.killarexe.jlwin.javax.component.JXWindow;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MovingImageWindow extends KeyAdapter {

    private static JXWindow window;
    private static Image image;

    public MovingImageWindow(){
        start();
    }

    private void start(){
        window = new JXWindow("MovingImageWindow", 1280, 720);
        window.getWindow().addKeyListener(this);
        image = new Image("C:\\Users\\hc\\Pictures\\Saved Pictures\\PDP.png", window.getWindow());
        image.drawImage(100, 100, 512, 512);
        image.setImagePos(1200, 500);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_D){
            image.moveImage(10, 0);
            System.out.println("Test");
        }
    }
}
