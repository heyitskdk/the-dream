package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_08_recursion.assignment.q_04_print_one_to_a;

public class Solution {
    public void solve(int A) {
        print(A, A);
    }

    private static void print(int n, int limit) {
        // base case
        if (n < 1) return;

        // normal case
        print(n - 1, limit);
        System.out.printf("%d ", n);

        // new line
        if (n == limit) System.out.println();
    }
}
