package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_04_arrays_two_dimensional.additional_problems.q_02_row_with_maximum_number_of_ones;

public class Solution {
    public int solve(int[][] A) {
        // approach - staircase navigation, carry fwd count of max ones
        int n = A.length, m = A[0].length;
        int row = 0;

        // top-right corner
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            int num = A[i][j];
            if (num == 1) {
                row = i;
                j--;
            } else {
                i++;
            }
        }

        return row;
    }
}
