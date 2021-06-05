package net.killarexe.jlwin.comp;

import net.killarexe.jlwin.util.Logger;

import javax.swing.*;
import java.awt.*;

/**
 * Date: 17/05/21
 * @author Killar.exe
 * @version 0.1a
 */
public class TextField {

    private JTextField field;
    private Logger logger = new Logger(getClass());

    /**
     * Add a TextField
     * @param width: width of JTextField
     * @param height: height of JTextField
     * @param isEditable: if you can edit of JTextField
     */
    public TextField(int width, int height, boolean isEditable){
        logger.debug("Creating TextField");
        field = new JTextField();
        field.setSize(width, height);
        field.setEditable(isEditable);
    }

    /**
     * Change color of the background of JTextField
     * @param color: Color
     */
    public void setBackgroundColor(Color color){
        logger.debug("Setting the background color of TextField to '" + color.toString() + "'");
        field.setBackground(color);
    }

    /**
     * Change color of the background of JTextField
     * @param r:red
     * @param g:green
     * @param b:blue
     */
    public void setBackgroundColor(int r, int g, int b){
        logger.debug("Setting the background color of TextField to '" + r + ", " + g + ", " + b + "'");
        field.setBackground(new Color(r,g,b));
    }

    /**
     * Change color of the text color of JTextField
     * @param color: color
     */
    public void setTextColor(Color color){
        logger.debug("Setting the text color of TextField to '" + color.toString() + "'");
        field.setForeground(color);
    }

    /**
     * Change color of the text color of JTextField
     * @param r: red
     * @param g: green
     * @param b: blue
     */
    public void setTextColor(int r, int g, int b){
        logger.debug("Setting the text color of TextField to '" + r + ", " + g + ", " + b + "'");
        field.setForeground(new Color(r,g,b));
    }

    /**
     * Change font of JTextField
     * @param font: Font
     */
    public void setFont(Font font){
        logger.debug("Setting the font of TextField to '" + font.toString() + "'");
        field.setFont(font);
    }

    /**
     * Change font of JTextField
     * @param text: name of a font
     * @param type: type of the font
     * @param size: size of the font
     */
    public void setFont(String text, int type, int size){
        logger.debug("Setting the font of TextField to '" + text + ", " + type + ", " + size + "'");
        field.setFont(new Font(text, type, size));
    }

    /**
     * Set text of JTextField
     * @param text: Text
     */
    public void setText(String text){
        logger.debug("Setting text of TextField to '" + text + "'");
        field.setText(text);
    }

    /**
     * Get Text of JTextField
     * @return
     */
    public String getText(){
        return field.getText();
    }

    /**
     * Get JTextField of TextField
     * @return
     */
    public JTextField getTextField() {
        return field;
    }
}
