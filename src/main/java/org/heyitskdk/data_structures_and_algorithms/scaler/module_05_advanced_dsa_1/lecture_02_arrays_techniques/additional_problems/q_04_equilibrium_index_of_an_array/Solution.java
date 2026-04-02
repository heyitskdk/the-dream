package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_02_arrays_techniques.additional_problems.q_04_equilibrium_index_of_an_array;

public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        long totalSum = getTotalSum(A);

        // initializing it with 0, due to no existing prefix sum before for index 0
        long prefixSum = 0;

        for (int i = 0; i < n; i++) {
            long suffixSum = totalSum - prefixSum - A[i];

            if (prefixSum == suffixSum) {
                return i;
            }
            prefixSum += A[i];
        }

        return -1;
    }

    private long getTotalSum(int[] A) {
        long totalSum = 0;
        for (int num : A) totalSum += num;
        return totalSum;
    }
}
