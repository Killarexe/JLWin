package net.killarexe.jlwin.exemple;

import net.killarexe.jlwin.javax.component.*;
import net.killarexe.jlwin.javax.enums.ScrollBar;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;
import java.awt.*;
import java.awt.event.*;

public class WebWindow implements ActionListener, HyperlinkListener {

    private JXWindow JXWindow;
    private JXPanel JXPanel;
    private JXTextField field;
    private JXEditorPane pane;
    private JXScrollPane JXScrollPane;
    private JXButton JXButton;

    public WebWindow(String name, int width, int height, String defaultURL){
        JXWindow = new JXWindow(name, width, height);
        JXWindow.getWindow().setResizable(true);
        JXPanel = new JXPanel(width, height);
        pane = new JXEditorPane(width, height-60, false);
        field = new JXTextField(1000, 50, true);
        JXButton = new JXButton("Go!", 100, 20);
        JXButton.getButton().setBounds(0, 700, 100, 20);
        JXScrollPane = new JXScrollPane(width, height-100, pane.getPane(), ScrollBar.BOTH);
        JXButton.addListener(this);
        field.addListener(this);
        pane.addHyperlinkListener(this);
        JXPanel.getPanel().add(JXScrollPane.getScrollPane(), BorderLayout.CENTER);
        JXPanel.getPanel().add(JXButton.getButton(), BorderLayout.EAST);
        JXPanel.getPanel().add(field.getTextField(), BorderLayout.NORTH);
        JXWindow.addComponent(JXPanel.getPanel());
        pane.setURL(defaultURL);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String url = field.getText();
        try {
            pane.setURL(url);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    @Override
    public void hyperlinkUpdate(HyperlinkEvent e) {
        if (e.getEventType() != HyperlinkEvent.EventType.ACTIVATED) {
            return;
        }
        JEditorPane srcPane = (JEditorPane)e.getSource();
        if (e instanceof HTMLFrameHyperlinkEvent) {
            HTMLDocument doc = (HTMLDocument)pane.getPane().getDocument();
            doc.processHTMLFrameHyperlinkEvent((HTMLFrameHyperlinkEvent)e);
        } else {
            String url = e.getURL().toString();
            field.setText(url);
            try {
                pane.setURL(url);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }
}
