package com.company;

import javax.swing.*;


public class GameFrame extends JFrame {
    GameFrame(String level, String units){
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
