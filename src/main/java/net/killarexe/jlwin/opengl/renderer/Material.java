package net.killarexe.jlwin.opengl.renderer;

import org.newdawn.slick.opengl.*;

import java.io.IOException;

import static org.lwjgl.opengl.GL11.*;

public class Material {

    private Texture texture;
    private String path;
    private float width, height;
    private int textureID;

    public Material(String path){
        this.path = path;
    }

    public void create(){
        try {
            texture = TextureLoader.getTexture(path.split("[.]")[1], Material.class.getResourceAsStream(path), GL_LINEAR);
            width = texture.getWidth();
            height = texture.getHeight();
            textureID = texture.getTextureID();
        } catch (IOException e) {
            System.err.println("File Not Fount at " + path);
        }
    }

    public void destroy(){
        glDeleteTextures(textureID);
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public int getTextureID() {
        return textureID;
    }
}
