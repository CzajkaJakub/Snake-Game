package com.company;


import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Snake {

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        SettingsFrame settingsFrame = new SettingsFrame();
        new GameFrame(settingsFrame);

    }
}

