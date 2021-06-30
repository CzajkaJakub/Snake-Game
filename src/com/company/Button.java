package com.company;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {

    protected String name;

    Button(String name, int x, int y){
        this.name = name;
        this.setFocusable(false);
        this.setText(name);
        this.setBounds(x, y, 200, 40);
        this.setFont(new Font("MV Boli", Font.BOLD, 40));
        this.setBackground(Color.black);
        this.setForeground(Color.green);
        this.setBorderPainted(false);
        this.setForeground(new Color(18, 131, 14));
        this.setContentAreaFilled(false);

    }

    Button(String name, int x, int y, int w){
        this.name = name;
        this.setFocusable(false);
        this.setText(name);
        this.setBounds(x, y, w, 40);
        this.setFont(new Font("MV Boli", Font.BOLD, 40));
        this.setBackground(Color.black);
        this.setForeground(Color.green);
        this.setBorderPainted(false);
        this.setForeground(new Color(18, 131, 14));
        this.setContentAreaFilled(false);
    }

}
