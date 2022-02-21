package com.wiley.davin.shoppingcart;

public class Customer {
    private long custsomerId;
    private String customerName;
    //cart starts with size 0 but is increased dynamically later
    private Product cart[] = new Product[0];

    public Customer() {
        System.out.println("Customer class constructor w No Args");
    }

    public Customer(long id, String name) {
        this.custsomerId = id;
        this.customerName = name;
        System.out.println("Created New Customer with id: " + this.custsomerId + ", name " + this.customerName);
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String name) {
        this.customerName = name;
    }

    public void addToCart(Product newProduct) {
        this.cart = addElement(this.cart, newProduct);
        System.out.println("Added item to your cart: " + newProduct.getProductName());
    }

    // array helper method, which also increase size of cart array
    private Product[] addElement(Product[] cartArray, Product newElement) {
        Product[] biggerCartArray = new Product[cartArray.length + 1];
        System.arraycopy(cartArray, 0, biggerCartArray, 0, cartArray.length);
        biggerCartArray[cartArray.length] = newElement;
        return biggerCartArray;
    }

    // display contents of cart, plus number of items and total cost
    public void displayCart() {
        System.out.println("Your cart contains " + this.cart.length + " items:" );
        int totalCost = 0;
        if (this.cart == null || this.cart.length == 0) {
            System.out.println("\tYour cart is currently empty");
        } else {
            for (int i = 0; i < cart.length; i++) {
                System.out.println(cart[i].toString());
                totalCost += cart[i].getProductPrice();
            }
            System.out.println("Total Cost of Products in your Cart: $" + totalCost);
        }
    }
}
