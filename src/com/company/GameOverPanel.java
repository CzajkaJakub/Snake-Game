package com.company;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameOverPanel extends JPanel {

    final private static ImageIcon snakeBackgroundIcon = new ImageIcon("images/snakeBackgroundImage.png");
    final private static PreImage snakeImage = new PreImage(snakeBackgroundIcon, 139, 180, 622, 400);

    final private static ImageIcon gameOver = new ImageIcon("images/gameOver.png");
    final private static PreImage gameOverImage = new PreImage(gameOver, 222, 20, 457, 90);

    final private static ImageIcon applesEatenI = new ImageIcon("images/applesEaten.png");
    final private static PreImage applesEatenImage = new PreImage(applesEatenI, 50, 630, 538, 101);

    final private static ImageIcon playAgain = new ImageIcon("images/playAgain.png");

    GameOverPanel(Integer applesEaten, String gameSize, String level) throws IOException {
        JButton playAgainButton = makePlayAgainButton();
        JButton score = new Button(applesEaten.toString(), 620, 650);
        score.setBounds(600, 630, 200, 101);
        score.setFont(new Font("MV Boli", Font.BOLD, 95));
        this.setBackground(Color.black);
        this.setBounds(0,0,900, 900);
        this.setLayout(new BorderLayout());
        this.add(snakeImage);
        this.add(applesEatenImage);
        this.add(gameOverImage);
        this.add(score);
        this.add(playAgainButton);
        new SaveRecord(applesEaten, gameSize, level);
    }

    private static JButton makePlayAgainButton(){
        JButton playAgainButton = new JButton();
        playAgainButton.setBounds(230, 765, 440, 101);

        playAgainButton.addActionListener(e -> {
            try {
                playAgainButt();
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException unsupportedAudioFileException) {
                unsupportedAudioFileException.printStackTrace();
            }
        });

        playAgainButton.setFocusable(false);
        playAgainButton.setIcon(playAgain);
        playAgainButton.setBackground(Color.black);
        playAgainButton.setContentAreaFilled(false);
        playAgainButton.setBorderPainted(false);
        return playAgainButton;
    }


    private static void playAgainButt() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        MusicPanel.stopPlayingGameOverMusic();
    }
}
