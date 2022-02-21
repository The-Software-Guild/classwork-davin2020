package com.wiley.davin.shoppingcart;

import java.util.Scanner;

//FYI this program doesn't take stock levels into account
public class Main {
    public static Product availableProducts[] = new Product[4];
    static Scanner lineScanner = new Scanner(System.in);

    public static void main(String[] args) {
        //setup products that customer can buy
        Product p1 = new Product(1001, "iPhone", 700.00);
        Product p2 = new Product(1002, "Mac Book Pro", 2000.00);
        Product p3 = new Product(1003, "Lenovo Windows 10 Laptop", 1000.00);
        Product p4 = new Product(1004, "Samsung Android X20", 450.00);
        availableProducts[0] = p1;
        availableProducts[1] = p2;
        availableProducts[2] = p3;
        availableProducts[3] = p4;

        //create new customer account
        System.out.println("\nHello new shopper!");
        int newCustomerId =  readInputInt("\nPlease enter Your Customer Id");
        String newCustomerName = readInputString("\nPlease enter Your Name");
        Customer newCustomer = new Customer(newCustomerId, newCustomerName);
        System.out.println("\nWelcome to the Store, " + newCustomer.getCustomerName() + "!");

        String userChoice = "";	
        boolean continueShopping = true;

        //find out what the user wants to do
        do {
            String welcomeInstructions = "\nEnter P to list all available Products, C to view your Cart, or E to Exit";
            userChoice = readUserChoice(welcomeInstructions); 
            //IDEA could use switch statement instead of IF
            if (userChoice.toUpperCase().equals("P")) {
                showAvailableProducts();
                int newProductId = readInputInt("\nEnter Product Id to add it to your basket");
                //IDEA add an option to quit this menu, in case user decides not to add another product
                Product newProduct = findProductWithId(newProductId);
                if (newProduct != null ) {
                    //FYI no issues with adding multiple items to cart, as the cart array just keeps on growing
                    newCustomer.addToCart(newProduct);
                }
            }
            else if (userChoice.toUpperCase().equals("C")) {
                newCustomer.displayCart();
            }
            else if (userChoice.toUpperCase().equals("E")) {
                continueShopping = false;
            }
        } 
        while (continueShopping);
        System.out.println("Thanks for shopping with us, Bye");
    }

    public static void showAvailableProducts() {
        System.out.println("Available Products: ");
        if (availableProducts == null || availableProducts.length == 0) {
            System.out.println("There are no products in stock at present");
        } else {
            for (int i = 0; i < availableProducts.length; i++) {
                System.out.println(availableProducts[i].toString());
            }
        }
    }

    //read input as int for product id or cust id
    public static int readInputInt(String instructions) {
    int result = 0;
    boolean isValidInt = false;
    do {
        System.out.println(instructions);
        String input = lineScanner.nextLine();
        try {
            if (input == null || input.isEmpty()) {
                System.out.println("Oops, you didn't enter anything, a number was expected");
            } else {
                result  = Integer.parseInt(input);
                isValidInt = true;
            }
        } catch(NumberFormatException ex) {
            System.out.println("Input could not be read as a number");
        }
    } while (!isValidInt);
    return result;
    }

    //read input as string for cust name
    public static String readInputString(String instructions) {
    String userInput = "";
    boolean isValid = false;
    do {
        System.out.println(instructions);
        userInput = lineScanner.nextLine();        
        if (userInput == null ||userInput.isEmpty()) {
            System.out.println("Oops, you didn't enter anything, a string was expected");
        } else {
            isValid = true;
        }      
    } while (!isValid);
    return userInput;
    }

    //read user input to check what action user wants to do next
    public static String readUserChoice(String instructions) {
    String input = "";
    boolean isValid = false;
    do {
        System.out.println(instructions);
        input = lineScanner.nextLine();
        if (input == null || input.isEmpty()) {
            System.out.println("Oops, you didn't enter anything, char expected");
        } else {
            if (input.toUpperCase().equals("P") | input.toUpperCase().equals("C") | input.toUpperCase().equals("E")) {
                isValid = true;
            }
            else {
                isValid = false;
            }
        }
    } while (!isValid);
    return input;
    }

    private static Product findProductWithId(int id) {
        Product newProduct = null;
        boolean validProduct = false;
        for (int i = 0; i < availableProducts.length; i++) {
            if (availableProducts[i].getProductId() == id) {
                newProduct = availableProducts[i];
                validProduct = true;
            }
        }
        if (!validProduct) {
            System.out.println("Sorry, can't find a Product with that Id");
        }
        return newProduct;
    }
}
