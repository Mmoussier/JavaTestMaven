package com.morgann.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Base64;

/**
 * Created by morgannm on 11/03/2016.
 * - Lit un fichier XML et extrait un attribut contenant une image codée en Base64
 * - Décode la chaîne représentant l'image sous la forme d'un tableau de byte et l'enregistre dans un fichier jpg
 */
public class ReadXmlDom {
    public static void main(String[] arguments) {
        try {
            File fXmlFile = new File("src/main/resources/Box.xml");
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = null;
            try {
                builder = builderFactory.newDocumentBuilder();
            }
            catch(ParserConfigurationException e) {
                e.printStackTrace();
                System.exit(1);
            }
            Document xmlDoc = builder.parse(fXmlFile);
            Element root = xmlDoc.getDocumentElement();
            System.out.println("Root element : " + root.getNodeName());
            NamedNodeMap nodeMap = root.getAttributes();
            for (int i=0; i<nodeMap.getLength(); i++) {
                Node node = nodeMap.item(i);
                if (node.getNodeName() == "boxImage"){
                    // Récupère l'image encodée en Base64 (https://en.wikipedia.org/wiki/Base64)
                    String sImage = node.getNodeValue();
                    System.out.println(sImage);

                    // Décode l'image et l'enregistre dans un fichier jpeg
                    byte[] decoded = Base64.getDecoder().decode(sImage);
                    InputStream in = new ByteArrayInputStream(decoded);
                    BufferedImage bImageFromConvert = ImageIO.read(in);
                    ImageIO.write(bImageFromConvert, "jpg", new File("d:/temp/new-imposition1.jpg"));
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
