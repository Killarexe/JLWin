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
    private static final FileNameExtensionFilter cobolFilter = new FileNameExtensionFilter("Cobal files", "cbl", "cob", "cpy");
    private static final FileNameExtensionFilter cssFilter = new FileNameExtensionFilter("Cascading Style Sheets files(CSS)", "css");
    private static final FileNameExtensionFilter marvenFilter = new FileNameExtensionFilter("Maven files", "porm");
    private static final FileNameExtensionFilter perlFilter = new FileNameExtensionFilter("Perl files", "pl", "pm");
    private static final FileNameExtensionFilter typescriptFilter = new FileNameExtensionFilter("TypeScript files", "ts");
    private static final FileNameExtensionFilter pascalFilter = new FileNameExtensionFilter("Pascal files", "p", "pp", "inc","pas");
    private static final FileNameExtensionFilter swiftFilter = new FileNameExtensionFilter("Swift files", "swift");
    private static final FileNameExtensionFilter fsharpFilter = new FileNameExtensionFilter("Text files", "fs", "fsi", "fsx", "fsscript");
    private static final FileNameExtensionFilter matlabFilter = new FileNameExtensionFilter("Matlab files", "m");
    private static final FileNameExtensionFilter objcFilter = new FileNameExtensionFilter("Obj-C files", "c", "h", "m", "mm");
    private static final FileNameExtensionFilter gradleFilter = new FileNameExtensionFilter("Gradle files", "gradle");
    private static final FileNameExtensionFilter batFilter = new FileNameExtensionFilter("Bat files", "bat");
    private static final FileNameExtensionFilter javaFilter = new FileNameExtensionFilter("Java files", "java");
    private static final FileNameExtensionFilter cFilter = new FileNameExtensionFilter("C files", "c", "h");
    private static final FileNameExtensionFilter csFilter = new FileNameExtensionFilter("C# files", "cs");
    private static final FileNameExtensionFilter cppFilter = new FileNameExtensionFilter("C++ files", "cpp", "h", "hpp");
    private static final FileNameExtensionFilter fFilter = new FileNameExtensionFilter("F Files", "f");
    private static final FileNameExtensionFilter phpFilter = new FileNameExtensionFilter("PHP Files", "php");
    private static final FileNameExtensionFilter jsonFilter = new FileNameExtensionFilter("Json Files", "json");
    private static final FileNameExtensionFilter htmlFilter = new FileNameExtensionFilter("Html files", "html");
    private static final FileNameExtensionFilter jsFilter = new FileNameExtensionFilter("JavaScript files", "js");
    private static final FileNameExtensionFilter pyFilter = new FileNameExtensionFilter("Python files", "py");
    private static final FileNameExtensionFilter xmlFilter = new FileNameExtensionFilter("XML files", "xml");
    private static final FileNameExtensionFilter vbsFilter = new FileNameExtensionFilter("VBS files", "vbs");
    private static final FileNameExtensionFilter cfgfFilter = new FileNameExtensionFilter("Config Files", "cfg", "ini", "inf");
    private static final FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("Text files", "txt", "md");
    private static final FileNameExtensionFilter[] all = {
            txtFilter,
            cfgfFilter,
            vbsFilter,
            xmlFilter,
            pyFilter,
            jsFilter,
            htmlFilter,
            jsonFilter,
            phpFilter,
            fFilter,
            fsharpFilter,
            cppFilter,
            csFilter,
            cFilter,
            javaFilter,
            batFilter,
            gradleFilter,
            objcFilter,
            matlabFilter,
            swiftFilter,
            pascalFilter,
            typescriptFilter,
            perlFilter,
            marvenFilter,
            cobolFilter,
            cssFilter
    };

    /**
     * Set FileChooser Filter
     * @param fileChooser: JFileChooser
     */
    public static void addExtentionFilter(JFileChooser fileChooser) {
        logger.debug("Adding Extention Filter");
        for (int i = 0; i < all.length; i++) {
            fileChooser.addChoosableFileFilter(all[i]);
        }
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

    public static FileNameExtensionFilter getPerlFilter() {
        return perlFilter;
    }

    public static FileNameExtensionFilter getTypescriptFilter() {
        return typescriptFilter;
    }

    public static FileNameExtensionFilter getPascalFilter() {
        return pascalFilter;
    }

    public static FileNameExtensionFilter getSwiftFilter() {
        return swiftFilter;
    }

    public static FileNameExtensionFilter getFsharpFilter() {
        return fsharpFilter;
    }

    public static FileNameExtensionFilter getMatlabFilter() {
        return matlabFilter;
    }

    public static FileNameExtensionFilter getObjcFilter() {
        return objcFilter;
    }

    public static FileNameExtensionFilter getGradleFilter() {
        return gradleFilter;
    }

    public static FileNameExtensionFilter getMarvenFilter() {
        return marvenFilter;
    }

    public static FileNameExtensionFilter[] getAll() {
        return all;
    }
}
