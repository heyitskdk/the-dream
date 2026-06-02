package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_09_lab_session_on_recursion.assignment.q_02_all_indices_of_an_array;

public class Solution {
    public int[] allIndices(int[] A, int B) {
        return solve(A, B, 0 , 0);
    }

    private static int[] solve(int[] A, int B, int i, int count) {
        // base case
        if (i == A.length) return new int[count];

        // normal case
        int [] res;
        if (A[i] == B) {
            res = solve(A, B, i + 1, count + 1);
            res[count] = i;
        } else {
            res = solve(A, B, i + 1, count);
        }

        return res;
    }
}
