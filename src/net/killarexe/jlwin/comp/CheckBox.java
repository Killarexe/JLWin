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
public class CheckBox {

    private JCheckBox checkBox;
    private Logger logger = new Logger(getClass());

    public CheckBox(String name, int width, int height, int x, int y, boolean isChecked){
        logger.debug("Creating CheckBox: '" + name + "'");
        checkBox = new JCheckBox(name);
        checkBox.setBounds(x, y, width, height);
        checkBox.setSelected(isChecked);
    }

    public CheckBox(String name, boolean isChecked, Panel panel, BorderLayout layout){
        logger.debug("Creating CheckBox: '" + name + "'");
        checkBox = new JCheckBox(name);
        panel.getPanel().add(checkBox, layout);
        checkBox.setSelected(isChecked);
    }

    public void addListener(ActionListener listener){
        logger.debug("Adding Action Listener to Button '" + checkBox.getName() + "'");
        checkBox.addActionListener(listener);
    }
}
