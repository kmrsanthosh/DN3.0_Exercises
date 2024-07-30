## Exercise 1: Inventory Management System

### Understanding the problem

Efficient data structures and algorithms are crucial for handling large inventories in a warehouse management system for several reasons:

1. **Fast retrieval:** With thousands of products, finding a specific item quickly is essential.
2. **Efficient updates:** As stock levels change frequently, updating product information should be fast.
3. **Scalability:** The system should perform well as the inventory grows.
4. **Memory efficiency:** Storing large amounts of data requires optimized use of memory.

Suitable data structures for this problem include:

1. **HashMap:** Offers O(1) average time complexity for insertion, deletion, and retrieval operations.
2. **ArrayList:** Provides dynamic sizing and fast random access, useful for listing all products.
3. **TreeMap:** Maintains a sorted order of products, beneficial for range queries or sorted views.

For this exercise, we'll use a combination of HashMap (for fast individual product access) and ArrayList (for listing all products).

### Analysis

Time complexity analysis for each operation:

1. **Add (addProduct):** O(1) average case, as HashMap offers constant-time insertion.
2. **Update (updateProduct):** O(1) average case for finding and updating the product.
3. **Delete (deleteProduct):** O(1) average case for removing an item from HashMap.
4. **Retrieve (getProduct):** O(1) average case for fetching a product by ID.
5. **List all (getAllProducts):** O(n) where n is the number of products, as we create a new ArrayList from all values.
