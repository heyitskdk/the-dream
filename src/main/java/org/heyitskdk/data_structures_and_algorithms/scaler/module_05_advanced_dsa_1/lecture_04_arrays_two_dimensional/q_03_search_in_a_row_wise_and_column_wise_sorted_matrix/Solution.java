package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_04_arrays_two_dimensional.q_03_search_in_a_row_wise_and_column_wise_sorted_matrix;

public class Solution {
    public int solve(int[][] A, int B) {
        // approach - select corner (top-right / bottom-left) and navigate in staircase pattern
        int n = A.length, m = A[0].length;
        int position = Integer.MAX_VALUE;

        // top-right corner
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            int num = A[i][j];
            if (num == B) {
                // question follows 1 based indexing
                position = Math.min(position, ((i + 1) * 1009 + (j + 1)));
                j--;
            } else if (num > B) {
                j--;
            } else {
                i++;
            }
        }

        return position == Integer.MAX_VALUE ? -1 : position;
    }
}
