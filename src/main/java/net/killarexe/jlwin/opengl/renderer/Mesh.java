package net.killarexe.jlwin.opengl.renderer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;
import org.lwjgl.system.MemoryUtil;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class Mesh {
    private Material material;
    private Vertex[] vertices;
    private int[] indices;
    private int vao, pbo, ibo, cbo, tbo;

    public Mesh(Vertex[] vertices, int[] indices, Material material){
        this.material = material;
        this.vertices = vertices;
        this.indices = indices;
    }

    public void create(){
        material.create();

        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        FloatBuffer posBuffer = MemoryUtil.memAllocFloat(vertices.length * 3);
        float[] posData = new float[vertices.length * 3];
        for (int i = 0; i < vertices.length; i++) {
            posData[i * 3] = vertices[i].getPos().x;
            posData[i * 3 + 1] = vertices[i].getPos().y;
            posData[i * 3 + 2] = vertices[i].getPos().z;
        }
        posBuffer.put(posData).flip();

        pbo = storeData(posBuffer, 0, 3);

        FloatBuffer colorBuffer = MemoryUtil.memAllocFloat(vertices.length * 3);
        float[] colorData = new float[vertices.length * 3];
        for (int i = 0; i < vertices.length; i++) {
            colorData[i * 3] = vertices[i].getTextureCoord().x;
            colorData[i * 3 + 1] = vertices[i].getTextureCoord().y;
        }
        colorBuffer.put(colorData).flip();

        cbo = storeData(colorBuffer, 1, 3);

        FloatBuffer textureBuffer = MemoryUtil.memAllocFloat(vertices.length * 2);
        float[] textureData = new float[vertices.length * 2];
        for (int i = 0; i < vertices.length; i++) {
            textureData[i * 2] = vertices[i].getColor().x;
            textureData[i * 2 + 1] = vertices[i].getColor().y;
            textureData[i * 2 + 2] = vertices[i].getColor().z;
        }
        colorBuffer.put(textureData).flip();

        tbo = storeData(textureBuffer, 2, 2);

        IntBuffer indicesBuffer = MemoryUtil.memAllocInt(indices.length);
        indicesBuffer.put(indices).flip();

        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, indicesBuffer, GL_STATIC_DRAW);
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
    }

    public void destroy(){
        glDeleteBuffers(pbo);
        glDeleteBuffers(cbo);
        glDeleteBuffers(ibo);
        glDeleteBuffers(tbo);
        glDeleteVertexArrays(vao);
        material.destroy();
    }

    private int storeData(FloatBuffer buffer, int index, int size){
        int bufferId = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, bufferId);
        glBufferData(GL_ARRAY_BUFFER, buffer, GL_STATIC_DRAW);
        glVertexAttribPointer(index, size, GL_FLOAT, false, 0, 0);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
        return bufferId;
    }

    public Material getMaterial() {
        return material;
    }

    public Vertex[] getVertices() {
        return vertices;
    }

    public int[] getIndices() {
        return indices;
    }

    public int getVao() {
        return vao;
    }

    public int getPbo() {
        return pbo;
    }

    public int getIbo() {
        return ibo;
    }

    public int getCbo() {
        return cbo;
    }

    public int getTbo() {
        return tbo;
    }
}

