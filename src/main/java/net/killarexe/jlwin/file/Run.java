package net.killarexe.jlwin.file;

import net.killarexe.jlwin.comp.TextArea;
import net.killarexe.jlwin.comp.TextField;
import net.killarexe.jlwin.comp.TextPane;

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
     * @param build
     */
    public Run(Build build){
        this.build = build;
    }

    /**
     * Check and Run selected file
     * @param files: File
     * @param area: TextArea
     */
    public void checkAndRun(Files files, TextArea area){
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
            runCSharp(files);
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
    public void checkBuildAndRun(Files files, TextArea area){
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
    public void checkBuildAndRun(Files files, TextField field){
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
    public void checkBuildAndRun(Files files, TextPane pane){
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
                rt.exec("cmd /c start cmd.exe /K \"cd " + files.getFile().getParentFile() + " && java " + files.getFile().getName().replaceFirst("[.][^.]+$", "") + "\"");
            } catch (IOException | InterruptedException e1) {
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
            JOptionPane.showMessageDialog(null, "Falied to run file! No Python Is Selected! Or Python is an old version!");
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
            JOptionPane.showMessageDialog(null, "Falied to run file! No Python Is Selected! Or Python is an old version!");
        }
    }

    /**
     * Run .c file
     * @param files: file
     */
    public void runC(Files files){
        if(files.getFile().getName().endsWith(".c")){
            try {
                Runtime rt =  Runtime.getRuntime();
                rt.exec("cmd /c start cmd.exe \"gcc -v && gcc " + files.getFile().getName());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Run and Compile .c file
     * @param files: file
     */
    public void runAndBuildC(Files files){
        if(files.getFile().getName().endsWith(".c")){
            try {
                Runtime rt =  Runtime.getRuntime();
                rt.exec("cmd /c start cmd.exe \"gcc -v && gcc " + files.getFile().getName());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Run .cs file
     * @param files: file
     */
    public void runCSharp(Files files){
        if(files.getFile().getName().endsWith(".cs")){
            try {
                Runtime rt =  Runtime.getRuntime();
                rt.exec("cmd /c start cmd.exe \"csc " + files.getFile().getName() + " && " + files.getFile().getName().replaceFirst("[.][^.]+$", ".exe") + "\"");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Run and Compile .cs file
     * @param files
     */
    public void runAndBuildCSharp(Files files){
        if(files.getFile().getName().endsWith(".cs")){
            try {
                Runtime rt =  Runtime.getRuntime();
                rt.exec("cmd /c start cmd.exe \"csc " + files.getFile().getName() + " && " + files.getFile().getName().replaceFirst("[.][^.]+$", ".exe") + "\"");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void runCpp(Files files){
        if(files.getFile().getName().endsWith("cpp")){

        }
    }

    public void runAndBuildCpp(Files files){
        if(files.getFile().getName().endsWith("cpp")){
            build.buildCpp();
        }
    }

    public void runJavaScript(Files files){

    }

    public void runAndBuildJavaScript(Files files){

    }
}
