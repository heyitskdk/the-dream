package org.heyitskdk.data_structures_and_algorithms.scaler.module_05_advanced_dsa_1.lecture_09_lab_session_on_recursion.assignment.q_03_fast_power;

public class Solution {
    public long power(int A, int B) {
        // edge cases
        if (A == 0) return 0;
        if (A == 1) return 1;

        // base case
        if (B == 0) return 1;

        long halfPower = power(A, B/2);
        if (B % 2 == 0) {
            return halfPower * halfPower;
        } else {
            return (long)A * halfPower * halfPower;
        }
    }
}
