package net.killarexe.jlwin.javax.component;

import javax.swing.*;
import java.awt.*;

/**
 * Date: 13/05/21
 * @author Killar.exe
 * @version 0.1a
 */
public class JXTextArea extends JXComponent {

    private final JTextArea textArea;

    /**
     * Add a TextArea
     * @param width: width of JTextArea
     * @param height: height of JTextArea
     * @param isEditable: if you can edit of JTextArea
     */
    public JXTextArea(int width, int height, boolean isEditable){
        logger.debug("Creating TextArea");
        textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(width, height));
        textArea.setEditable(isEditable);
        textArea.setWrapStyleWord(true);
    }

    /**
     * Change color of the background of JTextArea
     * @param color: Color
     */
    @Override
    public void setBackgroundColor(Color color){
        logger.debug("Setting the background color of TextArea to '" + color.toString() + "'");
        textArea.setBackground(color);
    }

    /**
     * Change color of the background of JTextArea
     * @param r:red
     * @param g:green
     * @param b:blue
     */
    @Override
    public void setBackgroundColor(int r, int g, int b){
        logger.debug("Setting the background color of TextArea to '" + r + ", " + g + ", " + b + "'");
        textArea.setBackground(new Color(r,g,b));
    }

    /**
     * Change color of the text color of JTextArea
     * @param color: color
     */
    @Override
    public void setTextColor(Color color){
        logger.debug("Setting the text color of TextArea to '" + color.toString() + "'");
        textArea.setForeground(color);
    }

    /**
     * Change color of the text color of JTextArea
     * @param r: red
     * @param g: green
     * @param b: blue
     */
    @Override
    public void setTextColor(int r, int g, int b){
        logger.debug("Setting the text color of TextArea to '" + r + ", " + g + ", " + b + "'");
        textArea.setForeground(new Color(r,g,b));
    }

    /**
     * Change font of JTextArea
     * @param font: Font
     */
    @Override
    public void setFont(Font font){
        logger.debug("Setting the font of TextArea to '" + font.toString() + "'");
        textArea.setFont(font);
    }

    /**
     * Change font of JTextArea
     * @param text: name of a font
     * @param type: type of the font
     * @param size: size of the font
     */
    @Override
    public void setFont(String text, int type, int size){
        logger.debug("Setting the font of TextArea to '" + text + ", " + type + ", " + size + "'");
        textArea.setFont(new Font(text, type, size));
    }

    /**
     * Set text of JTextArea
     * @param text: Text
     */
    @Override
    public void setText(String text){
        logger.debug("Setting text of TextArea to '" + text + "'");
        textArea.append(text);
    }

    /**
     * Set alignement of JTextArea
     * @param x: default x position
     * @param y: defeult y position
     */
    @Override
    public void setAlignment(float x, float y){
        textArea.setAlignmentX(x);
        textArea.setAlignmentY(y);
    }

    /**
     * Get Text of JTextArea
     * @return : return a String
     */
    public String getText(){
        return textArea.getText();
    }

    /**
     * Get JTextArea of TextArea
     * @return : return a JTextArea
     */
    public JTextArea getTextArea() {
        return textArea;
    }
}
