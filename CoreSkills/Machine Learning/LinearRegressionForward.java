/**
 * Problem: NeetCode Linear Regression (Forward)
 * Author: Steve Eckardt
 * Revision Date: July 16, 2025
 *
 * Description:
 *     Implements forward-pass linear regression by computing predictions from input data
 *     using matrix multiplication, then evaluates error using mean squared error.
 *
 * Time Complexity:
 *     - getModelPrediction: O(N * D) where N = number of samples, D = number of features
 *     - getError: O(N), to compute mean squared difference
 *
 * Space Complexity:
 *     - O(N) for storing prediction and squared differences
 */


import java.util.Arrays;

public class Solution {

    // Compute model prediction: X @ weights, rounded to 5 decimal places
    public double[] getModelPrediction(double[][] X, double[] weights) {
        int rows = X.length;
        int cols = X[0].length;
        double[] prediction = new double[rows];

        for (int i = 0; i < rows; i++) {
            double sum = 0;
            for (int j = 0; j < cols; j++) {
                sum += X[i][j] * weights[j];
            }
            prediction[i] = round(sum, 5);
        }

        return prediction;
    }

    // Compute mean squared error between prediction and ground truth
    public double getError(double[] prediction, double[] groundTruth) {
        if (prediction.length != groundTruth.length) {
            throw new IllegalArgumentException("Arrays must be the same length.");
        }

        double sumSquaredError = 0.0;
        for (int i = 0; i < prediction.length; i++) {
            double diff = prediction[i] - groundTruth[i];
            sumSquaredError += diff * diff;
        }

        double mse = sumSquaredError / prediction.length;
        return round(mse, 5);
    }

    // Utility method to round to given number of decimal places
    private double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
