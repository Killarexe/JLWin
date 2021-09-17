package net.killarexe.jlwin.file;

import net.killarexe.jlwin.javax.component.JXTextArea;
import net.killarexe.jlwin.javax.component.JXTextField;
import net.killarexe.jlwin.javax.component.JXTextPane;

import javax.swing.*;
import java.io.IOException;

/**
 * Date: 13/05/21
 * @author Killar.exe
 * @version 0.1a
 */
public class Run {

    Build build;

    /**
     * Make compile and run files
     * @param build: Build class
     */
    public Run(Build build){
        this.build = build;
    }

    /**
     * Check and Run selected file
     * @param assetFile: File
     * @param area: TextArea
     */
    public void checkAndRun(AssetFile assetFile, JXTextArea area){
        assetFile.save(area);
        if(assetFile.getFile().getName().endsWith(".java")) {
            runJava(assetFile);
        }else if(assetFile.getFile().getName().endsWith(".py")){
            runPyhton(assetFile);
        }else if(assetFile.getFile().getName().endsWith(".html")){
            runHTML(assetFile);
        }else if(assetFile.getFile().getName().endsWith(".c")){
            runC(assetFile);
        }else if(assetFile.getFile().getName().endsWith(".cs")){
            runAndBuildCSharp(assetFile);
        }else if(assetFile.getFile().getName().endsWith(".cpp")){
            runCpp(assetFile);
        }else if(assetFile.getFile().getName().endsWith(".js")){
            runJavaScript(assetFile);
        }else{
            JOptionPane.showMessageDialog(null, "No File Selected!");
        }
    }

    /**
     * Check, Compile and Run selected File
     * @param assetFile: file
     * @param area: TextArea
     */
    public void checkBuildAndRun(AssetFile assetFile, JXTextArea area){
        assetFile.save(area);
        if(assetFile.getFile().getName().endsWith(".java")) {
            runAndBuildJava(assetFile);
        }else if(assetFile.getFile().getName().endsWith(".py")){
            runPyhton(assetFile);
        }else if(assetFile.getFile().getName().endsWith(".html")){
            runHTML(assetFile);
        }else if(assetFile.getFile().getName().endsWith(".c")){
            runAndBuildC(assetFile);
        }else if(assetFile.getFile().getName().endsWith(".cs")){
            runAndBuildCSharp(assetFile);
        }else if(assetFile.getFile().getName().endsWith(".cpp")){
            runAndBuildCpp(assetFile);
        }else if(assetFile.getFile().getName().endsWith(".js")){
            runAndBuildJavaScript(assetFile);
        }else{
            JOptionPane.showMessageDialog(null, "No File Selected!");
        }
    }

    /**
     * Check, Compile and Run selected File
     * @param assetFile: file
     * @param field: TextField
     */
    public void checkBuildAndRun(AssetFile assetFile, JXTextField field){
        assetFile.save(field);
        if(assetFile.getFile().getName().endsWith(".java")) {
            runAndBuildJava(assetFile);
        }else if(assetFile.getFile().getName().endsWith(".py")){
            runPyhton(assetFile);
        }else if(assetFile.getFile().getName().endsWith(".html")){
            runHTML(assetFile);
        }else if(assetFile.getFile().getName().endsWith(".c")){
            runAndBuildC(assetFile);
        }else if(assetFile.getFile().getName().endsWith(".cs")){
            runAndBuildCSharp(assetFile);
        }else if(assetFile.getFile().getName().endsWith(".cpp")){
            runAndBuildCpp(assetFile);
        }else if(assetFile.getFile().getName().endsWith(".js")){
            runAndBuildJavaScript(assetFile);
        }else{
            JOptionPane.showMessageDialog(null, "No File Selected!");
        }
    }

