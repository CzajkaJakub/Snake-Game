package com.company;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameOverPanel extends JPanel implements ImageFiles{
    GameOverPanel(Integer applesEaten, String gameSize, String level) throws IOException {
        JButton score = new Button(applesEaten.toString(), 620, 730);
        score.setBounds(600, 730, 200, 101);
        score.setFont(new Font("MV Boli", Font.BOLD, 95));
        this.setBackground(Color.black);
        this.setBounds(0,0,900, 900);
        this.setLayout(new BorderLayout());
        this.add(snakeImage);
        this.add(applesEatenImage);
        this.add(gameOverImage);
        this.add(score);
        new SaveRecord(applesEaten, gameSize, level);
    }

}
