package com.morgann.xml.jackson;

import java.util.List;

public class EstimateDetails {
    private String ref;
//    @JacksonXmlElementWrapper(localName = "Elements") // sérialisation en XML : nom du nœud qui contient la liste
//    @JacksonXmlProperty(localName = "ElementDetails") // sérialisation en XML : nom du nœud de chaque élément de la liste
    private List<ElementDetails> elements = null;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public List<ElementDetails> getElements() {
        return elements;
    }

    public void setElements(List<ElementDetails> elements) {
        this.elements = elements;
    }
}
