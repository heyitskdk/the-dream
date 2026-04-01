package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_02_arrays_techniques.assignment.q_04_subarray_with_given_sum_and_length;

public class Solution {
    public int solve(int[] A, int B, int C) {
        int n = A.length;

        // edge case - B is greater than length of input array
        if (B > n) return 0;

        // pre-calculate sum of first window
        long windowSum = calculateWindowSum(A, B);

        // lucky check
        if (windowSum == C) return 1;

        int startIndex = 0, endIndex = B;
        while (endIndex < n) {
            windowSum += A[endIndex] - A[startIndex];

            if (windowSum == C) return 1;

            startIndex++; endIndex++;
        }

        return 0;
    }

    public long calculateWindowSum(int[] A, int B) {
        long windowSum = 0;
        for (int i = 0; i < B; i++) {
            windowSum += A[i];
        }

        return windowSum;
    }
}

