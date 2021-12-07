package net.killarexe.jlwin.file;

import net.killarexe.jlwin.console.Console;
import net.killarexe.jlwin.javax.component.JXTextArea;
import net.killarexe.jlwin.javax.component.JXTextField;
import net.killarexe.jlwin.javax.component.JXTextPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Date 13/05/21
 * @author Killar.exe
 * @version 0.1a
 */
public class AssetFile {

    private File file;
    private final Logger logger = LogManager.getLogger();;

    public AssetFile(){}

    public AssetFile(File file){
        this.file = file;
    }

    public AssetFile(String path){
        this.file = new File(path);
    }

    public AssetFile(URL URL, String out){
        //Code: https://stackoverflow.com/questions/921262/how-to-download-and-save-a-file-from-internet-using-java
        URL website = URL;
        try {
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(out);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isSame(File file, File other){
        boolean same = false;
        try {
            same = Files.mismatch(file.getAbsoluteFile().toPath(), other.getAbsoluteFile().toPath()) == -1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return same;
    }

    public static void updateFile(File file, String tmpNameOut, String url){
        AssetFile downloadedFile = null;
        try {
             downloadedFile = new AssetFile(new URL(url), System.getProperty("java.io.tmpdir")+"\\"+tmpNameOut);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if(isSame(file, downloadedFile.getFile())){
            try {
                Files.copy(downloadedFile.getFile().toPath(), file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Create a File from a String
     * @param contents: contents
     */
    public void create(String contents){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("."));

        int response = fileChooser.showSaveDialog(null);

        if(response == JFileChooser.APPROVE_OPTION) {
            PrintWriter fileOut = null;

            file = new java.io.File(fileChooser.getSelectedFile().getAbsolutePath());
            try {
                fileOut = new PrintWriter(file);
                fileOut.println(contents);
                logger.info("Creating File: '" + file.getAbsolutePath() + "'");
            }
            catch (Exception e1) {
                e1.printStackTrace();
                logger.error("Failed to Create File!");
            }
            finally {
                fileOut.close();
            }
        }
    }

    /**
     * Create a file from a String
     * @param path: path
     * @param contents: contents
     */
    public void create(String path, String contents){
        PrintWriter fileOut = null;

        file = new java.io.File(path);
        try {
            fileOut = new PrintWriter(file);
            fileOut.println(contents);
            logger.info("Creating File: '" + file.getAbsolutePath() + "'");
        }
        catch (Exception e1) {
            e1.printStackTrace();
            logger.error("Failed to Create File!");
        }
        finally {
            fileOut.close();
        }
    }

    /**
     * Create a file from a JTextArea
     * @param area: TextArea
     */
    public void create(JXTextArea area){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("."));

        int response = fileChooser.showSaveDialog(null);

        if(response == JFileChooser.APPROVE_OPTION) {
            PrintWriter fileOut = null;

            file = new java.io.File(fileChooser.getSelectedFile().getAbsolutePath());
            try {
                fileOut = new PrintWriter(file);
                fileOut.println(area.getText());
                logger.info("Creating File: '" + file.getAbsolutePath() + "'");
            }
            catch (Exception e1) {
                e1.printStackTrace();
                logger.error("Failed to Create File!");
            }
            finally {
                fileOut.close();
            }
        }
    }

    /**
     * Create a file from a JTextField
     * @param field: TextField
     */
    public void create(JXTextField field){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("."));

        int response = fileChooser.showSaveDialog(null);

        if(response == JFileChooser.APPROVE_OPTION) {
            PrintWriter fileOut = null;

            file = new java.io.File(fileChooser.getSelectedFile().getAbsolutePath());
            try {
                fileOut = new PrintWriter(file);
                fileOut.println(field.getText());
                logger.info("Creating File: '" + file.getAbsolutePath() + "'");
            }
            catch (Exception e1) {
                e1.printStackTrace();
                logger.error("Failed to Create File!");
            }
            finally {
                fileOut.close();
            }
        }
    }

    /**
     * Create a file from a JTextPane
     * @param pane: TextPane
     */
    public void create(JXTextPane pane){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("."));

        int response = fileChooser.showSaveDialog(null);

        if(response == JFileChooser.APPROVE_OPTION) {
            PrintWriter fileOut = null;

            file = new java.io.File(fileChooser.getSelectedFile().getAbsolutePath());
            try {
                fileOut = new PrintWriter(file);
                fileOut.println(pane.getText());
                logger.info("Creating File: '" + file.getAbsolutePath() + "'");
            }
            catch (Exception e1) {
                e1.printStackTrace();
                logger.error("Failed to Create File!");
            }
            finally {
                fileOut.close();
            }
        }
    }

    /**
     * Create a file from a JTextArea
     * @param path: path
     * @param area: area
     */
    public void create(String path, JXTextArea area){
        PrintWriter fileOut = null;

        file = new java.io.File(path);
        try {
            fileOut = new PrintWriter(file);
            fileOut.println(area.getText());
            logger.info("Creating File: '" + file.getAbsolutePath() + "'");
        }
        catch (Exception e1) {
            e1.printStackTrace();
            logger.error("Failed to Create File!");
        }
        finally {
            fileOut.close();
        }
    }

    /**
     * Create a file from a JTextField
     * @param path: path
     * @param field: field
     */
    public void create(String path, JXTextField field){
        PrintWriter fileOut = null;

        file = new java.io.File(path);
        try {
            fileOut = new PrintWriter(file);
            fileOut.println(field.getText());
            logger.info("Creating File: '" + file.getAbsolutePath() + "'");
        }
        catch (Exception e1) {
            e1.printStackTrace();
            logger.error("Failed to Create File!");
        }
        finally {
            fileOut.close();
        }
    }

    /**
     * Create a file from a JTextPane
     * @param path: path
     * @param pane: pane
     */
    public void create(String path, JXTextPane pane){
        PrintWriter fileOut = null;

        file = new java.io.File(path);
        try {
            fileOut = new PrintWriter(file);
            fileOut.println(pane.getText());
            logger.info("Creating File: '" + file.getAbsolutePath() + "'");
        }
        catch (Exception e1) {
            e1.printStackTrace();
            logger.error("Failed to Create File!");
        }
        finally {
            fileOut.close();
        }
    }

    /**
     * Delete a file
     */
    public void delete(){
        if(file == null){
            return;
        }else{
            file.delete();
            file = null;
        }
    }

    /**
     * Save a file from a String
     * @param contents: contents
     * @param path: path
     */
    public void save(String contents, String path){
        try {

            if(file == null) {
                file = new java.io.File(path);
                return;
            }
            Formatter form = new Formatter(file);
            form.format("%s", contents);
            form.close();
            logger.info("Saving File: '" + file.getAbsolutePath() + "'");
        } catch (Exception e2) {
            e2.printStackTrace();
            logger.error("Failed to Save File: '" + file.getAbsolutePath() + "'");
        }
    }

    /**
     * Save a file from a String
     * @param contents: contents
     */
    public void save(String contents){
        try {

            if(file == null) {
                JOptionPane.showMessageDialog(null, "Falied to save file! No File Is Selected!");
                return;
            }
            Formatter form = new Formatter(file);
            form.format("%s", contents);
            form.close();
            logger.info("Saving File: '" + file.getAbsolutePath() + "'");
        } catch (Exception e2) {
            e2.printStackTrace();
            logger.error("Failed to Save File: '" + file.getAbsolutePath() + "'");
        }
    }

    /**
     * Save a file from a JTextArea
     * @param area: TextArea
     */
    public void save(JXTextArea area){
        try {

            if(file == null) {
                JOptionPane.showMessageDialog(null, "Falied to save file! No File Is Selected!");
                return;
            }
            String contents = area.getText();
            Formatter form = new Formatter(file);
            form.format("%s", contents);
            form.close();
            logger.info("Saving File: '" + file.getAbsolutePath() + "'");
        } catch (Exception e2) {
            e2.printStackTrace();
            logger.error("Failed to Save File: '" + file.getAbsolutePath() + "'");
        }
    }

    /**
     * Save a file from a JTextPane
     * @param pane: TextPane
     */
    public void save(JXTextPane pane){
        try {

            if(file == null) {
                JOptionPane.showMessageDialog(null, "Falied to save file! No File Is Selected!");
                return;
            }
            String contents = pane.getText();
            Formatter form = new Formatter(file);
            form.format("%s", contents);
            form.close();
            logger.info("Saving File: '" + file.getAbsolutePath() + "'");
        } catch (Exception e2) {
            e2.printStackTrace();
            logger.error("Failed to Save File: '" + file.getAbsolutePath() + "'");
        }
    }

    /**
     * Save a file from a JTextField
     * @param field: TextField
     */
    public void save(JXTextField field){
        try {

            if(file == null) {
                JOptionPane.showMessageDialog(null, "Falied to save file! No File Is Selected!");
                return;
            }
            String contents = field.getText();
            Formatter form = new Formatter(file);
            form.format("%s", contents);
            form.close();
            logger.info("Saving File: '" + file.getAbsolutePath() + "'");
        } catch (Exception e2) {
            e2.printStackTrace();
            logger.error("Failed to Save File: '" + file.getAbsolutePath() + "'");
        }
    }

    /**
     * Open a file to JTextArea
     * @param area: TextArea
     */
    public void open(JXTextArea area){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("."));
        int response = fileChooser.showOpenDialog(null);
        if(response == JFileChooser.APPROVE_OPTION) {
            if(!(file == null)) {
                return;
            }else {
                file = new java.io.File(fileChooser.getSelectedFile().getAbsolutePath());
                Scanner fileIn = null;
                try {
                    fileIn = new Scanner(file);
                    if(file.isFile()) {
                        while(fileIn.hasNextLine()) {
                            String line = fileIn.nextLine()+"\n";
                            area.getTextArea().append(line);
                        }
                        logger.info("Open File: '" + file.getAbsolutePath() + "'");
                    }
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                    logger.error("Failed to Open File: '" + file.getAbsolutePath() + "'");
                }
                finally {
                    fileIn.close();
                }
            }
        }
    }

    /**
     * Open a file to JTextPane
     * @param pane: TextPane
     */
    public void open(JXTextPane pane){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("."));
        int response = fileChooser.showOpenDialog(null);
        if(response == JFileChooser.APPROVE_OPTION) {
            if(!(file == null)) {
                return;
            }else {
                file = new java.io.File(fileChooser.getSelectedFile().getAbsolutePath());
                Scanner fileIn = null;
                try {
                    fileIn = new Scanner(file);
                    if(file.isFile()) {
                        while(fileIn.hasNextLine()) {
                            String line = fileIn.nextLine()+"\n";
                            pane.getTextPane().setText(line);
                        }
                        logger.info("Open File: '" + file.getAbsolutePath() + "'");
                    }
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                    logger.error("Failed to Open File: '" + file.getAbsolutePath() + "'");
                }
                finally {
                    fileIn.close();
                }
            }
        }
    }

    /**
     * Open a file to JTextField
     * @param field: TextField
     */
    public void open(JXTextField field){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("."));
        int response = fileChooser.showOpenDialog(null);
        if(response == JFileChooser.APPROVE_OPTION) {
            if(!(file == null)) {
                return;
            }else {
                file = new java.io.File(fileChooser.getSelectedFile().getAbsolutePath());
                Scanner fileIn = null;
                try {
                    fileIn = new Scanner(file);
                    if(file.isFile()) {
                        while(fileIn.hasNextLine()) {
                            String line = fileIn.nextLine()+"\n";
                            field.getTextField().setText(line);
                        }
                        logger.info("Open File: '" + file.getAbsolutePath() + "'");
                    }
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                    logger.error("Failed to Open File: '" + file.getAbsolutePath() + "'");
                }
                finally {
                    fileIn.close();
                }
            }
        }
    }


    /**
     * Open a file to a JTextArea from a specific path
     * @param path: path
     * @param area: TextArea
     */
    public void open(String path, JXTextArea area){
            if(!(file == null)) {
                return;
            }else {
                file = new java.io.File(path);
                Scanner fileIn = null;
                try {
                    fileIn = new Scanner(file);
                    if(file.isFile()) {
                        while(fileIn.hasNextLine()) {
                            String line = fileIn.nextLine()+"\n";
                            area.getTextArea().append(line);
                        }
                        logger.info("Open File: '" + file.getAbsolutePath() + "'");
                    }
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                    logger.error("Failed to Open File: '" + file.getAbsolutePath() + "'");
                }
                finally {
                    fileIn.close();
                }
            }
    }

    /**
     * Open a file to a JTextField from a specific path
     * @param path: path
     * @param field: TextField
     */
    public void open(String path, JXTextField field){
        if(!(file == null)) {
            return;
        }else {
            file = new java.io.File(path);
            Scanner fileIn = null;
            try {
                fileIn = new Scanner(file);
                if(file.isFile()) {
                    while(fileIn.hasNextLine()) {
                        String line = fileIn.nextLine()+"\n";
                        field.getTextField().setText(line);
                    }
                    logger.info("Open File: '" + file.getAbsolutePath() + "'");
                }
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
                logger.error("Failed to Open File: '" + file.getAbsolutePath() + "'");
            }
            finally {
                fileIn.close();
            }
        }
    }

    /**
     * Open a file to a JTextPane from a specific path
     * @param path: path
     * @param pane: TextPane
     */
    public void open(String path, JXTextPane pane){
        if(!(file == null)) {
            return;
        }else {
            file = new java.io.File(path);
            Scanner fileIn = null;
            try {
                fileIn = new Scanner(file);
                if(file.isFile()) {
                    while(fileIn.hasNextLine()) {
                        String line = fileIn.nextLine()+"\n";
                        pane.getTextPane().setText(line);
                    }
                    logger.info("Open File: '" + file.getAbsolutePath() + "'");
                }
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
                logger.error("Failed to Open File: '" + file.getAbsolutePath() + "'");
            }
            finally {
                fileIn.close();
            }
        }
    }

    /**
     * Close a file from a JTextArea
     * @param area: TextArea
     */
    public void close(JXTextArea area){
        if(file == null) {
            JOptionPane.showMessageDialog(null, "Falied to close file! No File Is Selected!");
            logger.error("Falied to close file! No File Is Selected!");
            return;
        }
        file = null;
        area.getTextArea().setText("");
        logger.info("File closed!");
    }

    /**
     * Close a file from a JTextPane
     * @param pane: TextPane
     */
    public void close(JXTextPane pane){
        if(file == null) {
            JOptionPane.showMessageDialog(null, "Falied to close file! No File Is Selected!");
            logger.error("Falied to close file! No File Is Selected!");
            return;
        }
        file = null;
        pane.getTextPane().setText("");
        logger.info("File closed!");
    }

    /**
     * Close a file from a JTextField
     * @param field: TextField
     */
    public void close(JXTextField field){
        if(file == null) {
            JOptionPane.showMessageDialog(null, "Falied to close file! No File Is Selected!");
            logger.error("Falied to close file! No File Is Selected!");
            return;
        }
        file = null;
        field.getTextField().setText("");
        logger.info("File closed!");
    }

    /**
     * Rename a file
     * @param newName: new file name
     */
    public void rename(String newName){
        if(file == null){
            logger.error("Falied to close file! No File Is Selected!");
            return;
        }else{
            file.renameTo(new java.io.File(newName));
            logger.info("File renamed to: '" + newName + "'");
        }
    }

    public String fileToString(){
        try {
             return Files.readString(Paths.get(file.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void run(){
        if(file.canExecute()) {
            Console.execute("start " + fileToString());
        }
    }


    /**
     * Get File from File
     * @return : return a File
     */
    public java.io.File getFile() {
        return file;
    }
}
