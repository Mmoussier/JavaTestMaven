package com.morgann.swinglab;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class DisplayBase64Image extends JFrame implements ActionListener {
    private JLabel imageLabel;
    private JTextArea base64TextArea;
    private JButton afficherButton;

    public DisplayBase64Image() {
        super("Décodage d'une image codée en Base64");
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
        base64TextArea = new JTextArea(8,40);
        base64TextArea.setPreferredSize(new Dimension(600,120));
        base64TextArea.setLineWrap(true);
//        base64TextArea.setText("iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAABHNCSVQICAgIfAhkiAAAAAlwSFlzAAAApgAAAKYB3X3/OAAAABl0RVh0U29mdHdhcmUAd3d3Lmlua3NjYXBlLm9yZ5vuPBoAAANCSURBVEiJtZZPbBtFFMZ/M7ubXdtdb1xSFyeilBapySVU8h8OoFaooFSqiihIVIpQBKci6KEg9Q6H9kovIHoCIVQJJCKE1ENFjnAgcaSGC6rEnxBwA04Tx43t2FnvDAfjkNibxgHxnWb2e/u992bee7tCa00YFsffekFY+nUzFtjW0LrvjRXrCDIAaPLlW0nHL0SsZtVoaF98mLrx3pdhOqLtYPHChahZcYYO7KvPFxvRl5XPp1sN3adWiD1ZAqD6XYK1b/dvE5IWryTt2udLFedwc1+9kLp+vbbpoDh+6TklxBeAi9TL0taeWpdmZzQDry0AcO+jQ12RyohqqoYoo8RDwJrU+qXkjWtfi8Xxt58BdQuwQs9qC/afLwCw8tnQbqYAPsgxE1S6F3EAIXux2oQFKm0ihMsOF71dHYx+f3NND68ghCu1YIoePPQN1pGRABkJ6Bus96CutRZMydTl+TvuiRW1m3n0eDl0vRPcEysqdXn+jsQPsrHMquGeXEaY4Yk4wxWcY5V/9scqOMOVUFthatyTy8QyqwZ+kDURKoMWxNKr2EeqVKcTNOajqKoBgOE28U4tdQl5p5bwCw7BWquaZSzAPlwjlithJtp3pTImSqQRrb2Z8PHGigD4RZuNX6JYj6wj7O4TFLbCO/Mn/m8R+h6rYSUb3ekokRY6f/YukArN979jcW+V/S8g0eT/N3VN3kTqWbQ428m9/8k0P/1aIhF36PccEl6EhOcAUCrXKZXXWS3XKd2vc/TRBG9O5ELC17MmWubD2nKhUKZa26Ba2+D3P+4/MNCFwg59oWVeYhkzgN/JDR8deKBoD7Y+ljEjGZ0sosXVTvbc6RHirr2reNy1OXd6pJsQ+gqjk8VWFYmHrwBzW/n+uMPFiRwHB2I7ih8ciHFxIkd/3Omk5tCDV1t+2nNu5sxxpDFNx+huNhVT3/zMDz8usXC3ddaHBj1GHj/As08fwTS7Kt1HBTmyN29vdwAw+/wbwLVOJ3uAD1wi/dUH7Qei66PfyuRj4Ik9is+hglfbkbfR3cnZm7chlUWLdwmprtCohX4HUtlOcQjLYCu+fzGJH2QRKvP3UNz8bWk1qMxjGTOMThZ3kvgLI5AzFfo379UAAAAASUVORK5CYII=");
//        base64TextArea.setText("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");
        base64TextArea.setText("/9j/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAAUCAAZABkEASIAAhEBAxEBBCIA/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADgQBAAIRAxEEAAA/APeLy+tNOtnub25htoE+9JM4RR+JrnZvH+ixtthS9uR/ejtmVT7gvtBHuM1q69bwyaZLLJZaddPEpZRfkLEvuWKtgfhXj3h9Q1nc3y26W0l1K0jQwARxKfu/u0H8BAyPXOT1rKtU9nG6LhHmdj3+iiivVdP8aaJqFzHbCeS2uJDtSO6iMe8+isflY+wJNdBXgFtDc3l7daZZu+q3d2RttV5itl6bmbHyr37egGeT6J/whvif/ob7j/vk/wCNOlNzWoTjyhRRRV3Xfh/aa/fC6udY1dCDlYVnVolPqEZSAfeq0Xwu0ct/p1/qt+neKe52p+SBa7eiqcU3doSk1swoooqnpuk6fo1qLbTbKC1hzkrEgXJ9T6n3NXKKKokKKKK//9k=");
        commandPanel.add(base64TextArea);
        afficherButton = new JButton("Afficher");
        afficherButton.setPreferredSize(new Dimension(100,20));
        afficherButton.addActionListener(this);
        commandPanel.add(afficherButton);
        add(commandPanel,BorderLayout.SOUTH);

        setVisible(true);

    }

    public static void main(String[] args) {
        DisplayBase64Image di = new DisplayBase64Image();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == afficherButton) {
            String sImage = base64TextArea.getText();
            byte[] decoded = Base64.getDecoder().decode(sImage);
            InputStream in = new ByteArrayInputStream(decoded);
            BufferedImage img = null;
            try {
                img = ImageIO.read(in);
                Image scaledImage = img.getScaledInstance(25,25,Image.SCALE_DEFAULT);
                ImageIcon icon = new ImageIcon(scaledImage);
                imageLabel.setIcon(icon);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
    }
}
