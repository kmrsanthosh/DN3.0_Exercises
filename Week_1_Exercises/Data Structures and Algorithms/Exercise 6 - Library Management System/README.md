## Exercise 6: Library Management System

### Understanding Search Algorithms

1. Linear Search:

   - Sequentially checks each element in the list until a match is found or the end of the list is reached.
   - Works on both sorted and unsorted lists.
   - Time complexity: O(n) for both average and worst cases, where n is the number of elements.
   - Simple to implement but inefficient for large datasets.

2. Doubly Linked List:

   - Applies to sorted lists only.
   - Repeatedly divides the search interval in half.
   - Compares the middle element with the target value.
   - Time complexity: O(log n) for both average and worst cases.
   - More efficient for large datasets but requires the list to be sorted.

### Analysis

Time complexity comparison:

1. Linear Search:

   - Best case: O(1)
   - Average case: O(n)
   - Worst case: O(n)

2. Binary Search:

   - Best case: O(1)
   - Average case: O(log n)
   - Worst case: O(log n)
