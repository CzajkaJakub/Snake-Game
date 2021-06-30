package com.company;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;


public class GameFrame extends JFrame {
    GameFrame(String level, String units) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        GamePanel panel = new GamePanel(level, units);
        ImageIcon snakeIcon = new ImageIcon("images/snake.png");
        this.setIconImage(snakeIcon.getImage());
        this.add(panel);
        this.setTitle("Snake Game!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
