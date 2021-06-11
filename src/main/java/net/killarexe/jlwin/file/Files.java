package net.killarexe.jlwin.file;

import net.killarexe.jlwin.comp.TextArea;
import net.killarexe.jlwin.comp.TextField;
import net.killarexe.jlwin.comp.TextPane;
import net.killarexe.jlwin.util.Logger;

import javax.swing.*;
import java.io.*;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Date 13/05/21
 * @author Killar.exe
 * @version 0.1a
 */
public class Files {

    private File file;
    private final Logger logger = new Logger(getClass());

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
    public void create(TextArea area){
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
    public void create(TextField field){
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
    public void create(TextPane pane){
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
    public void create(String path, TextArea area){
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
    public void create(String path, TextField field){
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
    public void create(String path, TextPane pane){
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
    public void save(TextArea area){
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
    public void save(TextPane pane){
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
    public void save(TextField field){
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
    public void open(TextArea area){
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
    public void open(TextPane pane){
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
    public void open(TextField field){
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
    public void open(String path, TextArea area){
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
    public void open(String path, TextField field){
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
    public void open(String path, TextPane pane){
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
    public void close(TextArea area){
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
    public void close(TextPane pane){
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
    public void close(TextField field){
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


    /**
     * Get File from File
     * @return
     */
    public java.io.File getFile() {
        return file;
    }
}
