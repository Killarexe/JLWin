package net.killarexe.jlwin.javax.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JXComboBox extends JXComponent {

    private final JComboBox box;

    public JXComboBox(int x, int y, int width, int height, boolean isEditable){
        logger.debug("Creating ComboBox");
        box = new JComboBox();
        box.setBounds(x, y, width, height);
        box.setEditable(isEditable);
    }

    public JXComboBox(int width, int height, boolean isEditable){
        logger.debug("Creating ComboBox");
        box = new JComboBox();
        box.setSize(width, height);
        box.setEditable(isEditable);
    }

    public void addItem(Object o){
        logger.debug("Adding item to ComboBox");
        box.addItem(o);
    }

    public void addItems(Object[] o){
        logger.debug("Adding "+ o.length +" items to ComboBox");
        box.addItem(o);

    }

    @Override
    public void addListener(ActionListener listener){
        logger.debug("Adding ActionListener to ComboBox");
        box.addActionListener(listener);
    }

    @Override
    public void setBackgroundColor(Color color) {

    }

    @Override
    public void setBackgroundColor(int r, int g, int b) {

    }

    @Override
    public void setTextColor(Color color) {

    }

    @Override
    public void setForegroundColor(int r, int g, int b) {

    }

    public void setSelectedItem(Object o){
        box.setSelectedItem(o);
    }

    public Object getSelectedItem(){
        if(box.getSelectedItem() != null) {
            return box.getSelectedItem();
        }
        return null;
    }

    public boolean getSelectedItem(Object o){
        return box.getSelectedItem() == o;
    }

    public JComboBox getBox() {
        return box;
    }
}