    /**
     * Check, Compile and Run selected File
     * @param assetFile: file
     * @param pane: TextPane
     */
    public void checkBuildAndRun(AssetFile assetFile, JXTextPane pane){
        assetFile.save(pane);
        if(assetFile.getFile().getName().endsWith(".java")) {
            runAndBuildJava(assetFile);
        }else if(assetFile.getFile().getName().endsWith(".py")){
            runPyhton(assetFile);
        }else if(assetFile.getFile().getName().endsWith(".html")){
            runHTML(assetFile);
        }else if(assetFile.getFile().getName().endsWith(".c")){
            runAndBuildC(assetFile);
        }else if(assetFile.getFile().getName().endsWith(".cs")){
            runAndBuildCSharp(assetFile);
        }else if(assetFile.getFile().getName().endsWith(".cpp")){
            runAndBuildCpp(assetFile);
        }else if(assetFile.getFile().getName().endsWith(".js")){
            runAndBuildJavaScript(assetFile);
        }else{
            JOptionPane.showMessageDialog(null, "No File Selected!");
        }
    }

    /**
     * Run .class/Java file;
     * @param assetFile: file
     */
    public void runJava(AssetFile assetFile){
        if(assetFile.getFile().getName().endsWith(".java")) {
            try {
                Runtime rt = Runtime.getRuntime();
                rt.exec("cmd /c start cmd.exe /K \"cd " + assetFile.getFile().getParentFile() + " && java " + assetFile.getFile().getName().replaceFirst("[.][^.]+$", "") + "\"");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }else {
            JOptionPane.showMessageDialog(null, "Falied to run file! No File Is Selected! Or The JDK/JRE is an old version!");
        }
    }

    /**
     * Run and Build .java File
     * @param assetFile: file
     */
    public void runAndBuildJava(AssetFile assetFile){
        if(assetFile.getFile().getName().endsWith(".java")) {
            try {
                Runtime rt = Runtime.getRuntime();
                build.buildJava();
                Thread.sleep(10000);
                runJava(assetFile);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }else {
            JOptionPane.showMessageDialog(null, "Falied to run file! No File Is Selected! Or The JDK/JRE is an old version!");
        }
    }

    /**
     * Run .py file
     * @param assetFile: file
     */
    public void runPyhton(AssetFile assetFile){
        if(assetFile.getFile().getName().endsWith(".py")) {
            try {
                Runtime rt =  Runtime.getRuntime();
                rt.exec("cmd /c start " + assetFile.getFile().getPath() + "\"");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }else {
            JOptionPane.showMessageDialog(null, "Falied to run file! No Python File Is Selected! Or Python is an old version!");
        }
    }

    /**
     * Run HTML file
     * @param assetFile: file
     */
    public void runHTML(AssetFile assetFile){
        if(assetFile.getFile().getName().endsWith(".html")) {
            try {
                Runtime rt =  Runtime.getRuntime();
                rt.exec("cmd /c start " + assetFile.getFile().getPath() + "\"");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }else {
            JOptionPane.showMessageDialog(null, "Falied to run file! No HTML File Is Selected!");
        }
    }

    /**
     * Run .c file
     * @param assetFile: file
     */
    public void runC(AssetFile assetFile){
        if(assetFile.getFile().getName().endsWith(".c")){
            try{
                Runtime rt = Runtime.getRuntime();
                rt.exec("cmd /c start cmd.exe /K \"start " + assetFile.getFile().getPath() + ".exe" + "\"");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Run and Compile .c file
     * @param assetFile: file
     */
    public void runAndBuildC(AssetFile assetFile){
        if(assetFile.getFile().getName().endsWith(".c")){
            build.buildC();
            runC(assetFile);
        }
    }

    /**
     * Run and Compile .cs file
     * @param assetFile: Files class
     */
    public void runAndBuildCSharp(AssetFile assetFile){
        if(assetFile.getFile().getName().endsWith(".cs")){
            build.buildCsharp();
        }
    }

    public void runCpp(AssetFile assetFile){
        if(assetFile.getFile().getName().endsWith("cpp")){
            try{
                Runtime rt = Runtime.getRuntime();
                rt.exec("cmd /c start cmd.exe /K \"start " + assetFile.getFile().getPath() + ".exe" + "\"");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void runAndBuildCpp(AssetFile assetFile){
        if(assetFile.getFile().getName().endsWith("cpp")){
            build.buildCpp();
            runCpp(assetFile);
        }
    }

    public void runJavaScript(AssetFile assetFile){

    }

    public void runAndBuildJavaScript(AssetFile assetFile){

    }
}
