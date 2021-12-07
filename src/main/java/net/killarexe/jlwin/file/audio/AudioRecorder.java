package net.killarexe.jlwin.file.audio;

import net.killarexe.jlwin.file.AssetFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sound.sampled.*;
import java.io.IOException;

public class AudioRecorder {
    
    private long recordTime;
    private AssetFile file;
    private AudioFileFormat.Type fileType;
    private TargetDataLine line;
    private Logger logger = LogManager.getLogger();

    public void start(long recordTime, String path, AudioFileFormat.Type type){
        this.recordTime = recordTime;
        this.file = new AssetFile(path);
        this.fileType = type;

        Thread stopper = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(recordTime);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                stop();
            }
        });

        stopper.start();

        try{
            AudioFormat format = getAudioFormat();
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

            if (!AudioSystem.isLineSupported(info)) {
               logger.error("Line not supported");
            }
            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();

            logger.info("Start capturing...");

            AudioInputStream ais = new AudioInputStream(line);

            logger.info("Start recording...");

            AudioSystem.write(ais, fileType, file.getFile());
        }
        catch (LineUnavailableException e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        catch (IOException e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public void stop(){
        line.stop();
        line.close();
        logger.info("Stopping recording");
    }

    public AudioFormat getAudioFormat(){
        float sampleRate = 16000;
        int sampleSizeInBits = 8;
        int channels = 2;
        boolean signed = true;
        boolean bigEndian = true;
        AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
        return format;
    }

    public long getRecordTime() {
        return recordTime;
    }

    public AssetFile getFile() {
        return file;
    }

    public AudioFileFormat.Type getFileType() {
        return fileType;
    }
}
