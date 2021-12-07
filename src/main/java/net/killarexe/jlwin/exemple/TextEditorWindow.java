package net.killarexe.jlwin.exemple;

import net.killarexe.jlwin.file.AssetFile;
import net.killarexe.jlwin.file.Build;
import net.killarexe.jlwin.file.Run;
import net.killarexe.jlwin.javax.component.*;
import net.killarexe.jlwin.javax.enums.ScrollBar;
import net.killarexe.jlwin.util.text.Fonts;
import net.killarexe.jlwin.util.text.JavaDocumentFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEditorWindow implements ActionListener {

    private JXWindow window;
    private JXMenu menu;
    private JXTextPane textPane;
    private JXScrollPane scrollPane;
    private AssetFile file;
    private Build build;
    private Run run;

    public TextEditorWindow(int width, int height){
        window = new JXWindow("Java Text Editor", width, height);
        menu = new JXMenu(width, 20);
        textPane = new JXTextPane(1280, 700, true);
        scrollPane = new JXScrollPane(1280, 700, textPane.getTextPane(), ScrollBar.BOTH);
        file = new AssetFile();
        build = new Build(file);
        run = new Run(build);
        menu.createMenu("File");;
        menu.createMenuItem("Open", 0);
        menu.createMenuItem("Save", 0);
        menu.createMenuItem("Save As", 0);
        menu.createMenuItem("Close", 0);
        menu.createMenu("Build");
        menu.createMenuItem("Build File", 1);
        menu.createMenuItem("Build And Run", 1);
        menu.createMenu("Run");
        menu.createMenuItem("Run File", 2);
        window.addBar(menu);
        window.addComponent(scrollPane.getScrollPane());
        menu.addAllListener(this);
        new JavaDocumentFilter(textPane);
        textPane.setFont(new Font(Fonts.ARIAL, 0, 20));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == menu.getMenuItem(0)){
            file.open(textPane);
        }
        else if(e.getSource() == menu.getMenuItem(1)){
            file.save(textPane);
        }
        else if(e.getSource() == menu.getMenuItem(2)){
            file.create(textPane);
        }
        else if(e.getSource() == menu.getMenuItem(3)){
            file.close(textPane);
        }
        else if(e.getSource() == menu.getMenuItem(4)){
            build.checkAndBuild();
        }
        else if(e.getSource() == menu.getMenuItem(5)){
            run.checkBuildAndRun(file, textPane);
        }
        else if(e.getSource() == menu.getMenuItem(6)){
            run.checkAndRun(file);
        }
    }
}
