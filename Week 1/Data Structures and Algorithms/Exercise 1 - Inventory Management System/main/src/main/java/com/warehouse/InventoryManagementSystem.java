package com.warehouse;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class InventoryManagementSystem {
    private HashMap<String, Product> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(String productId, String productName, int quantity, double price) {
        if (inventory.containsKey(productId)) {
            Product product = inventory.get(productId);
            product.setProductName(productName);
            product.setQuantity(quantity);
            product.setPrice(price);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(inventory.values());
    }
}