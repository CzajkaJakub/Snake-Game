package com.company;


import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


public class MusicPanel {

    private final File backGroundMusicFile = new File("src/song/backgroundMusic.wav");
    private final File pointCollectFile = new File("src/song/pointCollect.wav");
    private final File gameOverFile = new File("src/song/gameOver.wav");

    private final AudioInputStream backGroundAudio = AudioSystem.getAudioInputStream(backGroundMusicFile);
    private final AudioInputStream gameOverAudio = AudioSystem.getAudioInputStream(gameOverFile);
    AudioInputStream pointCollectAudio = AudioSystem.getAudioInputStream(pointCollectFile);


    private final Clip backGroundClip = AudioSystem.getClip();
    private final Clip gameOverClip = AudioSystem.getClip();
    Clip pointCollectClip = AudioSystem.getClip();

    public MusicPanel() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        playBackgroundMusic();
    }


    public void playBackgroundMusic() throws LineUnavailableException, IOException {
        backGroundClip.open(backGroundAudio);
        backGroundClip.start();
    }

    public void playPointCollectMusic() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        pointCollectAudio = AudioSystem.getAudioInputStream(pointCollectFile);
        pointCollectClip = AudioSystem.getClip();
        pointCollectClip.open(pointCollectAudio);
        pointCollectClip.start();

    }

    public void playGameOverMusic() throws LineUnavailableException, IOException {
        gameOverClip.open(gameOverAudio);
        gameOverClip.start();
    }

    public void stopPlayBackgroundMusic(){
        backGroundClip.stop();
        backGroundClip.close();
    }







}
