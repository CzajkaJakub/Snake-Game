package com.company.SettingsFrame;

import com.company.*;
import com.company.ImagesSet.ImageFiles;
import com.company.Music.MusicPanel;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SettingsFrame extends JFrame implements ButtonTypes, ImageFiles {

    private String userLevel;
    private String userUnits;
    private Button pressedLevel = easyLevel;
    private Button pressedSize = smallWindow;

    public SettingsFrame(){
        MusicPanel.playSnakeSong();
        setSettingsFrame();
        listeners();
    }

    private void setSettingsFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 900);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Snake Game");
        this.getContentPane().setBackground(Color.BLACK);
        this.setIconImage(windowIcon.getImage());
        this.setLayout(null);
        this.add(backGround);
        this.add(snakeImage);
        this.add(difWordL);
        this.add(easyLevel);
        this.add(mediumLevel);
        this.add(hardLevel);
        this.add(smallWindow);
        this.add(mediumWindow);
        this.add(hugeWindow);
        this.add(startButton);
        this.add(sizeWordL);
        this.setVisible(true);
    }

    private void setUserLevel(Button button) {
        userLevel = button.name.toLowerCase();
        pressedLevel.setEnabled(true);
        pressedLevel = button;
        button.setEnabled(false);
    }

    private void setUserUnit(Button button) {
        userUnits = button.name.toLowerCase();
        pressedSize.setEnabled(true);
        pressedSize = button;
        button.setEnabled(false);
    }

    public String getUserLevel() {
        return userLevel;
    }

    public String getUserUnit() {
        return userUnits;
    }

    public void startGameButton() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        if (!(userLevel == null || userUnits == null)){
            MusicPanel.stopSnakeSong();
            Snake.startGame(getUserLevel(), getUserUnit(), this);
        }
    }


    public void listeners(){
        easyLevel.addActionListener(e -> setUserLevel(easyLevel));
        mediumLevel.addActionListener(e -> setUserLevel(mediumLevel));
        hardLevel.addActionListener(e -> setUserLevel(hardLevel));
        smallWindow.addActionListener(e -> setUserUnit(smallWindow));
        mediumWindow.addActionListener(e -> setUserUnit(mediumWindow));
        hugeWindow.addActionListener(e -> setUserUnit(hugeWindow));
        startButton.addActionListener(e -> {
            try {
                startGameButton();
            } catch (IOException | UnsupportedAudioFileException | LineUnavailableException ioException) {
                ioException.printStackTrace();
            }
        });
    }

}