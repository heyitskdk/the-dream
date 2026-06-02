package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_08_recursion.additional_problems.q_04_print_a_to_one;

public class Solution {
    public void solve(int A) {
        print(A, A);
    }
    private static void print(int n, int limit) {
        // base case
        if (n == 0) return;

        // normal case
        System.out.printf("%d ", n);
        print(n- 1, n);

        // new line
        if (n == limit) System.out.println();
    }
}
