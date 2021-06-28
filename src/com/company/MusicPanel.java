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


    public MusicPanel() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        playBackgroundMusic();
    }


    public void playBackgroundMusic() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        backGroundAudio = AudioSystem.getAudioInputStream(backGroundMusicFile);
        backGroundClip = AudioSystem.getClip();
        backGroundClip.open(backGroundAudio);
        backGroundClip.start();
    }

    public void playPointCollectMusic() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        AudioInputStream pointCollectAudio = AudioSystem.getAudioInputStream(pointCollectFile);
        Clip pointCollectClip = AudioSystem.getClip();
        pointCollectClip.open(pointCollectAudio);
        pointCollectClip.start();
    }

    public void playGameOverMusic() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        backGroundClip.stop();
        AudioInputStream gameOverAudio = AudioSystem.getAudioInputStream(gameOverFile);
        Clip gameOverClip = AudioSystem.getClip();
        gameOverClip.open(gameOverAudio);
        gameOverClip.start();
    }









}
