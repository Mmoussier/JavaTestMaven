package com.morgann.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

/**
 * Created by morgannm on 11/03/2016.
 */
public class Serialize {
    public static void main(String[] arguments) {
        Box box = new Box();
        box.setA(60);
        box.setB(20);
        box.setH(100);
        box.setBoxImage(getBytesFromFile("src/main/resources/imposition.jpg"));
        try {
            JAXBContext context = JAXBContext.newInstance(Box.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(box, System.out);
            //m.marshal(box, new File("D:\\Temp\\Box.xml")); // pour générer un fichier XML
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }

    private static byte[] getBytesFromFile(String path) {
        File file = new File(path);

        // lecture de l'image en byte[]
        InputStream is = null;
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("Error accessing the file" + e);
        }
        // Get the size of the file
        long length = file.length();
        // You cannot create an array using a long type.
        // It needs to be an int type.
        // Before converting to an int type, check
        // to ensure that file is not larger than Integer.MAX_VALUE.
        if (length > Integer.MAX_VALUE) {
            try {
                throw new IOException("File is too big " + file.getName());
            } catch (IOException e) {
                System.out.println("Error accessing the file" + e);
            }
        }
        // Create the byte array to hold the data
        byte[] bytes = new byte[(int) length];
        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        try {
            while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += numRead;
            }
        } catch (IOException e) {
            System.out.println("Error accessing the file" + e);
        }
        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            try {
                throw new IOException("Could not completely read file " + file.getName());
            } catch (IOException e) {
                System.out.println("Error accessing the file" + e);
            }
        }
        // Close the input stream and return bytes
        try {
            is.close();
        } catch (IOException e) {
            System.out.println("Error accessing the file" + e);
        }
        return bytes;
    }
}
