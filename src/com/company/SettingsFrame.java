package com.company;

import javax.swing.*;
import java.util.Locale;

public class SettingsFrame {

    final static protected String[] levels = {"easy", "medium", "hard"};
    final static protected String[] units = {"small", "medium", "big", "huge"};
    private static String userLevel;
    private static String userUnits;


    SettingsFrame() {
        setUserLevel();
        setUserUnit();
    }

    private void setUserLevel() {
        userLevel = JOptionPane.showInputDialog("Type a level of difficulty: (easy, medium, hard) ").toLowerCase(Locale.ROOT);
        if (!checkLevels()) {
            JOptionPane.showMessageDialog(null, "Wrong data entered, please try again!");
            setUserLevel();
        }

    }

    private void setUserUnit() {
        userUnits = JOptionPane.showInputDialog("Type a level of difficulty: (small, medium, big, huge) ").toLowerCase(Locale.ROOT);
        if (!checkUnits()) {
            JOptionPane.showMessageDialog(null, "Wrong data entered, please try again!");
            setUserUnit();
        }
    }

    private boolean checkLevels() {
        for (String i : levels) {
            if (i.equals(userLevel)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkUnits() {
        for (String i : units) {
            if (i.equals(userUnits)) {
                return true;
            }
        }
        return false;
    }

    public String getUserLevel() { return userLevel;}

    public String getUserUnit() { return userUnits;}

}