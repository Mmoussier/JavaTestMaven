package com.morgann.xml.deserialize;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

public class ProblemeAmalgame {
    @JacksonXmlProperty(localName = "Modeles")
    private List<Modele> modeles = new ArrayList<>();

    @JacksonXmlProperty(localName = "Presses")
    private List<Presse> presses = new ArrayList<>();

    public List<Modele> getModeles() {
        return modeles;
    }

    public void setModeles(List<Modele> modeles) {
        this.modeles = modeles;
    }

    public List<Presse> getPresses() {
        return presses;
    }

    public void setPresses(List<Presse> presses) {
        this.presses = presses;
    }

}
