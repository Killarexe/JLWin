package net.killarexe.jlwin.file.audio;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sound.sampled.*;
import java.io.*;

/**
 * Date: 05/09/2021
 * @author Killar.exe
 * @version 0.2a
 */
public class Audio {

    private File file;
    private AudioInputStream stream;
    private Clip clip;
    private boolean isConverted;
    private Logger logger = LogManager.getLogger();

    /**
     * Setup Audio (ONLY .WAW FILES!)
     * @param path: Path to the file.
     */
    public Audio(String path){
        logger.info("Setup Audio!");
        file = new File(path);
        setup();
    }

    /**
     * Setup Audio (ONLY .WAW FILES!)
     * @param file: Selected File.
     */
    public Audio(File file){
        logger.info("Setup Audio!");
        this.file = file;
        if(file.getName().endsWith(".mp3") || file.getName().endsWith(".MP3")){
            this.file = convert();
        }
        setup();
    }

    private void setup(){

        try {
            stream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public File convert(){
        logger.warn("File Detected as MP3 Converting..");
        isConverted = true;
        logger.info("Convert Complete!");
        return new File("C:\\Users\\hc\\Music\\mp3converted.wav");
    }

    /**
     * Play selected file.
     */
    public void play(){
        logger.info("Play " + file.getName());
        try {
            clip.open(stream);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        clip.start();
    }

    /**
     * Looping and play selected file.
     * @param count: Number of times we loop.
     */
    public void startLoop(int count){
        logger.info("Play loop for " + count + " times " + file.getName());
        try {
            clip.open(stream);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        clip.loop(count);
    }

    /**
     * Looping and play selected file for infinite.
     */
    public void startLoop(){
        logger.info("Play loop for " + file.getName());
        try {
            clip.open(stream);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        clip.loop(Integer.MAX_VALUE);
    }

    /**
     * Stop the audio
     */
    public void stop(){
        logger.info("Stop Audio!");
        clip.close();
        clip.stop();
        if(isConverted){
            file.delete();
            isConverted = false;
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public AudioInputStream getStream() {
        return stream;
    }

    public void setStream(AudioInputStream stream) {
        this.stream = stream;
    }

    public Clip getClip() {
        return clip;
    }

    public void setClip(Clip clip) {
        this.clip = clip;
    }
}
