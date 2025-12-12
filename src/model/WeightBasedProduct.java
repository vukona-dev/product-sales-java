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

public class WeightBasedProduct extends Product {
    private int weight;

    public WeightBasedProduct(int barcodeNo, String productName, String productCategory, String manufacturer, int weight, int unitPrice, double amountPaid) {
        super(barcodeNo, productName, productCategory, manufacturer, unitPrice, amountPaid);
        this.weight = weight;
    }

    public int getWeight() { return weight; }

    @Override
    public String toString() {
        return "Barcode: " + getBarcodeNo() +
               "\nProduct Name: " + getProductName() +
               "\nProduct Category: " + getProductCategory() +
               "\nPrice: " + getUnitPrice() + "c/Kg" +
               "\nWeight: " + weight + "grams" +
               "\nTotal Cost: " + getAmountPaid() + "\n";
    }
}
