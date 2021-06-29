package com.company;


import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


public class MusicPanel {

    private final File backGroundMusicFile = new File("src/song/backgroundMusic.wav");
    private final File pointCollectFile = new File("src/song/pointCollect.wav");
    private final File gameOverFile = new File("src/song/gameOver.wav");

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
        playBackgroundMusic();
    }


    public void playBackgroundMusic(){
        backGroundClip.start();
    }

    public void playPointCollectMusic(){
        pointCollectClip.setMicrosecondPosition(0);
        pointCollectClip.start();
    }

    public void playGameOverMusic() throws IOException {
        stopPlayingBackgroundMusic();
        stopPlayingCollectionPointsMusic();
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









}
