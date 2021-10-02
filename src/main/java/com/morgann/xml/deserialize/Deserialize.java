package com.morgann.xml.deserialize;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.awt.event.MouseListener;
import java.io.*;

// Désérialisation de fichiers XML avec jackson
public class Deserialize {
    public static void main(String[] args) {
        // 1 - désérialisation d'un fichier dans un objet
        System.out.println("1 - désérialisation d'un fichier dans un objet");
        File xmlFile = new File("src/main/resources/Modele.xml");
        XmlMapper xmlMapper = new XmlMapper();
        try {
            String xml = inputStreamToString(new FileInputStream(xmlFile));
            Modele modele = xmlMapper.readValue(xml, Modele.class);
            System.out.println(modele.toSring());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // 2 - désérialisation d'un fichier dans un objet contenant une liste d'objets
        System.out.println("2 - désérialisation d'un fichier dans un objet contenant une liste d'objets");
        xmlFile = new File("src/main/resources/Modeles.xml");
        try {
            String xml = inputStreamToString(new FileInputStream(xmlFile));
            Modeles modeles = xmlMapper.readValue(xml, Modeles.class);
            for(Modele modele : modeles.getModeles()) {
                System.out.println(modele.toSring());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // 3 - désérialisation d'un fichier dans un objet contenant plusieurs listes d'objets
        System.out.println("3 - désérialisation d'un fichier dans un objet contenant plusieurs listes d'objets");
        xmlFile = new File("src/main/resources/ProblemeAmalgame.xml");
        try {
            String xml = inputStreamToString(new FileInputStream(xmlFile));
            ProblemeAmalgame problemeAmalgame = xmlMapper.readValue(xml, ProblemeAmalgame.class);
            for(Modele modele : problemeAmalgame.getModeles()) {
                System.out.println(modele.toSring());
            }
            for(Presse presse : problemeAmalgame.getPresses()) {
                System.out.println(presse.toSring());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}
