package com.morgann.xml.deserialize;

import com.fasterxml.jackson.annotation.*;
import java.util.Date;

public class SalesShippingLine {
    @JsonProperty(value = "salesOrderLineId")
    private SalesOrderLine salesOrderLine;

    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
    private Date deliveryDate;

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public SalesOrderLine getSalesOrderLine() {
        return salesOrderLine;
    }
}
