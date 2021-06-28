package com.company;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;


public class GameFrame extends JFrame {
    GameFrame(SettingsFrame settingsFrame) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        GamePanel panel = new GamePanel(settingsFrame);
        this.add(panel);
        this.setTitle("Snake Game!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
