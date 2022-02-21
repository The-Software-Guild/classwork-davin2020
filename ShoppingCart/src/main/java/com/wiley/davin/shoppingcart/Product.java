package com.wiley.davin.shoppingcart;

public class Product {
    private long productId;
    private String productName;
    private double productPrice;

    public Product() {
        System.out.println("Product class constructor w No Args");
    }

    public Product(long id, String name, double price) {
        this.productId = id;
        this.productName = name;
        this.productPrice = price;
        //System.out.println("New Product created with id: " + this.productId + ", name " + this.productName + ", price $ " + this.productPrice);
    }

    public long getProductId() {
        return this.productId;
    }

    public void setProductId(long id) {
        this.productId = id;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String name) {
        this.productName = name;
    }

    public double getProductPrice() {
        return this.productPrice;
    }

    public void setProductPrice(double price) {
        this.productPrice = price;
    }

    public String toString() {
        String productString = "\tProduct Id: " + this.productId + " - Name: "+ this.productName + " - Price: $" + this.productPrice;
        return productString;
    }

}
