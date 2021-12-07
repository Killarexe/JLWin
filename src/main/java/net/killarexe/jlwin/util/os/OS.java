package net.killarexe.jlwin.util.os;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;

public class OS {

    private static Logger logger = LogManager.getLogger();
    private static String OSName = System.getProperty("os.name").toLowerCase(Locale.ROOT);

    public static OSType getCurrentOS(){
        if(isWindows()){
            return OSType.WINDOWS;
        }else if(isMac()){
            return OSType.MAC;
        }else if(isLinux()){
            return OSType.LINUX;
        }else if(isSolaris()){
            return OSType.SOLARIS;
        }
        return OSType.MISSINGTYPE;
    }

    public static void printCurrentOS(){
        OSType type = getCurrentOS();

        if (type == OSType.WINDOWS) {
            System.out.println("This is Windows");
        } else if (type == OSType.MAC) {
            System.out.println("This is Mac");
        } else if (type == OSType.LINUX) {
            System.out.println("This is Unix or Linux");
        } else if (type == OSType.SOLARIS) {
            System.out.println("This is Solaris");
        } else if (type == OSType.MISSINGTYPE){
            System.out.println("Your OS is not support!!");
        }
    }

    public static boolean isWindows() {
        return (OSName.indexOf("win") >= 0);
    }

    public static boolean isMac() {
        return (OSName.indexOf("mac") >= 0);
    }

    public static boolean isLinux() {
        return (OSName.indexOf("nix") >= 0
                || OSName.indexOf("nux") >= 0
                || OSName.indexOf("aix") > 0);
    }

    public static boolean isSolaris() {
        return (OSName.indexOf("sunos") >= 0);
    }
}
