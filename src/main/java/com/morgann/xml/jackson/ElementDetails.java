package com.morgann.xml.jackson;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.xml.bind.annotation.XmlRootElement;

// @JsonTypeInfo indique sur quelle propriété on se base pour déterminer le type d'objet à créer lors de la désérialisation
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "elementType")
// Si elementType="LABEL" : on crée un objet LabelElementDetails
// Si elementType="SHEET" : on crée un objet ElementDetails
@JsonSubTypes({@JsonSubTypes.Type(value = LabelElementDetails.class, name = "LABEL"),
        @JsonSubTypes.Type(value = ElementDetails.class, name = "SHEET")})
@XmlRootElement(name = "elementDetails")
public class ElementDetails {
    private String elementType;
    private double width;
    private double height;

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
