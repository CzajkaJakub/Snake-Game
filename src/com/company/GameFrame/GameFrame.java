package com.company.GameFrame;

import com.company.ImagesSet.ImageFiles;

import javax.swing.*;
import java.io.IOException;

public class GameFrame extends JFrame implements ImageFiles {
    public GameFrame(String level, String units) throws IOException {
        GamePanel panel = new GamePanel(level, units);
        frameSettings(panel);
    }

    private void frameSettings(GamePanel panel){
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
