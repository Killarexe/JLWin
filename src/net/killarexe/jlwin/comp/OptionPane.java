package net.killarexe.jlwin.comp;

import net.killarexe.jlwin.util.Logger;

import javax.swing.*;

/**
 * Date: 13/05/21
 * @author Killar.exe
 * @version 0.1a
 */
public class OptionPane {

    private JOptionPane pane;
    private Logger logger = new Logger(getClass());

    public OptionPane(){
        pane = new JOptionPane();
    }
}
