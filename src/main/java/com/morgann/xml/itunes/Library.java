package com.morgann.xml.itunes;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonRootName("plist")
public class Library {
    private String version;
    private DictMain dict;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public DictMain getDict() {
        return dict;
    }

    public void setDict(DictMain dict) {
        this.dict = dict;
    }
}
