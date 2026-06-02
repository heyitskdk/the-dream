package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_09_lab_session_on_recursion.additional_problems.q_01_is_magic;

public class Solution {
    public int solve(int A) {
        while (A/10 > 0) {
            A = sum(A);
        }

        return A == 1 ? 1 : 0;
    }

    private static int sum(int A) {
        // base case
        if (A == 0) return 0;

        // normal case
        return (A % 10) + sum(A/10);
    }
}
