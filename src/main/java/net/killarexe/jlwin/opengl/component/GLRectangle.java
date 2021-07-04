package net.killarexe.jlwin.opengl.component;

import net.killarexe.jlwin.opengl.Shader;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL20;

public class GLRectangle extends GLComponent{

    private int width;
    private int height;
    private Vector4f color;
    private Shader shader;

    public GLRectangle(int width, int height, Vector4f color, Shader shader){
        this.width = width;
        this.height = height;
        this.color = color;
        this.shader = shader;
    }

    @Override
    public void update(float dt) {
        GL20.glDrawPixels(width, height, GL20.GL_TEXTURE_INTERNAL_FORMAT, GL20.GL_SHADER_TYPE,width*height);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Vector4f getColor() {
        return color;
    }
}
