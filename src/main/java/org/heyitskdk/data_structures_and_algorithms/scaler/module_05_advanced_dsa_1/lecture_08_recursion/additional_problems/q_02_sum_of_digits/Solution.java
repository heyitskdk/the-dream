package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_08_recursion.additional_problems.q_02_sum_of_digits;

public class Solution {
    public int solve(int A) {
        // base case
        if (A == 0) return 0;

        // normal case
        return (A % 10) + solve(A / 10);
    }
}
