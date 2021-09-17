package net.killarexe.jlwin.opengl.components;

import org.joml.*;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;

public class GLQuad extends GLComponent {

    private int width, height;
    private Vector2f pos;
    private Vector4f color;

    public GLQuad(Vector2f pos, int width, int height, Vector4f color){
        this.pos = pos;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public GLQuad(Vector2f pos, int width, int height, Vector3f color){
        this.pos = pos;
        this.width = width;
        this.height = height;
        this.color = new Vector4f(color.x, color.y, color.z, 255);
    }

    @Override
    public void start() {
    }

    @Override
    public void rendererUpdate(float dt) {
        GL11.glColor4f(color.x, color.y, color.z, color.w);

        glPushMatrix();
        glTranslatef(width, height, 0);
        glBegin(GL_QUADS);

        glVertex2f(-pos.x, pos.y);
        glVertex2f(width, pos.y);
        glVertex2f(width, -height);
        glVertex2f(-pos.x, -height);

        glEnd();
        glPopMatrix();
    }

    @Override
    public void end() {

    }
}
