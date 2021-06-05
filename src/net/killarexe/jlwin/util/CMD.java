package net.killarexe.jlwin.util;

import java.io.IOException;

public class CMD {

    private Runtime runtime = Runtime.getRuntime();

    public void execute(String command) throws IOException {
        runtime.exec("cmd /c" + command);
    }

    public void execute(String[] command) throws IOException {
        for(int i = 0; i < command.length; i++){
            runtime.exec("cmd /c" + command[i]);
        }
    }

    public Runtime getRuntime() {
        return runtime;
    }
}
