package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_02_arrays_techniques.assignment.q_01_range_sum_query;

public class Solution {
    public long[] rangeSum(int[] A, int[][] B) {
        // creating prefix sum array
        long[] prefixSum = createPrefixSumArray(A);

        return returnSumInRange(prefixSum, B);
    }

    public static long[] createPrefixSumArray(int[] A) {
        int n = A.length;

        long[] prefixSum = new long[n];
        prefixSum[0] = A[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }

        return prefixSum;
    }

    public static long[] returnSumInRange(long[] prefixSum, int[][] B) {
        int m = B.length;
        long[] answer = new long[m];

        for (int i = 0; i < m; i++) {
            int leftIndex = B[i][0];
            int rightIndex = B[i][1];

            if(leftIndex > 0) {
                answer[i] = prefixSum[rightIndex] - prefixSum[leftIndex - 1];
            } else {
                answer[i] = prefixSum[rightIndex];
            }
        }

        return answer;
    }
}

