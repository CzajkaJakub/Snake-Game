package com.company;

import java.io.IOException;

public class Snake {
    public static void main(String[] args){
        new SettingsFrame();
    }

    public static void startGame(String level, String unit, SettingsFrame settingsFrame) throws IOException {
        settingsFrame.dispose();
        new GameFrame(level, unit);
    }
}

