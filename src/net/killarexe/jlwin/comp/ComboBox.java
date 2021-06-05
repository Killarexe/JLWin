package net.killarexe.jlwin.comp;

import javax.swing.*;

public class ComboBox {

    private JComboBox box;

    public ComboBox(int x, int y, int width, int height, boolean isEditable){
        box = new JComboBox();
        box.setBounds(x, y, width, height);
        box.setEditable(isEditable);
    }
}
