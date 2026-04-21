package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_04_arrays_two_dimensional.q_01_first_missing_integer;

public class Solution {
    public int firstMissingPositive(int[] A) {
        int n = A.length;

        // shift elements to their appropriate index
        for (int i = 0; i < n; i++) {
            while (A[i] > 0 && A[i] <= n && A[i] != A[A[i] - 1]) {
                swap(A, i, A[i] - 1);
            }
        }

        // find the first missing integer
        for (int i = 0; i < n; i++) {
            if (A[i] != i + 1) return i + 1;
        }

        return n + 1;
    }

    // clean helper function
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
