package com.company;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SnakeSound {

    final static File snakeSong = new File("src/song/snakeSound.wav");
    AudioInputStream snakeSound = AudioSystem.getAudioInputStream(snakeSong);
    Clip snakeSoundClip = AudioSystem.getClip();

    SnakeSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        playSnakeSong();
    }

    public void playSnakeSong() throws LineUnavailableException, IOException {
        snakeSoundClip.open(snakeSound);
        snakeSoundClip.setMicrosecondPosition(0);
        snakeSoundClip.start();
    }

    public void stopSnakeSong() throws IOException {
        snakeSoundClip.start();
        snakeSoundClip.close();
        snakeSound.close();
    }
}
