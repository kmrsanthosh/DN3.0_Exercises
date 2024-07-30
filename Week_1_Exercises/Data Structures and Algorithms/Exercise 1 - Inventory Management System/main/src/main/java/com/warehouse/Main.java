package com.warehouse;

public class Main {
    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        System.out.println("Before adding products:");

        for (Product product : ims.getAllProducts()) {
            System.out.println(product);
        }

        ims.addProduct(new Product("P001", "Laptop", 10, 999.99));
        ims.addProduct(new Product("P002", "Smartphone", 20, 499.99));

        System.out.println("\n\nAfter adding products:");

        for (Product product : ims.getAllProducts()) {
            System.out.println(product);
        }

        ims.updateProduct("P001", "Gaming Laptop", 5, 1499.99);

        System.out.println("\n\nAfter updating the product:");

        for (Product product : ims.getAllProducts()) {
            System.out.println(product);
        }

        ims.deleteProduct("P002");

        System.out.println("\n\nAfter deleting the product:");

        for (Product product : ims.getAllProducts()) {
            System.out.println(product);
        }
    }
}