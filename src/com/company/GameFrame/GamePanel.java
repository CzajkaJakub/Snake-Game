package com.company.GameFrame;


import com.company.GameOverFrame.GameOverPanel;
import com.company.Music.MusicPanel;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;


public class GamePanel extends JPanel implements ActionListener, Levels {
    private final int screenWidth = 900;
    private final int screenHeight = 900;
    private BufferedImage appleImage;
    private BufferedImage snakeHeadImageR;
    private BufferedImage snakeHeadImageD;
    private BufferedImage snakeHeadImageL;
    private BufferedImage snakeHeadImageU;
    private int unitSize;
    private int delay;
    private int bodyParts = 6;
    private int[] x;
    private int[] y;
    private int applesEaten;
    private int appleX;
    private int appleY;
    private String level;
    private String gameSize;
    private char direction = 'R';
    private boolean running = false;
    private Timer timer;
    private Random random;

    public GamePanel(String level, String units) throws IOException {
        frameSettings();
        settingsPanel(level, units);
    }

    private void frameSettings(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
    }


    public void settingsPanel(String lev, String units) throws IOException {
        gameSize = units;
        level = lev;
        delay = levels.get(level);
        unitSize = gameUnit.get(units);
        int gameUnits = (screenWidth * screenHeight) / unitSize;
        x = new int[gameUnits];
        y = new int[gameUnits];
        random = new Random();
        startGame();

    }

    public void readImages() throws IOException {
        appleImage = ImageIO.read(new File("resources/images/AppleImages/apple" + unitSize +".png"));
        snakeHeadImageR = ImageIO.read((new File("resources/images/SnakeHeadImages/" + unitSize + "px/" + "snakeHeadR" + unitSize + ".png")));
        snakeHeadImageD = ImageIO.read((new File("resources/images/SnakeHeadImages/" + unitSize + "px/" + "snakeHeadD" + unitSize + ".png")));
        snakeHeadImageL = ImageIO.read((new File("resources/images/SnakeHeadImages/" + unitSize + "px/" + "snakeHeadL" + unitSize + ".png")));
        snakeHeadImageU = ImageIO.read((new File("resources/images/SnakeHeadImages/" + unitSize + "px/" + "snakeHeadU" + unitSize + ".png")));
    }

    public void startGame() throws IOException {
        MusicPanel.playBackgroundMusic();
        readImages();
        newApple();
        running = true;
        timer = new Timer(delay, this);
        timer.start();
    }


    public void draw(Graphics g) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        if(running) {
            g.drawImage(appleImage, appleX, appleY, this);
            for (int i = 0; i < bodyParts; i++){
                if(i == 0){
                    switch (direction) {
                        case 'R' -> g.drawImage(snakeHeadImageR, x[i], y[i], this);
                        case 'D' -> g.drawImage(snakeHeadImageD, x[i], y[i], this);
                        case 'L' -> g.drawImage(snakeHeadImageL, x[i], y[i], this);
                        case 'U' -> g.drawImage(snakeHeadImageU, x[i], y[i], this);
                    }
                }
                else{
                    g.setColor(new Color(29, 109, 0));
                    g.fillOval(x[i], y[i], unitSize, unitSize);
                }
            }
        }
        else{
            gameOver();
        }
    }

    public void newApple(){
        appleY = random.nextInt((screenWidth/unitSize))*unitSize;
        appleX = random.nextInt((screenHeight/unitSize))*unitSize;
    }

    public void move(){
        for(int i=bodyParts; i>0; i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        switch (direction) {
            case 'U' -> y[0] = y[0] - unitSize;
            case 'D' -> y[0] = y[0] + unitSize;
            case 'L' -> x[0] = x[0] - unitSize;
            case 'R' -> x[0] = x[0] + unitSize;
        }
    }

    public void checkPoint() throws LineUnavailableException, IOException, InterruptedException, UnsupportedAudioFileException {
        if((x[0] == appleX)&&(y[0] == appleY)){
            newApple();
            makeCollectSound();
            applesEaten ++;
            bodyParts ++;
        }
    }



    public void checkCollision() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        for(int i= bodyParts; i>0; i--){
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
                break;
            }

            if(x[0] < 0){
                running = false;
                break;
            }
            if(x[0] > screenWidth){
                running = false;
                break;
            }
            if(y[0] < 0){
                running = false;
                break;
            }
            if(y[0] > screenHeight){
                running = false;
                break;
            }
        }
        if(!running){
            timer.stop();
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        try {
            draw(g);
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public void makeCollectSound(){
        MusicPanel.playPointCollectMusic();
    }

    public void gameOver() throws IOException{
        MusicPanel.playGameOverMusic();
        this.add(new GameOverPanel(applesEaten, gameSize, level));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            move();
            try {
                checkPoint();
            } catch (LineUnavailableException | IOException | InterruptedException | UnsupportedAudioFileException lineUnavailableException) {
                lineUnavailableException.printStackTrace();
            }
            try {
                checkCollision();
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException unsupportedAudioFileException) {
                unsupportedAudioFileException.printStackTrace();
            }
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (direction != 'R') {
                    direction = 'L';
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (direction != 'L') {
                    direction = 'R';
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (direction != 'D') {
                    direction = 'U';
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (direction != 'U') {
                    direction = 'D';
                }
            }
        }
    }

}

