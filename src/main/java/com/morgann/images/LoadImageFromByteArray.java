package com.morgann.images;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by morgannm on 11/03/2016.
 * - Charge un tableau de byte avec une image (fichier jpg)
 * - Convertit le tableau de byte en BufferedImage et l'enregistre dans un nouveau fichier
 */
public class LoadImageFromByteArray {
    public static void main(String[] args) {

        try {
            byte[] imageInByte;
            BufferedImage originalImage = ImageIO.read(new File("src/main/resources/imposition.jpg"));

            // convert BufferedImage to byte array
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(originalImage, "jpg", baos);
            baos.flush();
            imageInByte = baos.toByteArray();
            baos.close();

            // convert byte array back to BufferedImage
            InputStream in = new ByteArrayInputStream(imageInByte);
            BufferedImage bImageFromConvert = ImageIO.read(in);

            ImageIO.write(bImageFromConvert, "jpg", new File("d:/temp/new-imposition.jpg"));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
