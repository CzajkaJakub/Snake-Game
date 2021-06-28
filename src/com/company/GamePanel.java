package com.company;


import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;


public class GamePanel extends JPanel implements ActionListener {

    private static final HashMap<String, Integer> levels = new HashMap<>(){{
        put("easy", 100);
        put("medium", 70);
        put("hard", 40);
    }};

    private static final HashMap<String, Integer> gameUnit = new HashMap<>(){{
        put("small", 75);
        put("medium", 45);
        put("big", 30);
        put("huge", 10);
    }};

    final static int screenWidth = 900;
    final static int screenHeight = 900;
    static int unitSize;
    static int gameUnits;
    static int delay;
    static int[] x;
    static int[] y;
    static int bodyParts = 6;
    static int applesEaten;
    static int appleX;
    static int appleY;
    static char direction = 'R';
    static boolean running = false;
    final MusicPanel music = new MusicPanel();
    Timer timer;
    Random random;

    GamePanel(SettingsFrame settingsFrame) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        settingsPanel(settingsFrame);

    }


    public void settingsPanel(SettingsFrame settingsFrame){
        delay = levels.get(settingsFrame.getUserLevel());
        unitSize = gameUnit.get(settingsFrame.getUserUnit());
        gameUnits = (screenWidth*screenHeight)/unitSize;
        x = new int[gameUnits];
        y = new int[gameUnits];
        random = new Random();
        startGame();

    }

    public void startGame(){
        newApple();
        running = true;
        timer = new Timer(delay, this);
        timer.start();
    }



    public void paintComponent(Graphics g){
        super.paintComponent(g);
        try {
            draw(g);
        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g) throws LineUnavailableException, IOException {
        if(running) {
            g.setColor(Color.red);
            g.fillOval(appleX, appleY, unitSize, unitSize);

            for (int i = 0; i < bodyParts; i++){
                if(i == 0){
                    g.setColor(Color.green);
                }
                else{
                    g.setColor(new Color(45, 180, 0));
                }
                g.fillRect(x[i], y[i], unitSize, unitSize);
            }
        }
        else{
            music.stopPlayBackgroundMusic();
            music.playGameOverMusic();
            gameOver(g);
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
            music.playPointCollectMusic();
            newApple();
            applesEaten ++;
            bodyParts ++;

        }
    }

    public void checkCollision(){
        for(int i= bodyParts; i>0; i--){
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
                break;
            }

            if(x[0] < 0){
                running = false;
            }
            if(x[0] > screenWidth){
                running = false;
            }
            if(y[0] < 0){
                running = false;
            }
            if(y[0] > screenHeight){
                running = false;
            }

            if(!running){
                timer.stop();
            }


        }
    }

    public void gameOver(Graphics g){
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over", (screenWidth - metrics.stringWidth("Game Over"))/2, screenHeight/2);
        String score = "Apples Eaten: " + applesEaten;
        g.setColor(Color.green);
        g.setFont(new Font("Ink Free", Font.BOLD, 50));
        g.drawString(score, (screenWidth - metrics.stringWidth(score))/2, screenHeight*2/3);
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
            checkCollision();
        }
        repaint();

    }

    public static class MyKeyAdapter extends KeyAdapter {
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

