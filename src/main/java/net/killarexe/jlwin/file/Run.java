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
     * @param files: File
     * @param area: TextArea
     */
    public void checkAndRun(Files files, JXTextArea area){
        files.save(area);
        if(files.getFile().getName().endsWith(".java")) {
            runJava(files);
        }else if(files.getFile().getName().endsWith(".py")){
            runPyhton(files);
        }else if(files.getFile().getName().endsWith(".html")){
            runHTML(files);
        }else if(files.getFile().getName().endsWith(".c")){
            runC(files);
        }else if(files.getFile().getName().endsWith(".cs")){
            runAndBuildCSharp(files);
        }else if(files.getFile().getName().endsWith(".cpp")){
            runCpp(files);
        }else if(files.getFile().getName().endsWith(".js")){
            runJavaScript(files);
        }else{
            JOptionPane.showMessageDialog(null, "No File Selected!");
        }
    }

    /**
     * Check, Compile and Run selected File
     * @param files: file
     * @param area: TextArea
     */
    public void checkBuildAndRun(Files files, JXTextArea area){
        files.save(area);
        if(files.getFile().getName().endsWith(".java")) {
            runAndBuildJava(files);
        }else if(files.getFile().getName().endsWith(".py")){
            runPyhton(files);
        }else if(files.getFile().getName().endsWith(".html")){
            runHTML(files);
        }else if(files.getFile().getName().endsWith(".c")){
            runAndBuildC(files);
        }else if(files.getFile().getName().endsWith(".cs")){
            runAndBuildCSharp(files);
        }else if(files.getFile().getName().endsWith(".cpp")){
            runAndBuildCpp(files);
        }else if(files.getFile().getName().endsWith(".js")){
            runAndBuildJavaScript(files);
        }else{
            JOptionPane.showMessageDialog(null, "No File Selected!");
        }
    }

    /**
     * Check, Compile and Run selected File
     * @param files: file
     * @param field: TextField
     */
    public void checkBuildAndRun(Files files, JXTextField field){
        files.save(field);
        if(files.getFile().getName().endsWith(".java")) {
            runAndBuildJava(files);
        }else if(files.getFile().getName().endsWith(".py")){
            runPyhton(files);
        }else if(files.getFile().getName().endsWith(".html")){
            runHTML(files);
        }else if(files.getFile().getName().endsWith(".c")){
            runAndBuildC(files);
        }else if(files.getFile().getName().endsWith(".cs")){
            runAndBuildCSharp(files);
        }else if(files.getFile().getName().endsWith(".cpp")){
            runAndBuildCpp(files);
        }else if(files.getFile().getName().endsWith(".js")){
            runAndBuildJavaScript(files);
        }else{
            JOptionPane.showMessageDialog(null, "No File Selected!");
        }
    }

    /**
     * Check, Compile and Run selected File
     * @param files: file
     * @param pane: TextPane
     */
    public void checkBuildAndRun(Files files, JXTextPane pane){
        files.save(pane);
        if(files.getFile().getName().endsWith(".java")) {
            runAndBuildJava(files);
        }else if(files.getFile().getName().endsWith(".py")){
            runPyhton(files);
        }else if(files.getFile().getName().endsWith(".html")){
            runHTML(files);
        }else if(files.getFile().getName().endsWith(".c")){
            runAndBuildC(files);
        }else if(files.getFile().getName().endsWith(".cs")){
            runAndBuildCSharp(files);
        }else if(files.getFile().getName().endsWith(".cpp")){
            runAndBuildCpp(files);
        }else if(files.getFile().getName().endsWith(".js")){
            runAndBuildJavaScript(files);
        }else{
            JOptionPane.showMessageDialog(null, "No File Selected!");
        }
    }

    /**
     * Run .class/Java file;
     * @param files: file
     */
    public void runJava(Files files){
        if(files.getFile().getName().endsWith(".java")) {
            try {
                Runtime rt = Runtime.getRuntime();
                rt.exec("cmd /c start cmd.exe /K \"cd " + files.getFile().getParentFile() + " && java " + files.getFile().getName().replaceFirst("[.][^.]+$", "") + "\"");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }else {
            JOptionPane.showMessageDialog(null, "Falied to run file! No File Is Selected! Or The JDK/JRE is an old version!");
        }
    }

    /**
     * Run and Build .java File
     * @param files: file
     */
    public void runAndBuildJava(Files files){
        if(files.getFile().getName().endsWith(".java")) {
            try {
                Runtime rt = Runtime.getRuntime();
                build.buildJava();
                Thread.sleep(10000);
                runJava(files);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }else {
            JOptionPane.showMessageDialog(null, "Falied to run file! No File Is Selected! Or The JDK/JRE is an old version!");
        }
    }

    /**
     * Run .py file
     * @param files: file
     */
    public void runPyhton(Files files){
        if(files.getFile().getName().endsWith(".py")) {
            try {
                Runtime rt =  Runtime.getRuntime();
                rt.exec("cmd /c start " + files.getFile().getPath() + "\"");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }else {
            JOptionPane.showMessageDialog(null, "Falied to run file! No Python File Is Selected! Or Python is an old version!");
        }
    }

    /**
     * Run HTML file
     * @param files: file
     */
    public void runHTML(Files files){
        if(files.getFile().getName().endsWith(".html")) {
            try {
                Runtime rt =  Runtime.getRuntime();
                rt.exec("cmd /c start " + files.getFile().getPath() + "\"");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }else {
            JOptionPane.showMessageDialog(null, "Falied to run file! No HTML File Is Selected!");
        }
    }

    /**
     * Run .c file
     * @param files: file
     */
    public void runC(Files files){
        if(files.getFile().getName().endsWith(".c")){
            try{
                Runtime rt = Runtime.getRuntime();
                rt.exec("cmd /c start cmd.exe /K \"start " + files.getFile().getPath() + ".exe" + "\"");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Run and Compile .c file
     * @param files: file
     */
    public void runAndBuildC(Files files){
        if(files.getFile().getName().endsWith(".c")){
            build.buildC();
            runC(files);
        }
    }

    /**
     * Run and Compile .cs file
     * @param files: Files class
     */
    public void runAndBuildCSharp(Files files){
        if(files.getFile().getName().endsWith(".cs")){
            build.buildCsharp();
        }
    }

    public void runCpp(Files files){
        if(files.getFile().getName().endsWith("cpp")){
            try{
                Runtime rt = Runtime.getRuntime();
                rt.exec("cmd /c start cmd.exe /K \"start " + files.getFile().getPath() + ".exe" + "\"");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void runAndBuildCpp(Files files){
        if(files.getFile().getName().endsWith("cpp")){
            build.buildCpp();
            runCpp(files);
        }
    }

    public void runJavaScript(Files files){

    }

    public void runAndBuildJavaScript(Files files){

    }
}
