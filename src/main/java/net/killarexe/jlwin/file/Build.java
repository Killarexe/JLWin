package net.killarexe.jlwin.file;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.io.IOException;

/**
 * Date: 13/05/21
 * @author Killar.exe
 * @version 0.1a
 */
public class Build {

    private AssetFile assetFile;
    private Logger logger = LogManager.getLogger();;

    /**
     * Compile files
     * @param assetFile: Files class
     */
    public Build(AssetFile assetFile){
        this.assetFile = assetFile;
    }

    public void checkAndBuild(){
        if(assetFile.getFile().getName().endsWith(".java")) {
            buildJava();
        }else if(assetFile.getFile().getName().endsWith(".c")){
            buildC();
        }else if(assetFile.getFile().getName().endsWith(".cs")){
            buildCsharp();
        }else if(assetFile.getFile().getName().endsWith(".cpp")){
            buildCpp();
        }else{
            JOptionPane.showMessageDialog(null, "No File Selected! Or Can't Build The File!");
        }
    }

    public void buildC(){
        try{
            Runtime rt = Runtime.getRuntime();
            rt.exec("cmd /c start cmd.exe /K \"gcc " + assetFile.getFile().getPath() + " " + assetFile.getFile().getName() + "\"");
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
            rt.exec("cmd /c start cmd.exe /K \"g++ " + assetFile.getFile().getPath() + " " + assetFile.getFile().getName() + "\"");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void buildCsharp(){
        try{
            Runtime rt = Runtime.getRuntime();
            rt.exec("cmd /c start cmd.exe /K \"csc " + assetFile.getFile().getPath() + "\"");
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
            rt.exec("cmd /c start cmd.exe /K \"javac " + assetFile.getFile().getPath() + " && exit" +"\"");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
