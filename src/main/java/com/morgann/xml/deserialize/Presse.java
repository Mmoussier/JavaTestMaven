package com.morgann.xml.deserialize;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Presse {
    @JacksonXmlProperty(localName = "ID", isAttribute = true)
    private int id;
    @JacksonXmlProperty(localName = "LargeurImpMax", isAttribute = true)
    private int LargeurImpMax;
    @JacksonXmlProperty(localName = "HauteurImpMax", isAttribute = true)
    private int HauteurImpMax;
    @JacksonXmlProperty(localName = "CoutPlaque", isAttribute = true)
    private float CoutPlaque;
    @JacksonXmlProperty(localName = "CoutImpression", isAttribute = true)
    private float CoutImpression;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLargeurImpMax() {
        return LargeurImpMax;
    }

    public void setLargeurImpMax(int largeurImpMax) {
        LargeurImpMax = largeurImpMax;
    }

    public int getHauteurImpMax() {
        return HauteurImpMax;
    }

    public void setHauteurImpMax(int hauteurImpMax) {
        HauteurImpMax = hauteurImpMax;
    }

    public float getCoutPlaque() {
        return CoutPlaque;
    }

    public void setCoutPlaque(float coutPlaque) {
        CoutPlaque = coutPlaque;
    }

    public float getCoutImpression() {
        return CoutImpression;
    }

    public void setCoutImpression(float coutImpression) {
        CoutImpression = coutImpression;
    }

    public String toSring() {
        return "Presse : ID=" + getId() + ", LargeurImpMax=" + getLargeurImpMax() + ", HauteurImpMax=" + getHauteurImpMax();
    }
}
