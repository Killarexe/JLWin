package net.killarexe.jlwin.javax.component;

import net.killarexe.jlwin.javax.enums.ScrollBar;

import javax.swing.*;
import java.awt.*;

/**
 * Date: 13/05/21
 * @author Killar.exe
 * @version 0.1a
 */
public class JXScrollPane extends JXComponent {

    private final JScrollPane scrollPane;

    /**
     * Create a JScrollPane
     * @param width: width of the JScrollPane
     * @param height: height of the JScrollPane
     * @param scrollBar: for the scrollbar
     */
    public JXScrollPane(int width, int height, ScrollBar scrollBar){
        logger.debug("Creating ScrollPane");
        scrollPane = new JScrollPane();
        switch (scrollBar){
            case VERTICAL:
                scrollPane.createVerticalScrollBar();
                break;
            case HORIZONTAL:
                scrollPane.createHorizontalScrollBar();
                break;
            case BOTH:
                scrollPane.createVerticalScrollBar();
                scrollPane.createHorizontalScrollBar();
                break;
        }
    }

    /**
     * Create a JScrollPane
     * @param width: width of the JScrollPane
     * @param height: height of the JScrollPane
     * @param component: if the JScrollPane Conatains a JTextField
     * @param scrollBar: for the scrollbar
     */
    public JXScrollPane(int width, int height, Component component, ScrollBar scrollBar){
        logger.debug("Creating ScrollPane");
        scrollPane = new JScrollPane(component);
        scrollPane.setPreferredSize(new Dimension(width, height));
        switch (scrollBar){
            case VERTICAL:
                scrollPane.createVerticalScrollBar();
                break;
            case HORIZONTAL:
                scrollPane.createHorizontalScrollBar();
                break;
            case BOTH:
                scrollPane.createVerticalScrollBar();
                scrollPane.createHorizontalScrollBar();
                break;
        }
    }

    /**
     * Create a JScrollPane
     * @param width: width of the JScrollPane
     * @param height: height of the JScrollPane
     * @param scrollBar: for the scrollbar
     */
    public JXScrollPane(int width, int height, JXPanel JXPanel, String layout, ScrollBar scrollBar){
        logger.debug("Creating ScrollPane");
        scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(width, height));
        JXPanel.getPanel().add(scrollPane, layout);
        switch (scrollBar){
            case VERTICAL:
                scrollPane.createVerticalScrollBar();
                break;
            case HORIZONTAL:
                scrollPane.createHorizontalScrollBar();
                break;
            case BOTH:
                scrollPane.createVerticalScrollBar();
                scrollPane.createHorizontalScrollBar();
                break;
        }
    }

    /**
     * Create a JScrollPane
     * @param width: width of the JScrollPane
     * @param height: height of the JScrollPane
     * @param component: if the JScrollPane Conatains a JTextArea
     * @param scrollBar: for the scrollbar
     */
    public JXScrollPane(int width, int height, Component component, JXPanel JXPanel, String layout, ScrollBar scrollBar){
        logger.debug("Creating ScrollPane");
        scrollPane = new JScrollPane(component);
        scrollPane.setPreferredSize(new Dimension(width, height));
        JXPanel.getPanel().add(scrollPane, layout);
        switch (scrollBar){
            case VERTICAL:
                scrollPane.createVerticalScrollBar();
                break;
            case HORIZONTAL:
                scrollPane.createHorizontalScrollBar();
                break;
            case BOTH:
                scrollPane.createVerticalScrollBar();
                scrollPane.createHorizontalScrollBar();
                break;
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
     * @param r: red
     * @param g: green
     * @param b: blue
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
     * @return : return a JScrollBar
     */
    public JScrollBar getHorScrollBar(){
        return scrollPane.getHorizontalScrollBar();
    }

    /**
     * Get Verctical Scroll Bar
     * @return : return a JScrollBar
     */
    public JScrollBar getVerScrollBar(){
        return scrollPane.getVerticalScrollBar();
    }

    /**
     * Get the JScrollPane from ScrollPane
     * @return : return a JScrollPane
     */
    public JScrollPane getScrollPane() {
        return scrollPane;
    }
}
