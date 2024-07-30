## Exercise 7: Financial Forecasting

### Understanding Recursive Algorithms

Recursion is a programming concept where a function calls itself to solve a problem by breaking it down into smaller, similar sub-problems. A recursive algorithm consists of two main parts:

1. Base case: A simple condition that stops the recursion.
2. Recursive case: The part where the function calls itself with a modified input.

Recursion can simplify certain problems by:

- Making code more readable and easier to understand for inherently recursive problems.
- Reducing complex problems into simpler sub-problems.
- Eliminating the need for explicit loop constructs.
- Naturally implementing divide-and-conquer algorithms.

### Analysis

Time Complexity:

1. For calculateFutureValue:

   - Time Complexity: O(n), where n is the number of years.

2. For predictFutureValues:

   - Time Complexity: O(m \* n), where m is the number of past values and n is the number of years to predict.
