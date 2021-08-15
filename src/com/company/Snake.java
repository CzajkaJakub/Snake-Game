package com.company;

import com.company.GameFrame.GameFrame;
import com.company.SettingsFrame.SettingsFrame;

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

