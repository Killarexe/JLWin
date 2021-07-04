package net.killarexe.jlwin.javax.component;

import net.killarexe.jlwin.file.Image;

import javax.swing.*;
import java.awt.*;

public class JXTab extends JXComponent {

    private JTabbedPane pane;
    private JXButton JXButton;

    public JXTab(int width, int height, String defaultTabName, Image image, Component[] defaultComponents){
        pane = new JTabbedPane();
        pane.setSize(new Dimension(width, height));
        pane.addTab(defaultTabName, image.getIcon(), null);
        for (int i = 0; i < defaultComponents.length; i++) {
            pane.add(defaultComponents[i], 0);
        }
    }

    public JXTab(int width, int height, String defaultTabName, Image image, Component defaultComponents){
        pane = new JTabbedPane();
        pane.setSize(new Dimension(width, height));
        pane.addTab(defaultTabName, image.getIcon(), defaultComponents);
    }

    public JXTab(int width, int height, String defaultTabName, Component defaultComponents){
        pane = new JTabbedPane();
        pane.setSize(new Dimension(width, height));
        pane.addTab(defaultTabName, defaultComponents);
    }

    public JXTab(int width, int height, String defaultTabName, Component[] defaultComponents){
        pane = new JTabbedPane();
        pane.setSize(new Dimension(width, height));
        pane.addTab(defaultTabName, null);
        for (int i = 0; i < defaultComponents.length; i++) {
            pane.add(defaultComponents[i], 0);
        }
        JXButton = new JXButton("+", 50, 50);
    }

    public JXTab(int width, int height, String defaultTabName){
        new JXTab(width, height, defaultTabName, (Component) null);
    }

    public JTabbedPane getPane() {
        return pane;
    }
}
