package net.killarexe.jlwin.comp;

import net.killarexe.jlwin.util.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: 13/05/21
 * @author Killar.exe
 * @version 0.1a
 */
public class Menu extends LComponent{

    private final JMenuBar bar;
    private final List<JMenu> menus = new ArrayList<>();
    private final List<JMenuItem> menuItems = new ArrayList<>();
    private final List<JCheckBoxMenuItem> checkboxMenuItems = new ArrayList<>();

    /**
     * Create JMenuBar
     * @param width: width of JMenuBar
     * @param height: height of JMenuBar
     */
    public Menu(int width, int height){
        logger.debug("Creating Menu Bar");
        bar = new JMenuBar();
        bar.setSize(width, height);
    }

    /**
     * Create JMenu
     * @param name: name of JMenu
     */
    public void createMenu(String name){
        logger.debug("Creating Menu: '" + name + "'");
        JMenu menu = new JMenu(name);
        menu.setName(name);
        bar.add(menu);
        menus.add(menu);
    }

    /**
     * Create a JMenuItem
     * @param name: name of JMenuItem
     * @param menu: JMenu
     */
    public void createMenuItem(String name, JMenu menu){
        logger.debug("Creating MenuItem: '" + name + "'");
        JMenuItem item = new JMenuItem(name);
        item.setName(name);
        menu.add(item);
        menuItems.add(item);
    }

    /**
     * Create a JMenuItem
     * @param name: name of JMenuItem
     * @param index: index in JMenu
     */
    public void createMenuItem(String name, int index){
        logger.debug("Creating MenuItem: '" + name + "'");
        JMenuItem item = new JMenuItem(name);
        item.setName(name);
        getMenu(index).add(item);
        menuItems.add(item);
    }

    /**
     * Create a JCheckBoxMenuItem
     * @param name: name of JCheckBoxMenuItem
     * @param index: index in JMenu
     * @param isChecked: if isChecked as Default
     */
    public void createCheckboxMenuItem(String name, int index, boolean isChecked){
        logger.debug("Creating CheckBoxItem: '" + name + "'");
        JCheckBoxMenuItem item = new JCheckBoxMenuItem(name);
        item.setName(name);
        getMenu(index).add(item);
        checkboxMenuItems.add(item);
        item.setState(isChecked);
    }

    /**
     * Set background color of JMenuBar
     * @param color: Color
     */
    @Override
    public void setBackgroundColor(Color color){
        logger.debug("Setting the background color of Menu Bar to '" + color.toString() + "'");
        bar.setBackground(color);
    }

    /**
     * Set background color of JMenuBar
     * @param r: red
     * @param g: green
     * @param b: blue
     */
    @Override
    public void setBackgroundColor(int r, int g, int b){
        logger.debug("Setting the background color of Menu Bar to '" + r + ", " + g + ", " + b + "'");
        bar.setBackground(new Color(r,g,b));
    }

    /**
     * Set text color of JMenuBar
     * @param color: Color
     */
    @Override
    public void setTextColor(Color color){
        logger.debug("Setting the text color of Menu Bar to '" + color.toString() + "'");
        bar.setForeground(color);
    }

    /**
     * Set text color of JMenuBar
     * @param r: red
     * @param g: green
     * @param b: blue
     */
    @Override
    public void setTextColor(int r, int g, int b){
            logger.debug("Setting the text color of Menu Bar to '" + r + ", " + g + ", " + b + "'");
        bar.setForeground(new Color(r,g,b));
    }

    /**
     * Set font of JMenuBar
     * @param font: Font
     */
    @Override
    public void setFont(Font font){
        logger.debug("Setting the font of Menu Bar to '" + font.toString() + "'");
        bar.setFont(font);
    }

    /**
     * Set font of JMenuBar
     * @param text: font name
     * @param type: type
     * @param size: size
     */
    @Override
    public void setFont(String text, int type, int size){
        logger.debug("Setting the font of Menu Bar to '" + text + ", " + type + ", " + size + "'");
        bar.setFont(new Font(text, type, size));
    }

    /**
     * Add an Listener
     * @param item: Triggered JMenuItem
     * @param listener: Action Listener
     */
    public void addListener(JMenuItem item, ActionListener listener){
        logger.debug("Adding Action Listener to MenuItem '" + item.getName() + "'");
        item.addActionListener(listener);
    }

    /**
     * Add an Listener
     * @param item: Triggered JCheckBoxMenuItem
     * @param listener: Action Listener
     */
    public void addListener(JCheckBoxMenuItem item, ActionListener listener){
        logger.debug("Adding Action Listener to CheckBoxItem '" + item.getName() + "'");
        item.addActionListener(listener);
    }

    /**
     * Get JMenu from Menu
     * @param index: index from an ArrayList
     * @return
     */
    public JMenu getMenu(int index){
        if(index <= menus.size()) {
           return menus.get(index);
        }
        return null;
    }

    /**
     * Get JMenuItem from Menu
     * @param index: index from an ArrayList
     * @return
     */
    public JMenuItem getMenuItem(int index){
        if(index <= menuItems.size()){
            return menuItems.get(index);
        }
        return null;
    }

    /**
     * Get JMenuBar from Menu
     * @return
     */
    public JMenuBar getBar() {
        return bar;
    }
}
