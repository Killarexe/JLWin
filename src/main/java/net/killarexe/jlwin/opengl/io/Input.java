package net.killarexe.jlwin.opengl.io;

import org.lwjgl.glfw.*;
import static org.lwjgl.glfw.GLFW.*;

public class Input {

    private static boolean[] keys = new boolean[GLFW_KEY_LAST];
    private static boolean[] mouseButtons = new boolean[GLFW_MOUSE_BUTTON_LAST];
    private static double mouseX, mouseY;
    private static double scrollX, scrollY;

    private GLFWKeyCallback keybord;
    private GLFWCursorPosCallback mousePos;
    private GLFWMouseButtonCallback mouseButton;
    private GLFWScrollCallback scroll;

    public Input(){
        keybord = new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                keys[key] = (action != GLFW_RELEASE);
            }
        };

        mousePos = new GLFWCursorPosCallback() {
            @Override
            public void invoke(long window, double xpos, double ypos) {
                mouseX = xpos;
                mouseY = ypos;
            }
        };

        mouseButton = new GLFWMouseButtonCallback() {
            @Override
            public void invoke(long window, int button, int action, int mods) {
                mouseButtons[button] = (action != GLFW_RELEASE);
            }
        };

        scroll = new GLFWScrollCallback() {
            @Override
            public void invoke(long window, double xoffset, double yoffset) {
                scrollX = xoffset;
                scrollY = yoffset;
            }
        };
    }

    public void destroy(){
        keybord.free();
        mousePos.free();
        mouseButton.free();
        scroll.free();
    }

    public static boolean isKeyDown(int key){
        return keys[key];
    }

    public boolean isMouseButtonDown(int button){
        return mouseButtons[button];
    }

    public static double getMouseX() {
        return mouseX;
    }

    public static double getMouseY() {
        return mouseY;
    }

    public static double getScrollX() {
        return scrollX;
    }

    public static double getScrollY() {
        return scrollY;
    }

    public GLFWKeyCallback getKeybordCallback() {
        return keybord;
    }

    public GLFWCursorPosCallback getMousePosCallback() {
        return mousePos;
    }

    public GLFWMouseButtonCallback getMouseButtonCallback() {
        return mouseButton;
    }

    public GLFWScrollCallback getScroll() {
        return scroll;
    }
}

