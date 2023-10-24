package com.morgann.images;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

// Combiner 2 images en une seule
public class Combine2Images extends JFrame {
    JLabel imageLabel;

    public Combine2Images() {
        super("Chargement d'une image à partir d'un fichier sélectionné");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // pour centrer la fenêtre
        setLayout(new BorderLayout());

        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new FlowLayout());
        imageLabel = new JLabel();
        imageLabel.setLayout(new FlowLayout());
        imageLabel.setPreferredSize(new Dimension(400,400));

        try {
            String file1 = "NYR_25px.png";
            BufferedImage img1= ImageIO.read(ClassLoader.getSystemResourceAsStream(file1));
            String file2 = "VGK_25px.png";
            BufferedImage img2 = ImageIO.read(ClassLoader.getSystemResourceAsStream(file2));
            BufferedImage img3 = new BufferedImage(50,25,BufferedImage.TYPE_INT_RGB);
            Graphics g = img3.getGraphics();
            g.drawImage(img1, 0, 0, null);
            g.drawImage(img2, 26, 0, null);
            Image scaledImage = img3.getScaledInstance(50, 25, Image.SCALE_DEFAULT);
            ImageIcon icon = new ImageIcon(scaledImage);
            imageLabel.setIcon(icon);
        } catch (IOException ex) {

        }

        imagePanel.add(imageLabel);
        add(imagePanel,BorderLayout.CENTER);

        setVisible(true);

    }

    public static void main(String[] args) {
        Combine2Images combine2Images = new Combine2Images();
    }
}
