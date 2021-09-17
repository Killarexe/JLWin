package net.killarexe.jlwin.opengl.components;

import net.killarexe.jlwin.util.Logger;

public abstract class GLComponent {

    protected Logger logger = new Logger(getClass());

    public void start(){}
    public void rendererUpdate(float dt){}
    public void update(float dt){}
    public void end(){}

}
