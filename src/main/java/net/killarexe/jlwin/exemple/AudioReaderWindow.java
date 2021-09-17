package net.killarexe.jlwin.exemple;

import net.killarexe.jlwin.audio.Audio;
import net.killarexe.jlwin.javax.component.JXFileChooser;
import net.killarexe.jlwin.javax.component.JXMenu;
import net.killarexe.jlwin.javax.component.JXWindow;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AudioReaderWindow implements ActionListener {

    private JXWindow window;
    private JXMenu menu;
    private Audio audio;

    public void start(){
        window = new JXWindow("Audio Reader", 1280, 720);
        menu = new JXMenu(1280, 20);
        menu.createMenu("File");
        menu.createMenuItem("Open", 0);
        menu.createMenuItem("Close", 0);
        menu.createMenuItem("Exit", 0);
        window.addBar(menu);
        for (int i = 0; i < 3; i++) {
            menu.addListener(menu.getMenuItem(i), this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == menu.getMenuItem(0)){
            audio = new Audio(JXFileChooser.choose(new FileNameExtensionFilter("audio files", "wav")));
            audio.startLoop();
        }else if (e.getSource() == menu.getMenuItem(1)){
            audio.stop();
        }else if(e.getSource() == menu.getMenuItem(2)){
            System.exit(0);
        }
    }
}
