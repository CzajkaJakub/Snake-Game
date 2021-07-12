package com.company.ImagesSet;

import javax.swing.*;

public class SetImagePosition extends JLabel {
    public SetImagePosition(ImageIcon icon, int x, int y, int width, int height){
        this.setIcon(icon);
        this.setBounds(x, y, width, height);
    }
}
