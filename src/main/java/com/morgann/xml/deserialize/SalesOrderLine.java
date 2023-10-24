package com.morgann.xml.deserialize;

import com.fasterxml.jackson.annotation.*;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class SalesOrderLine {
    @JsonProperty("id")
    private String id;

    @JsonProperty("orderQuantity")
    private int orderQuantity;

    public String getId() {
        return id;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }
}
