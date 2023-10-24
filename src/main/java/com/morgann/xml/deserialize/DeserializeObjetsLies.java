package com.morgann.xml.deserialize;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

// Désérialisation d'objets se faisant référence
public class DeserializeObjetsLies {
    public static void main(String[] args) {
        File xmlFile = new File("src/main/resources/CreateOrder_Devis_ElemStd.xml");
        XmlMapper xmlMapper = new XmlMapper();
        try {
            String xml = inputStreamToString(new FileInputStream(xmlFile));
            SalesOrderRequest salesOrderRequest = xmlMapper.readValue(xml, SalesOrderRequest.class);
            System.out.println("Customer Reference : " + salesOrderRequest.getCustomerReference());
            System.out.println("Nb SalesOrderLines : " + salesOrderRequest.GetNbSalesOrderLines());
            for (SalesOrderLine salesOrderLine : salesOrderRequest.getSalesOrderLines()) {
                System.out.println("Id SalesOrderLine : " + salesOrderLine.getId());
            }
            System.out.println("Nb SalesShippingLines : " + salesOrderRequest.GetNbSalesShippingLines());
            for (SalesShippingLine salesShippingLine : salesOrderRequest.getSalesShippingLines()) {
                System.out.println("Delivery Date : " + salesShippingLine.getDeliveryDate());
                System.out.println("SalesOrderLine id : " + salesShippingLine.getSalesOrderLine().getId());
                System.out.println("SalesOrderLine orderQuantity: " + salesShippingLine.getSalesOrderLine().getOrderQuantity());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private static String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

}
