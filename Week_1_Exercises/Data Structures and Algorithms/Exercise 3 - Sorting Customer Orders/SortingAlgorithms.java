import java.util.Arrays;

public class SortingAlgorithms {

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].compareTo(orders[j + 1]) > 0) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        Order pivot = orders[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].compareTo(pivot) <= 0) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Order[] orders = {
                new Order("O001", "Alice", 150.0),
                new Order("O002", "Bob", 99.99),
                new Order("O003", "Charlie", 199.99),
                new Order("O004", "David", 75.50),
                new Order("O005", "Eve", 125.0)
        };

        // Bubble Sort
        Order[] bubbleSortOrders = Arrays.copyOf(orders, orders.length);
        long startTime = System.nanoTime();
        bubbleSort(bubbleSortOrders);
        long endTime = System.nanoTime();
        System.out.println("Bubble Sort Time: " + (endTime - startTime) + " ns");
        System.out.println("\nBubble Sorted Orders: " + Arrays.toString(bubbleSortOrders));

        // Quick Sort
        Order[] quickSortOrders = Arrays.copyOf(orders, orders.length);
        startTime = System.nanoTime();
        quickSort(quickSortOrders, 0, quickSortOrders.length - 1);
        endTime = System.nanoTime();
        System.out.println("\n\nQuick Sort Time: " + (endTime - startTime) + " ns");
        System.out.println("\nQuick Sorted Orders: " + Arrays.toString(quickSortOrders));
    }
}