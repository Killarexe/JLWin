package net.killarexe.jlwin.opengl.components;

import net.killarexe.jlwin.opengl.renderer.Renderer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class GLComponent {

    protected Logger logger = LogManager.getLogger();

    public void start(Renderer renderer){}
    public void rendererUpdate(Renderer renderer){}
    public void update(){}
    public void end(){}

}
