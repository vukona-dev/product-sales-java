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

public class ItemBasedProduct extends Product {
    public ItemBasedProduct(int barcodeNo, String productName, String productCategory, String manufacturer, int unitPrice, double amountPaid) {
        super(barcodeNo, productName, productCategory, manufacturer, unitPrice, amountPaid);
    }

    @Override
    public String toString() {
        return super.toString(); // Same format as base class
    }
}

