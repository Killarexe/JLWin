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
     * @param files: Files class
     */
    public Build(Files files){
        this.files = files;
    }

    public void buildC(){
        try{
            Runtime rt = Runtime.getRuntime();
            rt.exec("cmd /c start cmd.exe /K \"gcc " + files.getFile().getPath() + " " + files.getFile().getName() + "\"");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Compile .cpp files
     */
    public void buildCpp(){
        try{
            Runtime rt = Runtime.getRuntime();
            rt.exec("cmd /c start cmd.exe /K \"g++ " + files.getFile().getPath() + " " + files.getFile().getName() + "\"");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void buildCsharp(){
        try{
            Runtime rt = Runtime.getRuntime();
            rt.exec("cmd /c start cmd.exe /K \"csc " + files.getFile().getPath() + "\"");
        }catch (IOException e){
            e.printStackTrace();
        }
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
