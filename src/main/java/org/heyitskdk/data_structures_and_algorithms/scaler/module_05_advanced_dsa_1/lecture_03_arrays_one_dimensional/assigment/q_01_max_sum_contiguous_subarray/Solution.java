package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_03_arrays_one_dimensional.assigment.q_01_max_sum_contiguous_subarray;

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxSubArray(final int[] A) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            currentSum += A[i];
            maxSum = Math.max(currentSum, maxSum);

            if (currentSum < 0) currentSum = 0;
        }

        return maxSum;
    }
}
