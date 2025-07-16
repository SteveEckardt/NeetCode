"""
Problem: NeetCode Linear Regression (Forward)
Author: Steve Eckardt
Revision Date: July 16, 2025

Description:
    Implements forward-pass linear regression by computing predictions from input data
    and evaluating error using mean squared error.

Time Complexity:
    - get_model_prediction: O(N * D) where N is number of samples, D is number of features
    - get_error: O(N), to compute mean squared difference

Space Complexity:
    - O(N) for storing prediction and squared differences
"""

import numpy as np
from numpy.typing import NDArray

class Solution:

    def get_model_prediction(self, X: NDArray[np.float64], weights: NDArray[np.float64]) -> NDArray[np.float64]:
        # Compute dot product of inputs and weights
        prediction = np.matmul(X, weights)
        # Round to 5 decimal places for consistency
        return np.round(prediction, 5)

    def get_error(self, model_prediction: NDArray[np.float64], ground_truth: NDArray[np.float64]) -> float:
        # Compute mean squared error between prediction and ground truth
        error = np.mean(np.square(model_prediction - ground_truth))
        # Round to 5 decimal places for readability
        return round(error, 5)
