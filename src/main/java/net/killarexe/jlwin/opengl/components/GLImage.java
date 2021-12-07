package net.killarexe.jlwin.opengl.components;

import net.killarexe.jlwin.opengl.assets.Shader;
import net.killarexe.jlwin.opengl.renderer.*;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;

public class GLImage extends GLComponent{

    private Mesh mesh;
    private Shader shader;

    public GLImage(float size, Renderer renderer, Shader shader, String imagePath){
        this.shader = shader;
        mesh = new Mesh(new Vertex[]{
                new Vertex(new Vector3f(-0.5f * size, 0.5f * size, 0f * size), new Vector3f(1f, 0f, 0f), new Vector2f(0, 0)),
                new Vertex(new Vector3f(0.5f * size, 0.5f * size, 0f * size), new Vector3f(0f, 1f, 0f), new Vector2f(0, 1)),
                new Vertex(new Vector3f(0.5f * size, -0.5f * size, 0f * size), new Vector3f(1f, 0f, 1f), new Vector2f(1, 1)),
                new Vertex(new Vector3f(-0.5f * size, -0.5f * size, 0f * size), new Vector3f(1f, 1f, 0f), new Vector2f(1, 0))
        }, new int[]{
                0, 1, 2,
                0, 3, 2
        }, new Material(imagePath));
        renderer.setShader(shader);
        mesh.create();
        shader.compile();
    }

    @Override
    public void start(Renderer renderer) {

    }

    @Override
    public void rendererUpdate(Renderer renderer) {
        renderer.renderMesh(mesh);
    }

    @Override
    public void end() {
        mesh.destroy();
    }

    public Mesh getMesh() {
        return mesh;
    }

    public Shader getShader() {
        return shader;
    }
}
