package com.company;

import javax.swing.*;

public interface ImageFiles {
    ImageIcon windowIcon = new ImageIcon("images/snake.png");
    ImageIcon snakeBackgroundIcon = new ImageIcon("images/snakeBackgroundImage.png");
    ImageIcon snakeWord = new ImageIcon("images/snakeWord.png");
    ImageIcon difWord = new ImageIcon("images/difWord.png");
    ImageIcon sizeWord = new ImageIcon("images/sizeWord.png");
    ImageIcon snakeIcon = new ImageIcon("images/snake.png");
    PreImage snakeImage = new PreImage(snakeBackgroundIcon, 139, 260, 622, 400);
    ImageIcon gameOver = new ImageIcon("images/gameOver.png");
    PreImage gameOverImage = new PreImage(gameOver, 222, 50, 457, 90);
    ImageIcon applesEatenI = new ImageIcon("images/applesEaten.png");
    PreImage applesEatenImage = new PreImage(applesEatenI, 50, 730, 538, 101);
}
