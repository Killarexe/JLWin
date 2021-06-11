package net.killarexe.jlwin.window;

import net.killarexe.jlwin.comp.*;
import net.killarexe.jlwin.util.Logger;

import javax.swing.*;

public class ConsoleWindow {

    private final Window window;
    private final TextPane textPane;
    private final ScrollPane pane;
    private final Logger logger = new Logger(getClass());

    public ConsoleWindow(String name, int width, int height){
        logger.info("Creating ConsoleWindow");
        window = new Window(name, width,height);
        textPane = new TextPane(width, height, false);
        pane = new ScrollPane(width, height, textPane.getTextPane(), true, true);
        window.getWindow().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.addComponent(pane.getScrollPane());
    }

    public Window getWindow() {
        return window;
    }

    public JFrame getJFrame(){return window.getWindow();}

    public TextPane getTextPane() {
        return textPane;
    }

    public ScrollPane getPane() {
        return pane;
    }
}
