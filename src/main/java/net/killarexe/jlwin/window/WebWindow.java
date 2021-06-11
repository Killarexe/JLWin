package net.killarexe.jlwin.window;

import net.killarexe.jlwin.comp.*;
import net.killarexe.jlwin.comp.Button;
import net.killarexe.jlwin.comp.Panel;
import net.killarexe.jlwin.comp.ScrollPane;
import net.killarexe.jlwin.comp.TextField;
import net.killarexe.jlwin.comp.Window;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class WebWindow implements ActionListener, HyperlinkListener {

    private Window window;
    private Panel panel;
    private TextField field;
    private EditorPane pane;
    private ScrollPane scrollPane;
    private Button button;

    public WebWindow(String name, int width, int height, String defaultURL){
        window = new Window(name, width, height);
        window.getWindow().setResizable(true);
        panel = new Panel(width, height);
        pane = new EditorPane(width, height-60, false);
        field = new TextField(width, 50, true);
        button = new Button("Go!", 100, 20);
        scrollPane = new ScrollPane(width, height-100, pane.getPane(), true, true);
        button.addListener(this);
        field.addListener(this);
        pane.addHyperlinkListener(this);
        panel.getPanel().add(scrollPane.getScrollPane(), BorderLayout.CENTER);
        panel.getPanel().add(field.getTextField(), BorderLayout.NORTH);
        panel.getPanel().add(button.getButton(), BorderLayout.EAST);
        window.addComponent(panel.getPanel());
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
