package net.killarexe.jlwin.opengl.component;

import net.killarexe.jlwin.util.Logger;
import org.joml.Vector4f;
import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;
import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

public class GLWindow extends GLComponent{

    private long window, icon;
    private String title;
    private int width, height;
    private float fps;
    private boolean isResizeable;
    private Vector4f color;
    private List<GLComponent> glComponents = new ArrayList<>();

    private Logger logger = new Logger(getClass());

    public GLWindow(long window, long icon, String title, int width, int height, boolean isResizeable, Vector4f color) {
        logger.info("Start GLWindow '" + title + "'");
        this.window = window;
        this.icon = icon;
        this.title = title;
        this.width = width;
        this.height = height;
        this.isResizeable = isResizeable;
        this.color = color;
    }

    public GLWindow(long window, long icon, String title, int width, int height, boolean isResizeable) {
        logger.info("Start GLWindow '" + title + "'");
        this.window = window;
        this.icon = icon;
        this.title = title;
        this.width = width;
        this.height = height;
        this.isResizeable = isResizeable;
        this.color = new Vector4f(1, 1, 1, 1);
    }

    public GLWindow(long window, long icon, String title, int width, int height) {
        logger.info("Start GLWindow '" + title + "'");
        this.window = window;
        this.icon = icon;
        this.title = title;
        this.width = width;
        this.height = height;
        this.isResizeable = false;
        this.color = new Vector4f(1, 1, 1, 1);
    }

    public GLWindow(long window, String title, int width, int height) {
        logger.info("Start GLWindow '" + title + "'");
        this.window = window;
        this.icon = 0;
        this.title = title;
        this.width = width;
        this.height = height;
        this.isResizeable = false;
        this.color = new Vector4f(1, 1, 1, 1);
    }

    public void run() {
        logger.info("Using LWJGL " + Version.getVersion() + "!");

        logger.info("Init " + this.title);
        init();
        logger.info("Init Complete!");
        loop();

        glfwFreeCallbacks(this.window);
        glfwDestroyWindow(this.window);

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    private void init() {
        GLFWErrorCallback.createPrint(System.err).set();

        if ( !glfwInit() ) {
            logger.fatal("Unable to initialize GLFW");
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, ifisResizeable());

        // Create the window
        logger.info("Creating Window");
        this.window = glfwCreateWindow(this.width, this.height, this.title, NULL, NULL);
        if ( window == NULL ) {
            logger.fatal("Failed to create the GLFW window");
            throw new RuntimeException("Failed to create the GLFW window");
        }

        glfwSetKeyCallback(this.window, (window, key, scancode, action, mods) -> {
            if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
                glfwSetWindowShouldClose(window, true);
        });

        try ( MemoryStack stack = stackPush() ) {
            IntBuffer pWidth = stack.mallocInt(1);
            IntBuffer pHeight = stack.mallocInt(1);

            glfwGetWindowSize(this.window, pWidth, pHeight);

            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            glfwSetWindowPos(
                    this.window,
                    (vidmode.width() - pWidth.get(0)) / 2,
                    (vidmode.height() - pHeight.get(0)) / 2
            );
        }

        glfwMakeContextCurrent(this.window);
        glfwSwapInterval(1);

        if(this.icon != 0){
            glfwSetWindowIcon(window, new GLFWImage.Buffer(this.icon, 0));
        }

        glfwShowWindow(this.window);
    }

    private void loop() {

        float beginTime = (float)glfwGetTime();
        float endTime;
        float dt = -1.0f;

        GL.createCapabilities();

        glClearColor(color.x, color.y, color.z, color.w);

        while ( !glfwWindowShouldClose(this.window) ) {

            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

            glfwSwapBuffers(this.window);

            for (GLComponent glComponent: glComponents) {
                glComponent.update(dt);
            }

            glfwPollEvents();

            endTime = (float)glfwGetTime();
            dt = endTime - beginTime;
            beginTime = endTime;
        }
    }

    private int ifisResizeable(){
        if(this.isResizeable){
            return 1;
        }
        return 0;
    }

    public void addComponents(GLComponent component){
        if(component != this && !glComponents.contains(component)){
            glComponents.add(component);
        }
    }

    private boolean isResizeable(){
        return this.isResizeable;
    }

    public long getWindow() {
        return this.window;
    }

    public void setWindow(long window) {
        this.window = window;
    }

    public long getIcon() {
        return this.icon;
    }

    public void setIcon(long icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setResizeable(boolean resizeable) {
        this.isResizeable = resizeable;
    }

    public Vector4f getColor() {
        return this.color;
    }

    public void setColor(Vector4f color) {
        this.color = color;
    }
}
