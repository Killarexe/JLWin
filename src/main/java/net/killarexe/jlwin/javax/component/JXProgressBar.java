package net.killarexe.jlwin.javax.component;

import javax.swing.*;

public class JXProgressBar extends JXComponent {

    private final JProgressBar bar;

    public JXProgressBar(int x, int y, int width, int height, int max, String name){
        bar = new JProgressBar();
        bar.setBounds(x, y, width, height);
        bar.setString(name);
        bar.setMaximum(max);
    }

    public JXProgressBar(int width, int height, int max, String name, JXPanel JXPanel, String layout){
        bar = new JProgressBar();
        bar.setSize(width, height);
        JXPanel.getPanel().add(bar, layout);
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
