package com.morgann.xml.deserialize;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

public class Modeles {
    @JacksonXmlProperty(localName = "Modele")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Modele> modeles = new ArrayList<>();

    public List<Modele> getModeles() {
        return modeles;
    }

    public void setModeles(List<Modele> modeles) {
        this.modeles = modeles;
    }
}
