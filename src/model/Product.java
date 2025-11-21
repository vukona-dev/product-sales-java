/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Vukona-Maritz
 */

public class Product {
    private int barcodeNo;
    private String productName;
    private String productCategory;
    private String manufacturer;
    private int unitPrice;
    private double amountPaid;

    // Constructor with product category as 3rd parameter
    public Product(int barcodeNo, String productName, String productCategory, String manufacturer, int unitPrice, double amountPaid) {
        this.barcodeNo = barcodeNo;
        this.productName = productName;
        this.productCategory = productCategory;
        this.manufacturer = manufacturer;
        this.unitPrice = unitPrice;
        this.amountPaid = amountPaid;
    }

    // Getters
    public int getBarcodeNo() { return barcodeNo; }
    public String getProductName() { return productName; }
    public String getProductCategory() { return productCategory; }
    public String getManufacturer() { return manufacturer; }
    public int getUnitPrice() { return unitPrice; }
    public double getAmountPaid() { return amountPaid; }

    // toString method
    public String toString() {
        return "Barcode: " + barcodeNo +
               "\nProduct Name: " + productName +
               "\nProduct Category: " + productCategory +
               "\nManufacturer: " + manufacturer +
               "\nUnitPrice: " + unitPrice +
               "\nTotal Cost: " + amountPaid + "\n";
    }
}
