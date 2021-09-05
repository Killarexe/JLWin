package net.killarexe.test;

import net.killarexe.jlwin.audio.Audio;
import net.killarexe.jlwin.javax.component.JXWindow;

public class Main{

    private static JXWindow window;
    private static Audio audio;

    public static void main(String[] args) {
        window = new JXWindow("Hello, World!", 1280, 720);
        audio = new Audio("C:\\Users\\hc\\Music\\Test.wav");
        audio.startLoop();
    }
}