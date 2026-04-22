package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_04_arrays_two_dimensional.q_02_sum_of_all_submatrices;

public class Solution {
    public int solve(int[][] A) {
        // approach - contribution technique
        int n = A.length;
        int m = A[0].length;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // forcing the operation to be done in long
                long topLefts = 1L * (i + 1) * (j + 1);
                long bottomRights = 1L * (n - i) * (m - j);
                sum += 1L * A[i][j] * topLefts * bottomRights;
            }
        }

        return (int) sum;
    }
}
