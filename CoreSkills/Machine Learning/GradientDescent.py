"""
Problem: NeetCode - Gradient Descent
Author: Steve Eckardt
Revision Date: July 8, 2025

Performs gradient descent on the function f(x) = x² to approximate the minimum value starting from a given point.

Time Complexity: O(iterations)
Space Complexity: O(1)
"""

class Solution:
    def get_minimizer(self, iterations: int, learning_rate: float, init: int) -> float:
        minimum = init  # Start from the initial guess

        for _ in range(iterations):
            derivative = 2 * minimum  # Derivative of f(x) = x² is f'(x) = 2x
            minimum = minimum - learning_rate * derivative  # Move against the gradient

        return round(minimum, 5)  # Return result rounded to 5 decimal places
