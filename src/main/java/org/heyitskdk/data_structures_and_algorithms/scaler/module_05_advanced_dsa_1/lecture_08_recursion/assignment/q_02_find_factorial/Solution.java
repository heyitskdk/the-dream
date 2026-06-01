package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_08_recursion.assignment.q_02_find_factorial;

public class Solution {
    public int solve(int A) {
        // base case
        if (A <= 1) return 1;

        // normal case
        return A * solve(A - 1);
    }
}
