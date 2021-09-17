package net.killarexe.jlwin.exemple;

import net.killarexe.jlwin.javax.component.JXTextPane;
import net.killarexe.jlwin.javax.component.JXWindow;
import net.killarexe.jlwin.javax.component.JXScrollPane;
import net.killarexe.jlwin.javax.enums.ScrollBar;
import net.killarexe.jlwin.util.Logger;

import javax.swing.*;

public class ConsoleWindow {

    private final JXWindow JXWindow;
    private final JXTextPane JXTextPane;
    private final JXScrollPane pane;
    private final Logger logger = new Logger(getClass());

    public ConsoleWindow(String name, int width, int height){
        logger.info("Creating ConsoleWindow");
        JXWindow = new JXWindow(name, width,height);
        JXTextPane = new JXTextPane(width, height, false);
        pane = new JXScrollPane(width, height, JXTextPane.getTextPane(), ScrollBar.BOTH);
        JXWindow.getWindow().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JXWindow.addComponent(pane.getScrollPane());
    }

    public JXWindow getWindow() {
        return JXWindow;
    }

    public JFrame getJFrame(){return JXWindow.getWindow();}

    public JXTextPane getTextPane() {
        return JXTextPane;
    }

    public JXScrollPane getPane() {
        return pane;
    }
}
