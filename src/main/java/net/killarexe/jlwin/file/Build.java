package net.killarexe.jlwin.file;

import net.killarexe.jlwin.util.Logger;

import java.io.IOException;

/**
 * Date: 13/05/21
 * @author Killar.exe
 * @version 0.1a
 */
public class Build {

    Files files;
    Logger logger = new Logger(getClass());

    /**
     * Compile files
     * @param files
     */
    public Build(Files files){
        this.files = files;
    }

    public void buildC(){

    }

    /**
     * Compile .cpp files
     */
    public void buildCpp(){
        try{
            Runtime rt = Runtime.getRuntime();
            rt.exec("cmd /c start cmd.exe /K \"g++ " + files.getFile().getPath() + " " + files.getFile().getName() + "&& " + files.getFile().getName() + ".exe" + "\"");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void buildCsharp(){

    }

    /**
     * Compile .java files
     */
    public void buildJava() {
        try{
            Runtime rt = Runtime.getRuntime();
            rt.exec("cmd /c start cmd.exe /K \"javac " + files.getFile().getPath() + " && exit" +"\"");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
