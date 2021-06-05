package net.killarexe.jlwin.comp;

import net.killarexe.jlwin.util.Logger;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;

/**
 * Date: 13/05/21
 * @author Killar.exe
 * @version 0.1a
 */
public class ColorChooser {

    private JColorChooser chooser;
    private Logger logger = new Logger(getClass());

    public ColorChooser(int width, int height, Color defaultColor){
        logger.info("Creating ColorChooser");
        chooser = new JColorChooser();
        chooser.setColor(defaultColor);
        chooser.setSize(width, height);
    }

    public ColorChooser(int width, int height, int defaultr, int defaultg, int defaultb){
        logger.info("Creating ColorChooser");
        chooser = new JColorChooser();
        chooser.setColor(new Color(defaultr, defaultg, defaultb));
        chooser.setSize(width, height);
    }

    public ColorChooser(int width, int height, int x, int y, Color defaultColor){
        logger.info("Creating ColorChooser");
        chooser = new JColorChooser();
        chooser.setColor(defaultColor);
        chooser.setBounds(x, y, width, height);
    }

    public ColorChooser(int width, int height, int x, int y, int defaultr, int defaultg, int defaultb){
        logger.info("Creating ColorChooser");
        chooser = new JColorChooser();
        chooser.setColor(new Color(defaultr, defaultg, defaultb));
        chooser.setBounds(x, y, width, height);
    }

    public ColorChooser(int width, int height, Color defaultColor, String toolTip){
        logger.info("Creating ColorChooser");
        chooser = new JColorChooser();
        chooser.setColor(defaultColor);
        chooser.setSize(width, height);
        chooser.setToolTipText(toolTip);
    }

    public ColorChooser(int width, int height, int defaultr, int defaultg, int defaultb, String toolTip){
        logger.info("Creating ColorChooser");
        chooser = new JColorChooser();
        chooser.setColor(new Color(defaultr, defaultg, defaultb));
        chooser.setSize(width, height);
        chooser.setToolTipText(toolTip);
    }

    public ColorChooser(int width, int height, int x, int y, Color defaultColor, String toolTip){
        logger.info("Creating ColorChooser");
        chooser = new JColorChooser();
        chooser.setColor(defaultColor);
        chooser.setBounds(x, y, width, height);
        chooser.setToolTipText(toolTip);
    }

    public ColorChooser(int width, int height, int x, int y, int defaultr, int defaultg, int defaultb, String toolTip){
        logger.info("Creating ColorChooser");
        chooser = new JColorChooser();
        chooser.setColor(new Color(defaultr, defaultg, defaultb));
        chooser.setBounds(x, y, width, height);
        chooser.setToolTipText(toolTip);
    }

    public void setToolTipText(String name){
        logger.debug("Setting text of Button '" + chooser.getName() + "' to '" + name + "'");
        chooser.setToolTipText(name);
    }

    public void setBackgroundColor(Color color){
        logger.debug("Setting the background color of Button '" + chooser.getName() + "' to '" + color.toString() + "'");
        chooser.setBackground(color);
    }

    public void setBackgroundColor(int r, int g, int b){
        logger.debug("Setting the background color of Button '" + chooser.getName() + "' to '" + r + ", " + g + ", " + b + "'");
        chooser.setBackground(new Color(r,g,b));
    }

    public void setTextColor(Color color){
        logger.debug("Setting the text color of Button '" + chooser.getName() + "' to '" + color.toString() + "'");
        chooser.setForeground(color);
    }

    public void setTextColor(int r, int g, int b){
        logger.debug("Setting the background color of Button '" + chooser.getName() + "' to '" + r + ", " + g + ", " + b + "'");
        chooser.setForeground(new Color(r,g,b));
    }

    public void setFont(Font font){
        logger.debug("Setting the font of button '" + chooser.getName() + "' to '" + font.toString() + "'");
        chooser.setFont(font);
    }

    public void setFont(String text, int type, int size){
        logger.debug("Setting the font of button '" + chooser.getName() + "' to '" + text + ", " + type + ", " + size + "'");
        chooser.setFont(new Font(text, type, size));
    }

    public void addListener(AncestorListener listener){
        logger.debug("Adding Ancestor Listener to Button '" + chooser.getName() + "'");
        chooser.addAncestorListener(listener);
    }

    public Color getSelectedColor(){
        return chooser.getColor();
    }

    public void setSelectedColor(Color color){
        chooser.setColor(color);
    }

    public void setSelectedColor(int r, int g, int b){
        chooser.setColor(r, g, b);
    }

    public JColorChooser getChooser() {
        return chooser;
    }
}
