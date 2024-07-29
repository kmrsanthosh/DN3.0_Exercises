import java.util.Arrays;

public class SearchAlgorithms {

    public static int linearSearch(Product[] products, String productId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId().equals(productId)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Product[] products, String productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductId().compareTo(productId);

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product("P001", "Laptop", "Electronics"),
                new Product("P002", "Smartphone", "Electronics"),
                new Product("P003", "Headphones", "Electronics"),
                new Product("P004", "Book", "Literature"),
                new Product("P005", "Desk Chair", "Furniture")
        };

        long startTime = System.nanoTime();
        int linearResult = linearSearch(products, "P004");
        long endTime = System.nanoTime();
        System.out.println("Linear Search Result: " + linearResult);
        System.out.println("Linear Search Time: " + (endTime - startTime) + " ns");

        Arrays.sort(products);

        startTime = System.nanoTime();
        int binaryResult = binarySearch(products, "P004");
        endTime = System.nanoTime();
        System.out.println("Binary Search Result: " + binaryResult);
        System.out.println("Binary Search Time: " + (endTime - startTime) + " ns");
    }
}