package net.killarexe.jlwin.test;

import net.killarexe.jlwin.comp.Menu;
import net.killarexe.jlwin.comp.Panel;
import net.killarexe.jlwin.comp.ScrollPane;
import net.killarexe.jlwin.comp.TextArea;
import net.killarexe.jlwin.comp.Window;
import net.killarexe.jlwin.file.*;
import net.killarexe.jlwin.util.Logger;
import net.killarexe.jlwin.util.text.Fonts;
import net.killarexe.jlwin.window.ConsoleWindow;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Main{

    static Window window = new Window("Test", 1280, 720);
    static Panel panel = new Panel(1280, 720);
    static TextArea area = new TextArea(1280, 720, true);
    static ScrollPane pane = new ScrollPane(1280, 720, area, panel, BorderLayout.CENTER, true, false);
    static Menu menu = new Menu(1280, 25);
    static Files files = new Files();
    static Build build = new Build(files);
    static Run run = new Run(build);
    static ConsoleWindow consoleWindow = new ConsoleWindow("Test Console", 512, 512);
    static Logger logger = new Logger(Main.class);
    static ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == menu.getMenuItem(0)) {
                files.open(area);
            }else if(e.getSource() == menu.getMenuItem(1)){
                files.save(area);
            }else if(e.getSource() == menu.getMenuItem(2)){
                files.create(area);
            }else if(e.getSource() == menu.getMenuItem(3)){
                files.close(area);
            }else if(e.getSource() == menu.getMenuItem(4)){
                run.checkBuildAndRun(files, area);
            }
        }
    };

    public static void main(String[] args) throws IOException {
        //new CMD().execute(new String[]{"start cmd.exe", "echo Hello, World!", "pause"});
        logger.sendTextPane(consoleWindow.getTextPane());
        area.setFont(Fonts.ARIAL, Font.BOLD, 20);
        menu.createMenu("File");
        menu.createMenu("Edit");
        menu.createMenuItem("Open", 0);
        menu.createMenuItem("Save", 0);
        menu.createMenuItem("Save As", 0);
        menu.createMenuItem("Close", 0);
        menu.createMenuItem("Run", 0);
        menu.addListener(menu.getMenuItem(0), listener);
        menu.addListener(menu.getMenuItem(1), listener);
        menu.addListener(menu.getMenuItem(2), listener);
        menu.addListener(menu.getMenuItem(3), listener);
        menu.addListener(menu.getMenuItem(4), listener);
        window.addBar(menu);
        window.addComponent(panel.getPanel(), BorderLayout.CENTER);
        //((AbstractDocument) textPane.getTextPane().getDocument()).setDocumentFilter(new JavaDocumentFilter(textPane));
    }
}