package net.killarexe.jlwin.javax.component;

import javax.swing.*;
import java.awt.*;

/**
 * Date: 13/05/21
 * @author Killar.exe
 * @version 0.1a
 */
public class JXPanel extends JXComponent {

    private final JPanel panel;

    /**
     * Create a JPanel
     * @param width: width of JPanel
     * @param height: height of JPanel
     */
    public JXPanel(int width, int height){
        logger.debug("Creating JPanel");
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(width, height));
    }

    /**
     * Set the background of JPanel;
     * @param color: Color
     */
    @Override
    public void setBackgroundColor(Color color){
        logger.debug("Setting the background color of Panel to '" + color.toString() + "'");
        panel.setBackground(color);
    }

    /**
     * Set the background of JPanel
     * @param r: red
     * @param g: green
     * @param b: blue
     */
    @Override
    public void setBackgroundColor(int r, int g, int b){
        logger.debug("Setting the background color of Panel to '" + r + ", " + g + ", " + b + "'");
        panel.setBackground(new Color(r,g,b));
    }

    /**
     * Set the text color of JPanel
     * @param color: Color
     */
    @Override
    public void setTextColor(Color color){
        logger.debug("Setting the text color of Panel to '" + color.toString() + "'");
        panel.setForeground(color);
    }

    /**
     * Set the text color of JPanel
     * @param r: red
     * @param g: green
     * @param b: blue
     */
    @Override
    public void setTextColor(int r, int g, int b){
        logger.debug("Setting the text color of Panel to '" + r + ", " + g + ", " + b + "'");
        panel.setForeground(new Color(r,g,b));
    }

    /**
     * Get JPanel from Panel
     * @return : return a JPanel
     */
    public JPanel getPanel() {
        return panel;
    }
}
