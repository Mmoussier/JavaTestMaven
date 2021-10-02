package com.morgann.xml.deserialize;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Modele {
    @JacksonXmlProperty(localName = "ID", isAttribute = true)
    private int id;
    @JacksonXmlProperty(localName = "Largeur", isAttribute = true)
    private int largeur;
    @JacksonXmlProperty(localName = "Hauteur", isAttribute = true)
    private int hauteur;
    @JacksonXmlProperty(localName = "Quantite", isAttribute = true)
    private int quantite;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String toSring() {
        return "Modèle : ID=" + getId() + ", Largeur=" + getLargeur() + ", Hauteur=" + getHauteur() + ", Quantité=" + getQuantite();
    }
}
