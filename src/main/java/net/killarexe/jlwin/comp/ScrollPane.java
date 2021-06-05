package net.killarexe.jlwin.comp;

import net.killarexe.jlwin.util.Logger;

import javax.swing.*;
import java.awt.*;

/**
 * Date: 13/05/21
 * @author Killar.exe
 * @version 0.1a
 */
public class ScrollPane extends LComponent{

    private final JScrollPane scrollPane;

    /**
     * Create a JScrollPane
     * @param width: width of the JScrollPane
     * @param height: height of the JScrollPane
     * @param hasVerScrollBar: if the JScrollPane have a Vertical Scroll Bar
     * @param hasHorScrollBar: if the JScrollPane have a Horizontal Scroll Bar
     */
    public ScrollPane(int width, int height, boolean hasVerScrollBar, boolean hasHorScrollBar){
        logger.debug("Creating ScrollPane");
        scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(width, height));
        if(hasHorScrollBar) {
            scrollPane.createHorizontalScrollBar();
        }
        if(hasVerScrollBar){
            scrollPane.createVerticalScrollBar();
        }
    }

    /**
     * Create a JScrollPane
     * @param width: width of the JScrollPane
     * @param height: height of the JScrollPane
     * @param textArea: if the JScrollPane Conatains a JTextArea
     * @param hasVerScrollBar: if the JScrollPane have a Vertical Scroll Bar
     * @param hasHorScrollBar: if the JScrollPane have a Horizontal Scroll Bar
     */
    public ScrollPane(int width, int height, TextArea textArea, boolean hasVerScrollBar, boolean hasHorScrollBar){
        logger.debug("Creating ScrollPane");
        scrollPane = new JScrollPane(textArea.getTextArea());
        scrollPane.setPreferredSize(new Dimension(width, height));
        if(hasHorScrollBar) {
            scrollPane.createHorizontalScrollBar();
        }
        if(hasVerScrollBar){
            scrollPane.createVerticalScrollBar();
        }
    }

    /**
     * Create a JScrollPane
     * @param width: width of the JScrollPane
     * @param height: height of the JScrollPane
     * @param textPane: if the JScrollPane Conatains a JTextPane
     * @param hasVerScrollBar: if the JScrollPane have a Vertical Scroll Bar
     * @param hasHorScrollBar: if the JScrollPane have a Horizontal Scroll Bar
     */
    public ScrollPane(int width, int height, TextPane textPane, boolean hasVerScrollBar, boolean hasHorScrollBar){
        logger.debug("Creating ScrollPane");
        scrollPane = new JScrollPane(textPane.getTextPane());
        scrollPane.setPreferredSize(new Dimension(width, height));
        if(hasHorScrollBar) {
            scrollPane.createHorizontalScrollBar();
        }
        if(hasVerScrollBar){
            scrollPane.createVerticalScrollBar();
        }
    }

    /**
     * Create a JScrollPane
     * @param width: width of the JScrollPane
     * @param height: height of the JScrollPane
     * @param textField: if the JScrollPane Conatains a JTextField
     * @param hasVerScrollBar: if the JScrollPane have a Vertical Scroll Bar
     * @param hasHorScrollBar: if the JScrollPane have a Horizontal Scroll Bar
     */
    public ScrollPane(int width, int height, TextField textField, boolean hasVerScrollBar, boolean hasHorScrollBar){
        logger.debug("Creating ScrollPane");
        scrollPane = new JScrollPane(textField.getTextField());
        scrollPane.setPreferredSize(new Dimension(width, height));
        if(hasHorScrollBar) {
            scrollPane.createHorizontalScrollBar();
        }
        if(hasVerScrollBar){
            scrollPane.createVerticalScrollBar();
        }
    }

    /**
     * Create a JScrollPane
     * @param width: width of the JScrollPane
     * @param height: height of the JScrollPane
     * @param hasVerScrollBar: if the JScrollPane have a Vertical Scroll Bar
     * @param hasHorScrollBar: if the JScrollPane have a Horizontal Scroll Bar
     */
    public ScrollPane(int width, int height, Panel panel, String layout, boolean hasVerScrollBar, boolean hasHorScrollBar){
        logger.debug("Creating ScrollPane");
        scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(width, height));
        panel.getPanel().add(scrollPane, layout);
        if(hasHorScrollBar) {
            scrollPane.createHorizontalScrollBar();
        }
        if(hasVerScrollBar){
            scrollPane.createVerticalScrollBar();
        }
    }

    /**
     * Create a JScrollPane
     * @param width: width of the JScrollPane
     * @param height: height of the JScrollPane
     * @param textArea: if the JScrollPane Conatains a JTextArea
     * @param hasVerScrollBar: if the JScrollPane have a Vertical Scroll Bar
     * @param hasHorScrollBar: if the JScrollPane have a Horizontal Scroll Bar
     */
    public ScrollPane(int width, int height, TextArea textArea, Panel panel, String layout, boolean hasVerScrollBar, boolean hasHorScrollBar){
        logger.debug("Creating ScrollPane");
        scrollPane = new JScrollPane(textArea.getTextArea());
        scrollPane.setPreferredSize(new Dimension(width, height));
        panel.getPanel().add(scrollPane, layout);
        if(hasHorScrollBar) {
            scrollPane.createHorizontalScrollBar();
        }
        if(hasVerScrollBar){
            scrollPane.createVerticalScrollBar();
        }
    }

    /**
     * Create a JScrollPane
     * @param width: width of the JScrollPane
     * @param height: height of the JScrollPane
     * @param textPane: if the JScrollPane Conatains a JTextPane
     * @param hasVerScrollBar: if the JScrollPane have a Vertical Scroll Bar
     * @param hasHorScrollBar: if the JScrollPane have a Horizontal Scroll Bar
     */
    public ScrollPane(int width, int height, TextPane textPane, Panel panel, String layout, boolean hasVerScrollBar, boolean hasHorScrollBar){
        logger.debug("Creating ScrollPane");
        scrollPane = new JScrollPane(textPane.getTextPane());
        scrollPane.setPreferredSize(new Dimension(width, height));
        panel.getPanel().add(scrollPane, layout);
        if(hasHorScrollBar) {
            scrollPane.createHorizontalScrollBar();
        }
        if(hasVerScrollBar){
            scrollPane.createVerticalScrollBar();
        }
    }

    /**
     * Create a JScrollPane
     * @param width: width of the JScrollPane
     * @param height: height of the JScrollPane
     * @param textField: if the JScrollPane Conatains a JTextField
     * @param hasVerScrollBar: if the JScrollPane have a Vertical Scroll Bar
     * @param hasHorScrollBar: if the JScrollPane have a Horizontal Scroll Bar
     */
    public ScrollPane(int width, int height, TextField textField, Panel panel, String layout, boolean hasVerScrollBar, boolean hasHorScrollBar){
        logger.debug("Creating ScrollPane");
        scrollPane = new JScrollPane(textField.getTextField());
        scrollPane.setPreferredSize(new Dimension(width, height));
        panel.getPanel().add(scrollPane, layout);
        if(hasHorScrollBar) {
            scrollPane.createHorizontalScrollBar();
        }
        if(hasVerScrollBar){
            scrollPane.createVerticalScrollBar();
        }
    }

    /**
     * Set the background of the JScrollPane
     * @param color: Color
     */
    @Override
    public void setBackgroundColor(Color color){
        logger.debug("Setting the background color of ScrollPane to '" + color.toString() + "'");
        scrollPane.setBackground(color);
    }

    /**
     * Set the background of the JScrollPane
     * @param r: red
     * @param g: green
     * @param b: blue
     */
    @Override
    public void setBackgroundColor(int r, int g, int b){
        logger.debug("Setting the background color of ScrollPane to '" + r + ", " + g + ", " + b + "'");
        scrollPane.setBackground(new Color(r,g,b));
    }

    /**
     * Set the foreground of the JScrollPane
     * @param color: Color
     */
    @Override
    public void setForegroundColor(Color color){
        logger.debug("Setting the foreground color of ScrollPane to '" + color.toString() + "'");
        scrollPane.setForeground(color);
    }

    /**
     * Set the foreground of the JScrollPane
     * @param r
     * @param g
     * @param b
     */
    @Override
    public void setForegroundColor(int r, int g, int b){
        logger.debug("Setting the foreground color of ScrollPane to '" + r + ", " + g + ", " + b + "'");
        scrollPane.setForeground(new Color(r,g,b));
    }

    @Override
    public void setAlignment(float x, float y){
        scrollPane.setAlignmentX(x);
        scrollPane.setAlignmentY(y);
    }

    /**
     * Get Horizontal Scroll Bar
     * @return
     */
    public JScrollBar getHorScrollBar(){
        return scrollPane.getHorizontalScrollBar();
    }

    /**
     * Get Verctical Scroll Bar
     * @return
     */
    public JScrollBar getVerScrollBar(){
        return scrollPane.getVerticalScrollBar();
    }

    /**
     * Get the JScrollPane from ScrollPane
     * @return
     */
    public JScrollPane getScrollPane() {
        return scrollPane;
    }
}
