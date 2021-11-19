package com.morgann.xml.itunes;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

@JsonRootName("dict")
public class DictMain {
    @JacksonXmlProperty(localName = "key")
    private Key key1;

    //@JacksonXmlProperty(localName = "dict")
    private List<Key> keys = new ArrayList<>();

    public List<Key> getKeys() {
        return keys;
    }

    public void setKeys(List<Key> keys) {
        this.keys = keys;
    }

    public Key getKey1() {
        return key1;
    }

    public void setKey1(Key key1) {
        this.key1 = key1;
    }

    @JacksonXmlProperty(localName = "integer")
    private iTunesInteger integer1;

    public iTunesInteger getInteger1() {
        return integer1;
    }

    public void setInteger1(iTunesInteger integer1) {
        this.integer1 = integer1;
    }
}
