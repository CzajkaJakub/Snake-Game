package com.company;


import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


public class MusicPanel {

    private final static File backGroundMusicFile = new File("src/song/backgroundMusic.wav");
    private final static File pointCollectFile = new File("src/song/pointCollect.wav");
    private final static File gameOverFile = new File("src/song/gameOver.wav");



    AudioInputStream backGroundAudio = AudioSystem.getAudioInputStream(backGroundMusicFile);
    Clip backGroundClip = AudioSystem.getClip();

    AudioInputStream pointCollectAudio = AudioSystem.getAudioInputStream(pointCollectFile);
    Clip pointCollectClip = AudioSystem.getClip();

    AudioInputStream gameOverAudio = AudioSystem.getAudioInputStream(gameOverFile);
    Clip gameOverClip = AudioSystem.getClip();


    public MusicPanel() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        pointCollectClip.open(pointCollectAudio);
        backGroundClip.open(backGroundAudio);
        gameOverClip.open(gameOverAudio);
    }


    public void playBackgroundMusic(){
        backGroundClip.setMicrosecondPosition(0);
        backGroundClip.start();
    }

    public void playPointCollectMusic(){
        pointCollectClip.setMicrosecondPosition(0);
        pointCollectClip.start();
    }

    public void playGameOverMusic() throws IOException {
        stopPlayingBackgroundMusic();
        stopPlayingCollectionPointsMusic();
        gameOverClip.setMicrosecondPosition(0);
        gameOverClip.start();
    }

    public void stopPlayingBackgroundMusic() throws IOException {
        backGroundClip.stop();
        backGroundClip.close();
        backGroundAudio.close();
    }

    public void stopPlayingCollectionPointsMusic() throws IOException {
        pointCollectClip.stop();
        pointCollectClip.close();
        pointCollectAudio.close();
    }

    public void  stopPlayingGameOverMusic() throws IOException {
        gameOverClip.stop();
        gameOverClip.close();
        gameOverAudio.close();
    }









}
