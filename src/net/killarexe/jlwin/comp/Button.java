package net.killarexe.jlwin.comp;

import net.killarexe.jlwin.util.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Date: 13/05/21
 * @author Killar.exe
 * @version 0.1a
 */
public class Button {

    private JButton button;
    private Logger logger = new Logger(getClass());

    public Button(String name, int width, int height, int x, int y){
        logger.debug("Creating Button: '" + name + "'");
        button = new JButton(name);
        button.setBounds(x, y, width, height);
    }

    public Button(int width, int height, String name, Panel panel, BorderLayout layout){
        logger.debug("Creating Button: '" + name + "'");
        button = new JButton(name);
        button.setSize(width, height);
        panel.getPanel().add(button, layout);
    }

    public void setText(String name){
        logger.debug("Setting text of Button '" + button.getName() + "' to '" + name + "'");
        button.setText(name);
    }

    public void setBackgroundColor(Color color){
        logger.debug("Setting the background color of Button '" + button.getName() + "' to '" + color.toString() + "'");
        button.setBackground(color);
    }

    public void setBackgroundColor(int r, int g, int b){
        logger.debug("Setting the background color of Button '" + button.getName() + "' to '" + r + ", " + g + ", " + b + "'");
        button.setBackground(new Color(r,g,b));
    }

    public void setTextColor(Color color){
        logger.debug("Setting the text color of Button '" + button.getName() + "' to '" + color.toString() + "'");
        button.setForeground(color);
    }

    public void setTextColor(int r, int g, int b){
        logger.debug("Setting the background color of Button '" + button.getName() + "' to '" + r + ", " + g + ", " + b + "'");
        button.setForeground(new Color(r,g,b));
    }

    public void setFont(Font font){
        logger.debug("Setting the font of button '" + button.getName() + "' to '" + font.toString() + "'");
        button.setFont(font);
    }

    public void setFont(String text, int type, int size){
        logger.debug("Setting the font of button '" + button.getName() + "' to '" + text + ", " + type + ", " + size + "'");
        button.setFont(new Font(text, type, size));
    }

    public void setAlignment(float x, float y){
        button.setAlignmentX(x);
        button.setAlignmentY(y);
    }

    public void addListener(ActionListener listener){
        logger.debug("Adding Action Listener to Button '" + button.getName() + "'");
        button.addActionListener(listener);
    }

    public JButton getButton() {
        return button;
    }
}
