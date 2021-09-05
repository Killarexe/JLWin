package net.killarexe.jlwin.file;

import net.killarexe.jlwin.javax.component.JXWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

/**
 * Date: 05/09/2021
 * @author Killar.exe
 * @version 1.1a
 */
public class Image {

    private java.awt.Image image;
    private BufferedImage bufferedImage;
    private ImageIcon icon;
    
    public Image(String path){
        icon = new ImageIcon(path);
        try {
            bufferedImage = ImageIO.read(new File(path));
        }catch (IOException e){
            e.printStackTrace();
        }
        image = icon.getImage();
    }

    public void drawImage(JFrame frame, int x, int y, int width, int height){
        Graphics g = frame.getGraphics();
        g.drawImage(bufferedImage, x, y, width, height,null, null);
    }

    public java.awt.Image getImage() {
        return image;
    }

    public void setImage(java.awt.Image image) {
        this.image = image;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }
}
