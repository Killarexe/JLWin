package net.killarexe.jlwin.util;

import net.killarexe.jlwin.comp.TextArea;
import net.killarexe.jlwin.comp.TextField;
import net.killarexe.jlwin.comp.TextPane;

/**
 * Date 13/05/21
 * @author Killar.exe
 * @version 0.1a
 */
public class Logger {

    private String name;
    private static TextArea textArea;
    private static TextPane textPane;
    private static TextField textField;

    /**
     * Create logger
     * @param aClass: Class name
     */
    public Logger(Class aClass){
        name = aClass.getSimpleName();
    }

    /**
     * Send a Debug message
     * @param msg: message
     */
    public void debug(String msg){
        log("[DEBUG]", msg);
    }

    /**
     * Send a Info message
     * @param msg: message
     */
    public void info(String msg){
        log("[INFO]", msg);
    }

    /**
     * Send a Warn message
     * @param msg: message
     */
    public void warn(String msg){
        log("[WARN]", msg);
    }

    /**
     * Send an Error message
     * @param msg: message
     */
    public void error(String msg){
        log("[ERROR]", msg);
    }

    /**
     * Send a FATAL message
     * @param msg: message
     */
    public void fatal(String msg){
        errLog("[FATAL]", msg);
    }

    public void sendTextArea(TextArea area){
        textArea = area;
    }

    public void sendTextField(TextField field){
        textField = field;
    }

    public void sendTextPane(TextPane pane){
        textPane = pane;
    }

    private void log(String logMessageStr, String msg){
        String completeMsg = logMessageStr + "(" + name + "): " + msg;
        System.out.println(completeMsg);

        if(textArea != null){
            textArea.getTextArea().append(completeMsg);
        }else if(textField != null){
            String textFieldStr = textField.getText();
            textField.getTextField().setText(textFieldStr + "\n" + completeMsg);
        }else if(textPane != null){
            String textPaneStr = textPane.getText();
            textPane.getTextPane().setText(textPaneStr + "\n" + completeMsg);
        }
    }

    private void errLog(String logMessageStr, String msg){
        System.err.println(logMessageStr + "(" + name + "): " + msg);
    }
}
