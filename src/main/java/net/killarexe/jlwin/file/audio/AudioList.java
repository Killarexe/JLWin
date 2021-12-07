package net.killarexe.jlwin.file.audio;

import java.util.ArrayList;
import java.util.List;

public class AudioList {

    private List<Audio> audios = new ArrayList<>();

    public AudioList(String[] path){
        for(int i = 0; i < path.length; i++){
            audios.add(new Audio(path[i]));
        }
    }

    public void play(int index){
        audios.get(index).play();
    }

    public void startLoop(int index, int count){
        audios.get(index).startLoop(count);
    }

    public void startLoop(int index){
        audios.get(index).startLoop();
    }

    public void stop(int index){
        audios.get(index).stop();
    }

    public List<Audio> getAudios() {
        return audios;
    }

    public void setAudios(List<Audio> audios) {
        this.audios = audios;
    }
}
