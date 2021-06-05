package net.killarexe.jlwin.comp;

import net.killarexe.jlwin.util.Logger;

import javax.swing.*;
import java.awt.*;

public class ProgressBar extends LComponent{

    private final JProgressBar bar;

    public ProgressBar(int x, int y, int width, int height, int max, String name){
        bar = new JProgressBar();
        bar.setBounds(x, y, width, height);
        bar.setString(name);
        bar.setMaximum(max);
    }

    public ProgressBar(int width, int height, int max, String name, Panel panel, String layout){
        bar = new JProgressBar();
        bar.setSize(width, height);
        panel.getPanel().add(bar, layout);
        bar.setString(name);
        bar.setMaximum(max);
    }

    @Override
    public void setAlignment(float x, float y){
        bar.setAlignmentX(x);
        bar.setAlignmentY(y);
    }

    public void setValue(int val){
        bar.setValue(val);
    }

    public JProgressBar getBar() {
        return bar;
    }
}
