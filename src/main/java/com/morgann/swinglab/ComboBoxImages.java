package com.morgann.swinglab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by morgannm on 07/03/2016.
 * - ComboBox liée à des images
 */
public class ComboBoxImages implements ActionListener {
    private static final String IMG_PATH = "src/main/resources/";

    JLabel picture;

    public ComboBoxImages()
    {
        JFrame frame = new JFrame("JavaTestMaven - ComboBoxImages");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5)); // marge autour du Panel

        String[] planetesStrings = {"Mercure", "Venus", "Terre", "Mars", "Jupiter", "Saturne"};
        JComboBox planetes = new JComboBox(planetesStrings);
        planetes.addActionListener(this);

        panel.add(planetes,BorderLayout.PAGE_START);

        picture = new JLabel();

        picture.setHorizontalAlignment(JLabel.CENTER); // pour centrer horizontalement
        panel.add(picture,BorderLayout.CENTER);
        updatePicture("Mercure");

        panel.setOpaque(true); //content panes must be opaque
        panel.setPreferredSize(new Dimension(600, 400));
        frame.setContentPane(panel);

        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    /** Listens to the combo box. */
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String planete = (String)cb.getSelectedItem();
        updatePicture(planete);
    }

    public void updatePicture(String name)
    {
        String path = IMG_PATH + name + ".jpg";
//        ImageIcon img = new ImageIcon(path);
//        picture.setIcon(img);

        Image image = new ImageIcon(path).getImage();
        Image scaledImage = image.getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon icon=new ImageIcon(scaledImage);
        picture.setIcon(icon);
    }

    public static void main(String[] arguments) {
        ComboBoxImages app = new ComboBoxImages();
    }
}
