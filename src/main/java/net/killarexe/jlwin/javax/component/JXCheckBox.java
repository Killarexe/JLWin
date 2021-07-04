package net.killarexe.jlwin.javax.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Date: 13/05/21
 * @author Killar.exe
 * @version 0.1a
 */
public class JXCheckBox extends JXComponent {

    private final JCheckBox checkBox;

    public JXCheckBox(String name, int width, int height, int x, int y, boolean isChecked){
        logger.debug("Creating CheckBox: '" + name + "'");
        checkBox = new JCheckBox(name);
        checkBox.setBounds(x, y, width, height);
        checkBox.setSelected(isChecked);
    }

    public JXCheckBox(String name, boolean isChecked, JXPanel JXPanel, BorderLayout layout){
        logger.debug("Creating CheckBox: '" + name + "'");
        checkBox = new JCheckBox(name);
        JXPanel.getPanel().add(checkBox, layout);
        checkBox.setSelected(isChecked);
    }

    @Override
    public void addListener(ActionListener listener){
        logger.debug("Adding Action Listener to Button '" + checkBox.getName() + "'");
        checkBox.addActionListener(listener);
    }
}
