package com.company;

import javax.swing.*;

public class PreImage extends JLabel {
    PreImage(ImageIcon icon, int x, int y, int width, int height){
        this.setIcon(icon);
        this.setBounds(x, y, width, height);
    }
}
