package com.morgann.xml.itunes;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("key")
public class Key {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Key(String value) {this.value = value;}
}
