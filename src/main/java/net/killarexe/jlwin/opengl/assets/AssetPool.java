package net.killarexe.jlwin.opengl.assets;

import net.killarexe.jlwin.util.Logger;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AssetPool {

    private static Map<String, Shader> shaders = new HashMap<>();

    private static Logger logger = new Logger(AssetPool.class);

    public static Shader getShader(String resourceName){
        File file = new File(resourceName);
        if(AssetPool.shaders.containsKey(file.getAbsolutePath())){
            return AssetPool.shaders.get(file.getAbsolutePath());
        }else{
            Shader shader = new Shader(resourceName);
            shader.compile();
            AssetPool.shaders.put(file.getAbsolutePath(), shader);
            return shader;
        }
    }
}
