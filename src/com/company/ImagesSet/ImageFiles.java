package com.company.ImagesSet;

import javax.swing.*;

public interface ImageFiles {
    ImageIcon windowIcon = new ImageIcon("resources/images/GameIcon/snake.png");
    ImageIcon snakeBackgroundIcon = new ImageIcon("resources/images/SnakeImage/snakeBackgroundImage.png");
    ImageIcon snakeWord = new ImageIcon("resources/images/Inscriptions/snakeWord.png");
    ImageIcon difWord = new ImageIcon("resources/images/Inscriptions/difficultyWord.png");
    ImageIcon sizeWord = new ImageIcon("resources/images/Inscriptions/sizeWord.png");
    ImageIcon gameOver = new ImageIcon("resources/images/Inscriptions/gameOver.png");
    ImageIcon applesEatenI = new ImageIcon("resources/images/Inscriptions/applesEaten.png");

    SetImagePosition snakeImageGameOver = new SetImagePosition(snakeBackgroundIcon, 139, 260, 622, 400);
    SetImagePosition gameOverImage = new SetImagePosition(gameOver, 222, 50, 457, 90);
    SetImagePosition applesEatenImage = new SetImagePosition(applesEatenI, 50, 730, 538, 101);
    SetImagePosition backGround = new SetImagePosition(snakeWord, 283, 20, 333, 103);
    SetImagePosition snakeImage = new SetImagePosition(snakeBackgroundIcon, 139, 143, 622, 400);
    SetImagePosition difWordL = new SetImagePosition(difWord, 132, 550, 636, 70);
    SetImagePosition sizeWordL = new SetImagePosition(sizeWord, 87, 700, 726, 70);
}
