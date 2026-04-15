package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_03_arrays_one_dimensional.assigment.q_02_continuous_sum_query;

public class Solution {
    public int[] solve(int A, int[][] B) {
        int[] pots = new int[A];

        for (int[] donation: B) {
            int left = donation[0] - 1;
            int right = donation[1] - 1;
            int coins = donation[2];

            pots[left] += coins;
            if (right + 1 < A) pots[right + 1] -= coins;
        }

        for (int i = 1; i < A; i++) {
            pots[i] += pots[i - 1];
        }

        return pots;
    }
}
