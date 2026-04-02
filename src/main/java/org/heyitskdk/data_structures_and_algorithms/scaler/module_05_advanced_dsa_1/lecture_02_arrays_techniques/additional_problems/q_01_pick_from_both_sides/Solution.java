package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_02_arrays_techniques.additional_problems.q_01_pick_from_both_sides;

public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        int currentSum = leftSum(A, B);
        int answer = currentSum;

        int leftIndex = B - 1, rightIndex = n - 1;
        while (leftIndex >= 0) {
            currentSum += A[rightIndex] - A[leftIndex];
            answer = Math.max(answer, currentSum);

            leftIndex--;
            rightIndex--;
        }

        return answer;
    }

    private int leftSum(int[] A, int B) {
        int windowSum = 0;

        for (int i = 0; i < B; i++) windowSum += A[i];

        return windowSum;
    }
}
