## Exercise 3: Sorting Customer Orders

### Understanding Sorting Algorithms

1. Bubble Sort:

   - Simple algorithm that repeatedly steps through the list, compares adjacent elements and swaps them if they're in the wrong order.
   - Time complexity: O(n²) in worst and average cases, O(n) in best case (already sorted).
   - Space complexity: O(1)
   - Advantages: Easy to understand and implement.
   - Disadvantages: Very inefficient for large datasets.

2. Insertion Sort:

   - Builds the final sorted array one item at a time, by repeatedly inserting a new element into the sorted portion of the array.
   - Time complexity: O(n²) in worst and average cases, O(n) in best case (already sorted).
   - Space complexity: O(1)
   - Advantages: Efficient for small datasets, adaptive (efficient for nearly sorted arrays).
   - Disadvantages: Inefficient for large datasets.

3. Quick Sort:

   - Uses a divide-and-conquer strategy. It picks an element as a pivot and partitions the array around the pivot.
   - Time complexity: O(n log n) on average and best case, O(n²) in worst case (rare with good pivot selection).
   - Space complexity: O(log n) due to recursive calls.
   - Advantages: Very efficient for large datasets, in-place sorting.
   - Disadvantages: Unstable sort, worst-case scenario can be problematic.

4. Merge Sort:

   - Also uses a divide-and-conquer approach. It divides the array into two halves, sorts them recursively, and then merges the sorted halves.
   - Time complexity: O(n log n) in all cases.
   - Space complexity: O(n)
   - Advantages: Stable sort, predictable performance.
   - Disadvantages: Requires additional space.

### Analysis

Time complexity analysis for each operation:

1. Bubble Sort:

   - Best case: O(n) - when the array is already sorted
   - Average case: O(n²)
   - Worst case: O(n²)

2. Quick Sort:

   - Best case: O(n log n)
   - Average case: O(n log n)
   - Worst case: O(n²)

While Bubble Sort can be used for smaller datasets, Quick Sort is more effective for larger datasets
