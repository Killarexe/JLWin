package net.killarexe.jlwin.comp;

import net.killarexe.jlwin.util.Logger;

import javax.swing.*;
import java.awt.*;

/**
 * Date 13/05/21
 * @author Killar.exe
 * @version 0.1a
 */
public class Window extends LComponent{
    
    private final JFrame window;

    /**
     * Create the JFrame/Window
     * @param name: name/title of the JFrame/Window
     * @param width: width of JFrame/Window
     * @param height: height of JFrame/Window
     */
    public Window(String name, int width, int height){
        logger.debug("Creating Window: '" + name + "'");
        window = new JFrame(name);
        window.setSize(width, height);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public Window(String name, int width, int height, LoadingScreen screen){
        logger.debug("Creating Window: '" + name + "'");
        window = new JFrame(name);
        window.setSize(width, height);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    /**
     * Add a MenuBar to the JFrame/Window
     * @param menu: JMenuBar
     */
    public void addBar(Menu menu){
        logger.debug("Adding Menu Bar to Window: '" + window.getName() + "'");
        window.setJMenuBar(menu.getBar());
    }

    /**
     * Add a component to the JFrame/Window
     * @param component: Component
     */
    public void addComponent(Component component){
        logger.debug("Adding Component: '" + component.getName() + "' to Window: '" + window.getName() + "'");
        window.add(component);
    }

    /**
     * Add a component to the JFrame/Window
     * @param component: Component
     * @param layout: Layout
     */
    public void addComponent(Component component, String layout){
        logger.debug("Adding Component: '" + component.getName() + "' to Window: '" + window.getName() + "'");
        window.add(component, layout);
    }

    /**
     * Set background to the JFrame/Window
     * @param color: Color
     */
    @Override
    public void setBackgroundColor(Color color){
        logger.debug("Setting the background color of Window to '" + color.toString() + "'");
        window.setBackground(color);
    }

    /**
     * Set background to the JFrame/Window
     * @param r: red
     * @param g: green
     * @param b: blue
     */
    @Override
    public void setBackgroundColor(int r, int g, int b){
        logger.debug("Setting the background color of Window to '" + r + ", " + g + ", " + b + "'");
        window.setBackground(new Color(r,g,b));
    }

    /**
     * Set foreground to the JFrame/Window
     * @param color: Color
     */
    @Override
    public void setForegroundColor(Color color){
        logger.debug("Setting the foreground color of Window to '" + color.toString() + "'");
        window.setForeground(color);
    }

    /**
     * Set foreground to the JFrame/Window
     * @param r: red
     * @param g: green
     * @param b: blue
     */
    @Override
    public void setForegroundColor(int r, int g, int b){
        logger.debug("Setting the foreground color of Window to '" + r + ", " + g + ", " + b + "'");
        window.setForeground(new Color(r,g,b));
    }

    /**
     * Set the Icon to the JFrame/Window
     * @param icon: ImageIcon
     */
    public void setIcon(ImageIcon icon){
        logger.debug("Setting WindowIcon to: '" + icon.toString() + "'");
        window.setIconImage(icon.getImage());
    }

    /**
     * Set the Icon to the JFrame/Window
     * @param icon: Image
     */
    public void setIcon(Image icon){
        logger.debug("Setting WindowIcon to: '" + icon.getSource() + "'");
        window.setIconImage(icon);
    }

    /**
     * Get the JFrame from Window
     * @return
     */
    public JFrame getWindow() {
        return window;
    }
}
