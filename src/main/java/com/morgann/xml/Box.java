package com.morgann.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by morgannm on 11/03/2016.
 */
@XmlRootElement(name = "Box")
public class Box {
    @XmlAttribute(name = "A")
    private double a;
    @XmlAttribute
    private double b;
    @XmlAttribute
    private double h;
    @XmlAttribute
    private double sizeX;
    @XmlAttribute
    private double sizeY;
    @XmlAttribute
    private byte[] boxImage;

    /**
     * @return the a
     */
    @XmlTransient
    public double getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(double a) {
        this.a = a;
    }

    /**
     * @return the b
     */
    @XmlTransient
    public double getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(double b) {
        this.b = b;
    }

    /**
     * @return the h
     */
    @XmlTransient
    public double getH() {
        return h;
    }

    /**
     * @param h the h to set
     */
    public void setH(double h) {
        this.h = h;
    }

    /**
     * @return the sizeX
     */
    @XmlTransient
    public double getSizeX() {
        return sizeX;
    }

    /**
     * @param sizeX the sizeX to set
     */
    public void setSizeX(double sizeX) {
        this.sizeX = sizeX;
    }

    /**
     * @return the sizeY
     */
    @XmlTransient
    public double getSizeY() {
        return sizeY;
    }

    /**
     * @param sizeY the sizeY to set
     */
    public void setSizeY(double sizeY) {
        this.sizeY = sizeY;
    }

    /**
     * @return the image of the box.
     */
    @XmlTransient
    public byte[] getBoxImage() {
        return boxImage;
    }

    public void setBoxImage(byte[] boxImage) {
        this.boxImage = boxImage;
    }

}

