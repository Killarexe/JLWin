package net.killarexe.jlwin.console;

import java.io.IOException;

public class Console {



    public static void execute(String command){
        Runtime rt = Runtime.getRuntime();
        try {
            Process pr = rt.exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
