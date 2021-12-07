package net.killarexe.jlwin.opengl.renderer;

import net.killarexe.jlwin.opengl.assets.Shader;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

public class Renderer {

    private Shader shader;

    public Renderer(Shader shader){
        this.shader = shader;
    }
    public Renderer(){
        this.shader = null;
    }

    public void renderMesh(Mesh mesh){
        glBindVertexArray(mesh.getVao());
        glEnableVertexAttribArray(0);
        glEnableVertexAttribArray(1);
        glEnableVertexAttribArray(2);
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, mesh.getIbo());
        glActiveTexture(GL_TEXTURE0);
        glBindTexture(GL_TEXTURE_2D, mesh.getMaterial().getTextureID());
        if(shader != null) {
            shader.use();
        }
        glDrawElements(GL_TRIANGLES, mesh.getIndices().length, GL_UNSIGNED_INT, 0);
        if(shader != null) {
            shader.detach();
        }
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
        glDisableVertexAttribArray(0);
        glDisableVertexAttribArray(1);
        glDisableVertexAttribArray(2);
        glBindVertexArray(0);
    }

    public Shader getShader() {
        return shader;
    }

    public void setShader(Shader shader) {
        this.shader = shader;
    }
}
