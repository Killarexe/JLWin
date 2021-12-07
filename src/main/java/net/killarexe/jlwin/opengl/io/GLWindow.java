package net.killarexe.jlwin.opengl.io;

import net.killarexe.jlwin.opengl.components.GLComponent;
import net.killarexe.jlwin.opengl.renderer.Renderer;
import org.lwjgl.glfw.*;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL.*;
import static org.lwjgl.opengl.GL11.*;

public abstract class GLWindow implements Runnable{

    protected GLFWWindowSizeCallback sizeCallback;
    protected List<GLComponent> components = new ArrayList<>();
    protected Renderer renderer;
    protected static Thread thread;
    protected String title;
    protected Input input;
    protected boolean isFullsceen, isResized;
    protected long window;
    protected int width, defaultWidth, defaultHeight, height;
    protected int[] windowPosX = new int[1], windowPosY = new int[1];
    protected float R,G,B;

    protected GLWindow(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
        this.defaultWidth = width;
        this.defaultHeight = height;
    }

    public void start(){
        thread = new Thread(this, "GLWindow");
        thread.start();
    }

    @Override
    public void run() {

    }

    protected void runWindow(){
        createWindow();
        onStart();
        for (GLComponent component: components) {
            component.start(renderer);
        }
        while (!shouldClose()){
            update();
        }
        onClose();
        destroy();
    }

    private void createWindow(){
        if(!glfwInit()){
            System.err.println("GLFW Failed To Initialize!");
            System.exit(-1);
        }

        input = new Input();
        renderer = new Renderer();
        window = glfwCreateWindow(width, height, title, isFullsceen ? glfwGetPrimaryMonitor() : 0, 0);
        //glfwWindowHint(GLFW_VERSION_MAJOR, 4);
        //glfwWindowHint(GLFW_VERSION_MINOR, 6);
        //glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE);
        if(window == 0){
            System.err.println("Window Failed to be created!");
            System.exit(-1);
        }

        GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        windowPosX[0] = (videoMode.width() - width) / 2;
        windowPosY[0] = (videoMode.height() - height) / 2;
        glfwSetWindowPos(window, windowPosX[0], windowPosY[0]);
        glfwMakeContextCurrent(window);
        createCapabilities();
        glEnable(GL_DEPTH_TEST);
        createCallbacks();
        glfwShowWindow(window);
        glfwSwapInterval(1);
    }

    private void createCallbacks(){
        sizeCallback = new GLFWWindowSizeCallback() {
            @Override
            public void invoke(long window, int w, int h) {
                width = w;
                height = h;
                isResized = true;
            }
        };
        glfwSetKeyCallback(window, input.getKeybordCallback());
        glfwSetCursorPosCallback(window, input.getMousePosCallback());
        glfwSetMouseButtonCallback(window, input.getMouseButtonCallback());
        glfwSetWindowSizeCallback(window, sizeCallback);
        glfwSetScrollCallback(window, input.getScroll());
    }

    private void update(){
        if(isResized){
            glViewport(0, 0, width, height);
            isResized = false;
        }
        glClearColor(R, G, B, 1f);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glfwPollEvents();

        onUpdate();
        for (GLComponent component: components) {
            component.update();
        }
        onRenderUpdate();
        for (GLComponent component: components) {
            component.rendererUpdate(renderer);
        }

        swapBuffers();
    }

    private void destroy(){
        for (GLComponent component: components) {
            component.end();
        }
        input.destroy();
        glfwWindowShouldClose(window);
        glfwDestroyWindow(window);
        glfwTerminate();
    }

    private void swapBuffers(){
        glfwSwapBuffers(window);
    }

    public abstract void onStart();
    public abstract void onUpdate();
    public abstract void onRenderUpdate();
    public abstract void onClose();

    private boolean shouldClose(){
        return glfwWindowShouldClose(window);
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setColorBkg(float R, float G, float B){
        this.R = R;
        this.G = G;
        this.B = B;
    }

    public void setFullsceen(boolean isFullsceen, boolean resize){
        this.isFullsceen = isFullsceen;
        isResized = true;
        if(isFullsceen){
            if(resize) {
                width = glfwGetVideoMode(glfwGetPrimaryMonitor()).width();
                height = glfwGetVideoMode(glfwGetPrimaryMonitor()).height();
            }
            glfwGetWindowPos(window, windowPosX, windowPosY);
            glfwSetWindowMonitor(window, glfwGetPrimaryMonitor(), 0, 0, width, height, 0);
        }else{
            if(resize) {
                width = defaultWidth;
                height = defaultHeight;
            }
            glfwSetWindowMonitor(window, 0, windowPosX[0], windowPosY[0], width, height, 0);
        }
    }

    public boolean isFullsceen() {
        return isFullsceen;
    }

}
