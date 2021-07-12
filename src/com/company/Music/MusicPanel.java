package com.company.Music;


import javax.sound.sampled.*;
import java.io.IOException;


public class MusicPanel implements MusicFiles{

    static AudioInputStream gameOverAudio;
    static Clip gameOverClip;
    static AudioInputStream pointCollectAudio;
    static Clip pointCollectClip;
    static AudioInputStream backGroundAudio;
    static Clip backGroundClip;
    static AudioInputStream snakeSound;
    static Clip snakeSoundClip;

    static {
        try {
            gameOverAudio = AudioSystem.getAudioInputStream(gameOverFile);
            gameOverClip = AudioSystem.getClip();
            pointCollectAudio = AudioSystem.getAudioInputStream(pointCollectFile);
            pointCollectClip = AudioSystem.getClip();
            backGroundAudio = AudioSystem.getAudioInputStream(backGroundMusicFile);
            backGroundClip = AudioSystem.getClip();
            snakeSound = AudioSystem.getAudioInputStream(snakeSong);
            snakeSoundClip = AudioSystem.getClip();
            snakeSoundClip.open(snakeSound);
            pointCollectClip.open(pointCollectAudio);
            backGroundClip.open(backGroundAudio);
            gameOverClip.open(gameOverAudio);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void playBackgroundMusic(){
        backGroundClip.setMicrosecondPosition(0);
        backGroundClip.start();
    }

    public static void playPointCollectMusic(){
        pointCollectClip.setMicrosecondPosition(0);
        pointCollectClip.start();
    }

    public static void playGameOverMusic() throws IOException {
        stopPlayingBackgroundMusic();
        stopPlayingCollectionPointsMusic();
        gameOverClip.setMicrosecondPosition(0);
        gameOverClip.start();
    }

    public static void stopPlayingBackgroundMusic() throws IOException {
        backGroundClip.stop();
        backGroundClip.close();
        backGroundAudio.close();
    }

    public static void stopPlayingCollectionPointsMusic() throws IOException {
        pointCollectClip.stop();
        pointCollectClip.close();
        pointCollectAudio.close();
    }

    public static void playSnakeSong(){
        snakeSoundClip.setMicrosecondPosition(0);
        snakeSoundClip.start();
    }

    public static void stopSnakeSong() throws IOException {
        snakeSoundClip.start();
        snakeSoundClip.close();
        snakeSound.close();
    }









}
