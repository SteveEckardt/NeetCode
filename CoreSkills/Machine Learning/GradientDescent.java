/**
 * Problem: NeetCode - Gradient Descent
 * Author: Steve Eckardt
 * Revision Date: July 8, 2025
 * 
 * Performs gradient descent on the function f(x) = x² to approximate the minimum value starting from a given point.
 * 
 * Time Complexity: O(iterations)
 * Space Complexity: O(1)
 */

public class GradientDescent {

    // Method to perform gradient descent
    public static double getMinimizer(int iterations, double learningRate, 
														double init) {
        double minimizer = init;

        for (int i = 0; i < iterations; i++) {
            double derivative = 2 * minimizer; // derivative of f(x) = x^2 is f'(x) = 2x
            minimizer = minimizer - learningRate * derivative; // gradient descent update
        }

        return Math.round(minimizer * 100000.0) / 100000.0; // round to 5 decimal places
    }

    public static void main(String[] args) {
        int iterations = 1000;
        double learningRate = 0.1;
        double initialValue = 10.0;

        double result = getMinimizer(iterations, learningRate, initialValue);
        System.out.println("Minimum found at: " + result);
    }
}
