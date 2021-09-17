package net.killarexe.jlwin.javax.component;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.PrintWriter;

public class JXFileChooser{

    public File choose(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("."));

        int response = fileChooser.showSaveDialog(null);

        if(response == JFileChooser.APPROVE_OPTION) {
            PrintWriter fileOut = null;

            return new java.io.File(fileChooser.getSelectedFile().getAbsolutePath());
        }

        return null;
    }

    public static File choose(FileNameExtensionFilter filter){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("."));
        fileChooser.setFileFilter(filter);

        int response = fileChooser.showSaveDialog(null);

        if(response == JFileChooser.APPROVE_OPTION) {
            return new java.io.File(fileChooser.getSelectedFile().getAbsolutePath());
        }

        return null;
    }
}
