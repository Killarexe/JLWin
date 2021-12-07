package net.killarexe.jlwin.opengl.renderer;

import org.joml.Vector2f;
import org.joml.Vector3f;

public class Vertex {
    private Vector3f pos, color;
    private Vector2f textureCoord;

    public Vertex(Vector3f pos, Vector3f color, Vector2f textureCoord){
        this.pos = pos;
        this.color = color;
        this.textureCoord = textureCoord;
    }

    public Vector2f getTextureCoord() {
        return textureCoord;
    }

    public Vector3f getPos() {
        return pos;
    }

    public Vector3f getColor(){
        return color;
    }
}
