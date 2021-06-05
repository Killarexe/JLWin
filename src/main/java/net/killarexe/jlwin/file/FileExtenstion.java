package net.killarexe.jlwin.file;

import net.killarexe.jlwin.util.Logger;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Date 13/05/21
 * @author Killar.exe
 * @version 0.1a
 */
public class FileExtenstion {

    private static final Logger logger = new Logger(FileExtenstion.class);
    private static final FileNameExtensionFilter batFilter = new FileNameExtensionFilter("Bat files", "bat");
    private static final FileNameExtensionFilter javaFilter = new FileNameExtensionFilter("Java files", "java");
    private static final FileNameExtensionFilter cFilter = new FileNameExtensionFilter("C files", "c");
    private static final FileNameExtensionFilter csFilter = new FileNameExtensionFilter("C# files", "cs");
    private static final FileNameExtensionFilter cppFilter = new FileNameExtensionFilter("C++ files", "cpp");
    private static final FileNameExtensionFilter fFilter = new FileNameExtensionFilter("F Files", "f");
    private static final FileNameExtensionFilter fsFilter = new FileNameExtensionFilter("F# Filter", "fs");
    private static final FileNameExtensionFilter phpFilter = new FileNameExtensionFilter("PHP Files", "php");
    private static final FileNameExtensionFilter jsonFilter = new FileNameExtensionFilter("Json Files", "json");
    private static final FileNameExtensionFilter htmlFilter = new FileNameExtensionFilter("Html files", "html");
    private static final FileNameExtensionFilter jsFilter = new FileNameExtensionFilter("JavaScript files", "js");
    private static final FileNameExtensionFilter pyFilter = new FileNameExtensionFilter("Python files", "py");
    private static final FileNameExtensionFilter xmlFilter = new FileNameExtensionFilter("XML files", "xml");
    private static final FileNameExtensionFilter vbsFilter = new FileNameExtensionFilter("VBS files", "vbs");
    private static final FileNameExtensionFilter cfgfFilter = new FileNameExtensionFilter("Config Files", "cfg", "ini", "inf");
    private static final FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("Text files", "txt", "md");

    /**
     * Set FileChooser Filter
     * @param fileChooser: JFileChooser
     */
    public static void addExtentionFilter(JFileChooser fileChooser) {
        logger.debug("Adding Extention Filter");
        fileChooser.setFileFilter(fFilter);
        fileChooser.setFileFilter(fsFilter);
        fileChooser.setFileFilter(phpFilter);
        fileChooser.setFileFilter(jsonFilter);
        fileChooser.setFileFilter(batFilter);
        fileChooser.setFileFilter(cFilter);
        fileChooser.setFileFilter(csFilter);
        fileChooser.setFileFilter(cppFilter);
        fileChooser.setFileFilter(javaFilter);
        fileChooser.setFileFilter(htmlFilter);
        fileChooser.setFileFilter(pyFilter);
        fileChooser.setFileFilter(jsFilter);
        fileChooser.setFileFilter(xmlFilter);
        fileChooser.setFileFilter(vbsFilter);
        fileChooser.setFileFilter(cfgfFilter);
        fileChooser.setFileFilter(txtFilter);
    }

    public static FileNameExtensionFilter getBatFilter() {
        return batFilter;
    }

    public static FileNameExtensionFilter getJavaFilter() {
        return javaFilter;
    }

    public static FileNameExtensionFilter getcFilter() {
        return cFilter;
    }

    public static FileNameExtensionFilter getCsFilter() {
        return csFilter;
    }

    public static FileNameExtensionFilter getCppFilter() {
        return cppFilter;
    }

    public static FileNameExtensionFilter getfFilter() {
        return fFilter;
    }

    public static FileNameExtensionFilter getFsFilter() {
        return fsFilter;
    }

    public static FileNameExtensionFilter getPhpFilter() {
        return phpFilter;
    }

    public static FileNameExtensionFilter getJsonFilter() {
        return jsonFilter;
    }

    public static FileNameExtensionFilter getHtmlFilter() {
        return htmlFilter;
    }

    public static FileNameExtensionFilter getJsFilter() {
        return jsFilter;
    }

    public static FileNameExtensionFilter getPyFilter() {
        return pyFilter;
    }

    public static FileNameExtensionFilter getXmlFilter() {
        return xmlFilter;
    }

    public static FileNameExtensionFilter getVbsFilter() {
        return vbsFilter;
    }

    public static FileNameExtensionFilter getCfgfFilter() {
        return cfgfFilter;
    }

    public static FileNameExtensionFilter getTxtFilter() {
        return txtFilter;
    }
}
