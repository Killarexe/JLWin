package net.killarexe.jlwin.file;

import javax.swing.*;
import java.awt.*;

public class Image {

    private java.awt.Image image;
    private ImageIcon icon;
    
    public Image(String path){
        icon = new ImageIcon(path);
        image = icon.getImage();
    }

    public Graphics2D drawImage(int x, int y, int width, int height){
        Graphics2D graphics2D = (Graphics2D)image.getGraphics();
        graphics2D.drawImage(image, x, y , width, height, null);
        return graphics2D;
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
}
