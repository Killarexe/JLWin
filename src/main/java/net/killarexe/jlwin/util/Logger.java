package net.killarexe.jlwin.util;

import net.killarexe.jlwin.javax.component.JXTextArea;
import net.killarexe.jlwin.javax.component.JXTextField;
import net.killarexe.jlwin.javax.component.JXTextPane;

/**
 * Date 13/05/21
 * @author Killar.exe
 * @version 0.1a
 */
public class Logger {

    private final String name;
    private static JXTextArea JXTextArea;
    private static JXTextPane JXTextPane;
    private static JXTextField JXTextField;

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
    public void debug(Object msg){
        log("[DEBUG]", msg);
    }

    /**
     * Send a Info message
     * @param msg: message
     */
    public void info(Object msg){
        log("[INFO]", msg);
    }

    /**
     * Send a Warn message
     * @param msg: message
     */
    public void warn(Object msg){
        log("[WARN]", msg);
    }

    /**
     * Send an Error message
     * @param msg: message
     */
    public void error(Object msg){
        log("[ERROR]", msg);
    }

    /**
     * Send a FATAL message
     * @param msg: message
     */
    public void fatal(Object msg){
        errLog("[FATAL]", msg);
    }

    public void sendTextArea(JXTextArea area){
        JXTextArea = area;
    }

    public void sendTextField(JXTextField field){
        JXTextField = field;
    }

    public void sendTextPane(JXTextPane pane){
        JXTextPane = pane;
    }

    private void log(String logMessageStr, Object msg){
        String completeMsg = logMessageStr + "(" + name + "): " + msg;
        System.out.println(completeMsg);

        if(JXTextArea != null){
            JXTextArea.getTextArea().append(completeMsg);
        }else if(JXTextField != null){
            String textFieldStr = JXTextField.getText();
            JXTextField.getTextField().setText(textFieldStr + "\n" + completeMsg);
        }else if(JXTextPane != null){
            String textPaneStr = JXTextPane.getText();
            JXTextPane.getTextPane().setText(textPaneStr + "\n" + completeMsg);
        }
    }

    private void errLog(String logMessageStr, Object msg){
        System.err.println(logMessageStr + "(" + name + "): " + msg);
    }
}
