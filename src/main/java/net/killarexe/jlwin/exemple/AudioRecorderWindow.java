package net.killarexe.jlwin.exemple;

import net.killarexe.jlwin.audio.AudioRecorder;
import net.killarexe.jlwin.javax.component.JXButton;
import net.killarexe.jlwin.javax.component.JXFileChooser;
import net.killarexe.jlwin.javax.component.JXMenu;
import net.killarexe.jlwin.javax.component.JXWindow;
import net.killarexe.jlwin.util.Logger;

import javax.sound.sampled.AudioFileFormat;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AudioRecorderWindow implements ActionListener {

    private AudioRecorder recorder;
    private JXWindow window;
    private JXMenu menu;
    private JXButton button;
    private long recordTime;
    private AudioFileFormat.Type type;
    private String path;
    private Logger logger = new Logger(getClass());

    public AudioRecorderWindow(String title, int width, int height){
        setup(title, width, height);
    }

    private void setup(String title, int width, int height){
        logger.info("Setup AudioRecorderWindow");
        window = new JXWindow(title, width, height);
        recorder = new AudioRecorder();
        menu = new JXMenu(width, 20);
        button = new JXButton("Record!", 100, 100, width/2, height/2);
        button.addListener(this);
        menu.createMenu("File");
        menu.createMenuItem("Record", 0);
        menu.createMenuItem("Exit", 0);
        for (int i = 0; i < 2; i++) {
            menu.addListener(menu.getMenuItem(i), this);
        }
        window.addBar(menu);
        window.addComponent(button.getButton());
        logger.info("Setup Complete!");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menu.getMenuItem(0)) {
            record();
        }
        else if(e.getSource() == menu.getMenuItem(1)){
            System.exit(0);
        }
        else if(e.getSource() == button.getButton() && button.getButton().getText() == "Record!"){
            record();
        }
    }

    private void record(){
        recordTime = (Long.parseLong(JOptionPane.showInputDialog("Enter Time (in sec): "))*1000)+1;
        JXFileChooser chooser = new JXFileChooser();
        path = chooser.choose().getAbsolutePath() + ".wav";
        type = AudioFileFormat.Type.WAVE;
        recorder.start(recordTime, path, type);
        JOptionPane.showMessageDialog(null, "Record ended!");
    }

    private void stop(){
        recorder.stop();
    }
}
