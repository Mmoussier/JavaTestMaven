package com.morgann.xml.itunes;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

// tentative de désérialisation de la librairie iTunes, mais impossible car pas de balise pour encadrer les listes
// si plusieurs fois <key>, la dernière valeur lue écrase la précédente
public class itunes {
    public static void main(String[] args) {
        File xmlFile = new File("src/main/resources/iTunesTest.xml");
        XmlMapper xmlMapper = new XmlMapper();
        try {
            String xml = inputStreamToString(new FileInputStream(xmlFile));
            Library library = xmlMapper.readValue(xml, Library.class);
            System.out.println(library.getDict().getKey1().getValue());
            //System.out.println(modele.toSring());
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
