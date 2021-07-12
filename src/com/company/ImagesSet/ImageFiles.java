package com.company.ImagesSet;

import javax.swing.*;

public interface ImageFiles {
    ImageIcon windowIcon = new ImageIcon("images/snake.png");
    ImageIcon snakeBackgroundIcon = new ImageIcon("images/snakeBackgroundImage.png");
    ImageIcon snakeWord = new ImageIcon("images/snakeWord.png");
    ImageIcon difWord = new ImageIcon("images/difWord.png");
    ImageIcon sizeWord = new ImageIcon("images/sizeWord.png");
    ImageIcon snakeIcon = new ImageIcon("images/snake.png");
    SetImagePosition snakeImageGameOver = new SetImagePosition(snakeBackgroundIcon, 139, 260, 622, 400);
    ImageIcon gameOver = new ImageIcon("images/gameOver.png");
    SetImagePosition gameOverImage = new SetImagePosition(gameOver, 222, 50, 457, 90);
    ImageIcon applesEatenI = new ImageIcon("images/applesEaten.png");
    SetImagePosition applesEatenImage = new SetImagePosition(applesEatenI, 50, 730, 538, 101);
    SetImagePosition backGround = new SetImagePosition(snakeWord, 283, 20, 333, 103);
    SetImagePosition snakeImage = new SetImagePosition(snakeBackgroundIcon, 139, 143, 622, 400);
    SetImagePosition difWordL = new SetImagePosition(difWord, 132, 550, 636, 70);
    SetImagePosition sizeWordL = new SetImagePosition(sizeWord, 87, 700, 726, 70);
}
