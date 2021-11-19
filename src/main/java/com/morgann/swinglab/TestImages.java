package com.morgann.swinglab;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
            // Charge une image à partir d'un fichier
            BufferedImage bImage = ImageIO.read(new File(IMG_PATH));
            ImageIcon icon = new ImageIcon(bImage);
            JLabel label = new JLabel(icon);
            label.setPreferredSize(new Dimension(600, 400));
            JOptionPane.showMessageDialog(null, label);

            // Convertit l'image en tableau de Byte
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "jpg", bos );
            byte [] data = bos.toByteArray();

            // Enregistre l'image depuis le tableau de Byte vers un fichier
            ByteArrayInputStream bis = new ByteArrayInputStream(data);
            BufferedImage bImage2 = ImageIO.read(bis);
            ImageIO.write(bImage2, "jpg", new File("output.jpg") );
            System.out.println("image created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}