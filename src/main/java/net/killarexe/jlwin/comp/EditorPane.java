package net.killarexe.jlwin.comp;

import javax.swing.*;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class EditorPane extends LComponent{

    private JEditorPane pane;

    public EditorPane(int width, int height, boolean isEditable){
        pane = new JEditorPane();
        pane.setSize(new Dimension(width, height));
        pane.setEditable(isEditable);
    }

    @Override
    public void setBackgroundColor(int r, int g, int b) {
        pane.setBackground(new Color(r, g, b));
    }

    @Override
    public void setBackgroundColor(Color color) {
        pane.setBackground(color);
    }

    @Override
    public void setForegroundColor(int r, int g, int b) {
        pane.setForeground(new Color(r, g, b));
    }

    @Override
    public void setForegroundColor(Color color) {
        pane.setForeground(color);
    }

    @Override
    public void setAlignment(float x, float y) {
        pane.setAlignmentX(x);
        pane.setAlignmentY(y);
    }

    public void setURL(String url){
        try {
            pane.setPage(url);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Invalid URL!");
        }
    }

    public void setURL(URL url){
        try {
            pane.setPage(url);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Invalid URL!");
        }
    }

    public void addHyperlinkListener(HyperlinkListener listener){
        pane.addHyperlinkListener(listener);
    }

    public JEditorPane getPane() {
        return pane;
    }
}
