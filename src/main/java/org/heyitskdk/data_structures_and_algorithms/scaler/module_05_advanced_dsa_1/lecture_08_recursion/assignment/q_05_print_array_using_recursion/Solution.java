package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_08_recursion.assignment.q_05_print_array_using_recursion;

public class Solution {
    public void PrintArray(int[] A) {
        print(A, 0);
    }

    private static void print(int[] A, int i) {
        //base case
        if (i == A.length) return;

        // normal case
        System.out.printf("%d ", A[i]);
        print(A, i + 1);

        // platform issue correction
        if (i == 0) System.out.println();
    }
}
