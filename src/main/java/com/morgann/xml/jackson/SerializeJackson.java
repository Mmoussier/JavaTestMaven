package com.morgann.xml.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class SerializeJackson {
    public static void main(String[] args) {
        XmlMapper xmlMapper = new XmlMapper();

        // Désérialisation EstimateDetails avec LabelElementDetails
        String xmlIn = "<EstimateDetails><ref>ref devis</ref><elements><ElementDetails><elementType>SHEET</elementType><width>210.0</width><height>297.0</height></ElementDetails></elements></EstimateDetails>";
        try {
            // Désérialisation : XML -> objet
            EstimateDetails estimateDetails = xmlMapper.readValue(xmlIn, EstimateDetails.class);
            System.out.println(estimateDetails.getRef());
            // Sérialisation : objet -> XML
            String xmlOut = xmlMapper.writeValueAsString(estimateDetails);
            System.out.println(xmlOut);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        // Désérialisation EstimateDetails avec LabelElementDetails
        String xmlIn2 = "<EstimateDetails><ref>ref devis</ref><elements><ElementDetails><elementType>LABEL</elementType><width>200.0</width><height>150.0</height><presentation>0</presentation></ElementDetails></elements></EstimateDetails>";
        try {
            // Désérialisation EstimateDetails avec élément LabelElementDetails
            EstimateDetails estimateDetails = xmlMapper.readValue(xmlIn2, EstimateDetails.class);
            // estimateDetails.elements contient un objet de type LabelElementDetails
            System.out.println(estimateDetails.getRef());
            String xml = xmlMapper.writeValueAsString(estimateDetails);
            System.out.println(xml);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
