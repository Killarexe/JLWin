package net.killarexe.jlwin.comp;

import net.killarexe.jlwin.util.Logger;

import javax.swing.*;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class TextPane extends LComponent{

    private final JTextPane pane;

    /**
     * Date: 13/05/21
     * @author Killar.exe
     * @version 0.1a
     */

    /**
     * Add a TextPane
     * @param width: width of JTextPane
     * @param height: height of JTextPane
     * @param isEditable: if you can edit of JTextPane
     */
    public TextPane(int width, int height, boolean isEditable){
        logger.debug("Creating TextPane");
        pane = new JTextPane();
        pane.setSize(width, height);
        pane.setEditable(isEditable);
    }

    /**
     * Change color of the background of JTextPane
     * @param color: Color
     */
    @Override
    public void setBackgroundColor(Color color){
        logger.debug("Setting the background color of TextPane to '" + color.toString() + "'");
        pane.setBackground(color);
    }

    /**
     * Change color of the background of JTextPane
     * @param r:red
     * @param g:green
     * @param b:blue
     */
    @Override
    public void setBackgroundColor(int r, int g, int b){
        logger.debug("Setting the background color of TextPane to '" + r + ", " + g + ", " + b + "'");
        pane.setBackground(new Color(r,g,b));
    }

    /**
     * Change color of the global text color of JTextPane
     * @param color: color
     */
    @Override
    public void setTextColor(Color color){
        logger.debug("Setting the text color of TextPane to '" + color.toString() + "'");
        pane.setForeground(color);
    }

    /**
     * Change color of the global text color of JTextPane
     * @param r: red
     * @param g: green
     * @param b: blue
     */
    @Override
    public void setTextColor(int r, int g, int b){
        logger.debug("Setting the text color of TextPane to '" + r + ", " + g + ", " + b + "'");
        pane.setForeground(new Color(r,g,b));
    }

    /**
     * Change font of JTextPane
     * @param font: Font
     */
    @Override
    public void setFont(Font font){
        logger.debug("Setting the font of TextPane to '" + font.toString() + "'");
        pane.setFont(font);
    }

    /**
     * Change font of JTextPane
     * @param text: name of a font
     * @param type: type of the font
     * @param size: size of the font
     */
    @Override
    public void setFont(String text, int type, int size){
        logger.debug("Setting the font of TextPane to '" + text + ", " + type + ", " + size + "'");
        pane.setFont(new Font(text, type, size));
    }

    /**
     * Set text of JTextPane
     * @param text: Text
     */
    public void setText(String text){
        logger.debug("Setting text of TextPane to '" + text + "'");
        pane.setText(text);
    }

    /**
     * Get Text of JTextPane
     * @return
     */
    public String getText(){
        return pane.getText();
    }

    /**
     * Get JTextPane of TextPane
     * @return
     */
    public JTextPane getTextPane() {
        return pane;
    }
}
