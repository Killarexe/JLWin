package net.killarexe.jlwin.javax.component;

import javax.swing.*;
import java.awt.*;

/**
 * Date: 17/05/21
 * @author Killar.exe
 * @version 0.1a
 */
public class JXTextField extends JXComponent {

    private final JTextField field;

    /**
     * Add a TextField
     * @param width: width of JTextField
     * @param height: height of JTextField
     * @param isEditable: if you can edit of JTextField
     */
    public JXTextField(int width, int height, boolean isEditable){
        logger.debug("Creating TextField");
        field = new JTextField();
        field.setSize(width, height);
        field.setEditable(isEditable);
    }

    /**
     * Change color of the background of JTextField
     * @param color: Color
     */
    @Override
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
    @Override
    public void setBackgroundColor(int r, int g, int b){
        logger.debug("Setting the background color of TextField to '" + r + ", " + g + ", " + b + "'");
        field.setBackground(new Color(r,g,b));
    }

    /**
     * Change color of the text color of JTextField
     * @param color: color
     */
    @Override
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
    @Override
    public void setTextColor(int r, int g, int b){
        logger.debug("Setting the text color of TextField to '" + r + ", " + g + ", " + b + "'");
        field.setForeground(new Color(r,g,b));
    }

    /**
     * Change font of JTextField
     * @param font: Font
     */
    @Override
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
    @Override
    public void setFont(String text, int type, int size){
        logger.debug("Setting the font of TextField to '" + text + ", " + type + ", " + size + "'");
        field.setFont(new Font(text, type, size));
    }

    /**
     * Set text of JTextField
     * @param text: Text
     */
    @Override
    public void setText(String text){
        logger.debug("Setting text of TextField to '" + text + "'");
        field.setText(text);
    }

    /**
     * Get Text of JTextField
     * @return : return a String
     */
    public String getText(){
        return field.getText();
    }

    /**
     * Get JTextField of TextField
     * @return : return a JTextField
     */
    public JTextField getTextField() {
        return field;
    }
}
