package com.coding;

public class ProductData  extends Data{
    private String productName;

    public ProductData(String id, String productName) {
        super(id);
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return "ProductData [id=" + getId() + ", productName=" + productName + "]";
    }
}
