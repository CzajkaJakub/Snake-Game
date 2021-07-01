package com.company;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameOverPanel extends JPanel {

    final private static ImageIcon snakeBackgroundIcon = new ImageIcon("images/snakeBackgroundImage.png");
    final private static PreImage snakeImage = new PreImage(snakeBackgroundIcon, 139, 260, 622, 400);

    final private static ImageIcon gameOver = new ImageIcon("images/gameOver.png");
    final private static PreImage gameOverImage = new PreImage(gameOver, 222, 50, 457, 90);

    final private static ImageIcon applesEatenI = new ImageIcon("images/applesEaten.png");
    final private static PreImage applesEatenImage = new PreImage(applesEatenI, 50, 730, 538, 101);


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
