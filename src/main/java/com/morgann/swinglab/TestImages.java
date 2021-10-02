package com.morgann.swinglab;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Created by morgannm on 27/02/2016.
 * - Charge une image à partir d'un fichier et l'affiche
 */

public class TestImages {

    // *** your image path will be different *****
    private static final String IMG_PATH = "src/main/resources/martroi-64.jpg";

    public static void main(String[] args) {
        try {
            BufferedImage img = ImageIO.read(new File(IMG_PATH));
            ImageIcon icon = new ImageIcon(img);
            JLabel label = new JLabel(icon);
            label.setPreferredSize(new Dimension(600, 400));
            JOptionPane.showMessageDialog(null, label);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}