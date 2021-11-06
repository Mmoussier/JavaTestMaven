package com.morgann.swinglab;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoadImage extends JFrame implements ActionListener {
    JLabel imageLabel;
    JButton selectButton;

    private static final String IMG_PATH = "src/main/resources/Terre.jpg";

    public LoadImage() {
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
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.red));
        imagePanel.add(imageLabel);
        add(imagePanel,BorderLayout.CENTER);

        JPanel commandPanel = new JPanel();
        FlowLayout flo = new FlowLayout(FlowLayout.CENTER);
        commandPanel.setLayout(flo);
        selectButton = new JButton("Sélectionner");
        selectButton.setPreferredSize(new Dimension(150,20));
        selectButton.addActionListener(this);
        commandPanel.add(selectButton);
        add(commandPanel,BorderLayout.SOUTH);

        setVisible(true);

    }

    public static void main(String[] args) {
        LoadImage li = new LoadImage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == selectButton) {
            BufferedImage img = null;
            try {
                img = ImageIO.read(new File(IMG_PATH));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Image scaledImage = img.getScaledInstance(400,400,Image.SCALE_DEFAULT);
            ImageIcon icon = new ImageIcon(scaledImage);
            imageLabel.setIcon(icon);
        }
    }
}
