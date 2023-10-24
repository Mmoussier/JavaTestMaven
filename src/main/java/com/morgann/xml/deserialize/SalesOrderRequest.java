package com.morgann.xml.deserialize;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class SalesOrderRequest {

    // Les annotations JsonProperty suffisent pour la désérialisation
    // Les setters suffisent pour la désérialisation

    @JsonProperty("customerReference")
    private String customerReference;
    @JsonProperty("customerRemark")
    private String customerRemark;

    @JsonProperty("salesOrderLines") // suffit pour désérialiser la liste
    private List<SalesOrderLine> salesOrderLines = new ArrayList<>();

    @JsonProperty("salesShippingLines")
    private List<SalesShippingLine> salesShippingLines = new ArrayList<>();

    public String getCustomerReference() {
        return customerReference;
    }

    public void setCustomerReference(String customerReference) {
        this.customerReference = customerReference;
    }

//    public String getCustomerRemark() {
//        return customerRemark;
//    }

    public void setCustomerRemark(String customerRemark) {
        this.customerRemark = customerRemark;
    }

    public int GetNbSalesOrderLines() {
        return salesOrderLines.size();
    }

    public int GetNbSalesShippingLines() {
        return salesShippingLines.size();
    }

    public List<SalesOrderLine> getSalesOrderLines() {
        return salesOrderLines;
    }

    public List<SalesShippingLine> getSalesShippingLines() {
        return salesShippingLines;
    }

    public String toString() {
        return customerReference + " - " + customerRemark;
    }
}
