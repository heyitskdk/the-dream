package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_02_arrays_techniques.additional_problems.q_03_subarray_with_least_average;

public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        int subarraySum = leftWindowSum(A, B);

        int answer = 0;
        int minimumSum = subarraySum;
        int leftIndex = 0, rightIndex = B;

        while (rightIndex < n) {
            subarraySum += A[rightIndex] - A[leftIndex];
            // this condition automatically stores only the first index of least sum occurence
            if (subarraySum < minimumSum) {
                minimumSum = subarraySum;
                answer = leftIndex + 1;
            }

            leftIndex++; rightIndex++;
        }

        return answer;
    }

    private int leftWindowSum(int[] A, int B) {
        int leftSum = 0;
        for (int i = 0; i < B; i++) leftSum += A[i];
        return leftSum;
    }
}
