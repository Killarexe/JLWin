package net.killarexe.jlwin.exemple;

import net.killarexe.jlwin.file.audio.Audio;
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
        for (int i = 0; i < 3; i++) {
            menu.addListener(menu.getMenuItem(i), this);
        }
        window.addBar(menu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == menu.getMenuItem(0)){
            if(audio == null) {
                audio = new Audio(JXFileChooser.choose(new FileNameExtensionFilter("audio files", "wav")));
                audio.startLoop();
            }else{
                audio.startLoop();
                audio = null;
                audio = new Audio(JXFileChooser.choose(new FileNameExtensionFilter("audio files", "wav")));
                audio.startLoop();
            }
        }else if (e.getSource() == menu.getMenuItem(1)){
            audio.stop();
            audio = null;
        }else if(e.getSource() == menu.getMenuItem(2)){
            System.exit(0);
        }
    }
}
